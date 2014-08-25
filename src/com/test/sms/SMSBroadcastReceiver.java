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
					String msg = "���ͺ��룺" + SMSAddress + "\n" + "�������ݣ�"
							+ SMSContent;
					System.out.println("���ͺ��룺" + SMSAddress + "\n" + "�������ݣ�"
							+ SMSContent);
					System.err.println(msg);
//					SendMail(msg);
				}
			}
		}
	}
	//
	// private void sendSMS(String sender, String body, String date) {
	// System.err.println("������"+sender+"����"+body+"ʱ��"+date);
	//
	// }

/*	private void SendMail(String msg) {
		SimpleEmail email = new SimpleEmail();
		email.setTLS(true);
		email.setHostName("smtp.qq.com");
		email.setAuthentication("zwk1729@foxmail.com", "10110"); // �û���������
		try {
			email.addTo("zwk1729@foxmail.com"); // ���շ�
			email.setFrom("zwk1729@foxmail.com"); // ���ͷ�
			email.setSubject("Java Mail Test"); // ����
			email.setMsg(msg); // ����
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}*/

	

}
