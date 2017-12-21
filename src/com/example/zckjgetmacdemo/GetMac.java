package com.example.zckjgetmacdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class GetMac {

	public static String getEthMacAddress() {
		String str = "";
		String result = "";
		File fl;

		try {
			str = "/sys/class/net/eth0/address";
			fl = new File(str);
			if (fl.exists()) {
				result = loadFileAsString(str).toUpperCase(Locale.CHINA).substring(0, 17);
			}
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String getWifiMacAddress() {
		String str = "";
		String result = "";
		File fl;

		try {
			str = "/sys/class/net/wlan0/address";
			fl = new File(str);
			if (fl.exists()) {
				result = loadFileAsString(str).toUpperCase(Locale.CHINA).substring(0, 17);
			}
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getMacAddress() {
		String str = "";
		String result = "";
		File fl;

		try {
			str = "/sys/class/net/eth0/address";
			fl = new File(str);
			if (fl.exists()) {
				result = loadFileAsString(str).toUpperCase(Locale.CHINA).substring(0, 17);
			} else {
				str = "/sys/class/net/wlan0/address";
				fl = new File(str);
				if (fl.exists()) {
					result = loadFileAsString(str).toUpperCase(Locale.CHINA).substring(0, 17);
				}
			}
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String loadFileAsString(String filePath) throws java.io.IOException {
		StringBuffer fileData = new StringBuffer(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
		}
		reader.close();
		return fileData.toString();
	}

}
// 修改于:2015年06月30日 周二
