package com.pan.hjms;

import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.util.HashMap;

/**
 * 数据初始化，头信息管理
 * 
 * @author PengGuoHua {@link guohua_peng@bacic5i5j.com}
 * 
 * @Date 2015-05-13
 * @version
 */
public class Apn {
	/** 是否上线 */
	public static boolean onLine = true;
	/** 当前版本号 */
	public static String version = "";
	/** VersionCode */
	public static int versionCode;

	private static Context context;
	/** 设备唯一标识 */
	public static String imei = "";
	/** 手机系统版本 */
	public static final String osVersion = android.os.Build.VERSION.RELEASE;
	/** 手机型号 */
	public static final String model = android.os.Build.MODEL;
	/** 手机号 */
	public static String phonenumber = "";
	/** 联网方式 */
	public static String connmode = "";
	/** 渠道号 */
	public static String channel = "";

	public static String getVersion() {
		if (TextUtils.isEmpty(version)) {
			init();
		}
		return version;
	}

	/**
	 * 初始一些通用的参数
	 */

	public static void init() {
		context = HjmsApp.getSelf();
		PackageManager packageManager = context.getPackageManager();
		TelephonyManager telephonyManager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		try {
			version = packageManager
					.getPackageInfo(context.getPackageName(), 0).versionName;
			versionCode = packageManager.getPackageInfo(
					context.getPackageName(), 0).versionCode;
			imei = telephonyManager.getDeviceId();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addHeads(HashMap<String,String> params) {
//		RequestParams params = new RequestParams(NetConstants.ENCODING);
//		if (!TextUtils.isEmpty(HjmsApp.getSelf().getToken())) {
			params.put("token", "5b751447c91f4023b043bd0e23909f02"/*HjmsApp.getSelf().getToken()*/);
//		}
		params.put("loginEntry", "1");
		params.put("APPVERSION", version);// 版本号
		params.put("DEVICEID", imei);// 手机串号
		params.put("DEVICETYPE", model);// 手机型号
		params.put("OSVERSION", osVersion);// 手机系统版本
		params.put("APPNAME", "moshou");
//		if (!TextUtils.isEmpty(HjmsApp.getSelf().getCityName())) {
//			try {
//				params.addHeader("city", URLEncoder.encode(HjmsApp.getSelf()
//						.getCityName(), NetConstants.ENCODING));
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//		}
//		params.put("deviceSource ", "1");
//		return params;
	}

}
