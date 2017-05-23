package com.makemytrip.utils;

public class CommonUtil {

	public static void waitInSeconds(long sec) {

		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
