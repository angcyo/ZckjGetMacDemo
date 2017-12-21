package com.example.zckjgetmacdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void getEthMac(View view) {
		((TextView) findViewById(R.id.etg_mac)).setText("有线MAC--> " + GetMac.getEthMacAddress());
	}

	public void getWifiMac(View view) {
		((TextView) findViewById(R.id.wifi_mac)).setText("无线MAC--> " + GetMac.getWifiMacAddress());
	}
}
