package com.test.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

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
//					SendMail(msg);
				}
			}
		}
	}
	//
	// private void sendSMS(String sender, String body, String date) {
	// System.err.println("发送者"+sender+"内容"+body+"时间"+date);
	//
	// }

/*	private void SendMail(String msg) {
		SimpleEmail email = new SimpleEmail();
		email.setTLS(true);
		email.setHostName("smtp.qq.com");
		email.setAuthentication("zwk1729@foxmail.com", "10110"); // 用户名和密码
		try {
			email.addTo("zwk1729@foxmail.com"); // 接收方
			email.setFrom("zwk1729@foxmail.com"); // 发送方
			email.setSubject("Java Mail Test"); // 标题
			email.setMsg(msg); // 内容
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}*/

	

}
