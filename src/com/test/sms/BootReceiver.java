package com.test.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
	private static final String action_boot = "android.intent.action.BOOT_COMPLETED";

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(action_boot)) {
			Intent bootStartIntent = new Intent(context,
					SMSBroadcastReceiver.class);
			bootStartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startService(bootStartIntent);
			System.err.println("___________________start_____________");
		}
		// TODO Auto-generated method stub

	}

	/*
	 * 
	 * private String LOG = "BootReceiver";
	 * 
	 * @Override public void onReceive(Context arg0, Intent arg1) {
	 * 
	 * // TODO Auto-generated method stub
	 * 
	 * Log.i(LOG, "onReceive");
	 * 
	 * Intent mBootIntent = new Intent(arg0, SMSBroadcastReceiver.class);
	 * 
	 * arg0.startService(mBootIntent);
	 * 
	 * }
	 */
}
