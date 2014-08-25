package com.test.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* 在Android系统中，有界面的app一定是有Activity的，没有界面的app，那就是一个Service了。

 Service如何启动呢？办法和Activity的启动一样，也是Intent对象。我讲的是如何写一个开机后台启动的app。

 首先是AndroidMainfest注册开机启动权限：


 还要注册广播消息接受者：




 接下来是广播接收者：
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
