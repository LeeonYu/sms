package com.test.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* ��Androidϵͳ�У��н����appһ������Activity�ģ�û�н����app���Ǿ���һ��Service�ˡ�

 Service��������أ��취��Activity������һ����Ҳ��Intent�����ҽ��������дһ��������̨������app��

 ������AndroidMainfestע�Ὺ������Ȩ�ޣ�


 ��Ҫע��㲥��Ϣ�����ߣ�




 �������ǹ㲥�����ߣ�
 */
public class BootReceiver extends BroadcastReceiver {
	private static final String action_boot="android.intent.action.BOOT_COMPLETED"; 
	  

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(action_boot)){ 
            Intent ootStartIntent=new Intent(context,SMSBroadcastReceiver.class); 
            ootStartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
            context.startService(ootStartIntent);
            System.err.println("___________________start_____________");
        }
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*

	private String LOG = "BootReceiver";

	@Override
	public void onReceive(Context arg0, Intent arg1) {

		// TODO Auto-generated method stub

		Log.i(LOG, "onReceive");

		Intent mBootIntent = new Intent(arg0, SMSBroadcastReceiver.class);

		arg0.startService(mBootIntent);

	}

*/}
