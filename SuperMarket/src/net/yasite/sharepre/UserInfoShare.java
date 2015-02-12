package net.yasite.sharepre;

import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

@SuppressLint("CommitPrefEdits")
public class UserInfoShare {
	private Context context;

	public UserInfoShare(Context context) {
		super();
		this.context = context;
	}
	
	
	public void insertUserInfo(String name,int mode,String username,String pass,String user_id,String token){
		SharedPreferences preferences = context.getSharedPreferences(name, mode);
		Editor editor = preferences.edit();
		editor.putString("username", username);
		editor.putString("pass", pass);
		editor.putString("user_id", user_id);
		editor.putString("token", token);
		editor.commit();
	}
	public Map<String, ?> getUserInfo(String name,int mode){
		SharedPreferences preferences = context.getSharedPreferences(name, mode);
		return preferences.getAll();
	}
	public void idsertGoodsid(String name,int mode,int goods_id){
		SharedPreferences preferences = context.getSharedPreferences(name, mode);
		Editor editor = preferences.edit();
		editor.putInt("goods_id", goods_id);
		editor.commit();
	}
	public int getGoodsId(String name,int mode){
		SharedPreferences preferences = context.getSharedPreferences(name, mode);
		return preferences.getInt("goods_id", 0);
	}
	public void insertUserId(String name,int mode,String user_id){
		SharedPreferences preferences = context.getSharedPreferences(name, mode);
		Editor editor = preferences.edit();
		editor.putString("user_id", user_id);
		editor.commit();
	}
	public String getUserId(String name,int mode){
		SharedPreferences preferences = context.getSharedPreferences(name, mode);
		return preferences.getString("user_id", "");
	}
}
