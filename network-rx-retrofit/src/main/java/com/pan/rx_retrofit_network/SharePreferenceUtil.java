package com.pan.rx_retrofit_network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * SharePreference工具类
 * 
 * @author PengGuoHua
 * {@link guohua_peng@bacic5i5j.com}
 * 
 * @Date 2015-05-13
 * @version 
 */
public class SharePreferenceUtil {
	
	private SharedPreferences sharedPreferences;
	private Context context;
	private String sharename;
	
	public SharePreferenceUtil(Context context, String sharename){
		this.context = context;
		this.sharename = sharename;
		getSharedPreferences();
	}
	
	public SharedPreferences getSharedPreferences(){
		sharedPreferences = context.getSharedPreferences(sharename, Context.MODE_PRIVATE);
		return sharedPreferences;
	}
	
	public void setString(String key,String value){
	    Editor editor = sharedPreferences.edit();
	    editor.putString(key, value);
	    editor.commit();
	}
	
	public String getString(String key,String defaultvaule){
		String value = sharedPreferences.getString(key, defaultvaule);
		return value;
	}
	
	public void deleteString(String key){
		 Editor editor = sharedPreferences.edit();
		 editor.remove(key);
		 editor.commit();
	}
	
	public void setBoolean(String key,Boolean value){
	    Editor editor = sharedPreferences.edit();
	    editor.putBoolean(key, value);
	    editor.commit();
	}
	
	public Boolean getBoolean(String key,Boolean defaultvalue){
		Boolean value = sharedPreferences.getBoolean(key, defaultvalue);
		return value;
	}
	
	public void setInt(String key,int value){
	    Editor editor = sharedPreferences.edit();
	    editor.putInt(key, value);
	    editor.commit();
	}
	
	public int getInt(String key,int defaultvalue){
		int value = sharedPreferences.getInt(key, defaultvalue);
		return value;
	}
	public void deleteInt(String key){
		Editor editor = sharedPreferences.edit();
		editor.remove(key);
		editor.commit();
	}
	
	public void setFloat(String key,float value){
	    Editor editor = sharedPreferences.edit();
	    editor.putFloat(key, value);
	    editor.commit();
	}
	
	public float getFloat(String key,float defaultvalue){
		float value = sharedPreferences.getFloat(key, defaultvalue);
		return value;
	}
	
	public void setLong(String key,long value){
	    Editor editor = sharedPreferences.edit();
	    editor.putLong(key, value);
	    editor.commit();
	}
	
	public long getLong(String key,long defaultvalue){
		long value = sharedPreferences.getLong(key, defaultvalue);
		return value;
	}

}
