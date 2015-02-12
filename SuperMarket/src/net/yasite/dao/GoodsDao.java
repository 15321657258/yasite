package net.yasite.dao;

import java.util.ArrayList;
import java.util.List;

import net.yasite.entity.GoodsCarEntity;
import net.yasite.util.DbUtil;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class GoodsDao {
	private Context context;
	private DbUtil dbUtil;
	private SQLiteDatabase database;
	public GoodsDao(Context context) {
		super();
		this.context = context;
		dbUtil = new DbUtil(context, "selectname.db", null, 1);
	}
	public void insert(String name,int zhong){
		database = dbUtil.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("tiao", zhong);
		database.insert("goodsname", null, values);
		database.close();
	}
	public List<String> select(int zhong){
		List<String> list = new ArrayList<String>();
		database = dbUtil.getWritableDatabase();
		Cursor cursor = database.query("goodsname", null, "tiao="+zhong, null, null, null, null);
		while (cursor.moveToNext()) {
			String name = cursor.getString(cursor.getColumnIndex("name"));
			list.add(name);
		}
		cursor.close();
		database.close();
		return list;
	}
	public void insertToCar(String goods_id,String image,String user,String name,String price,String user_id){
		database = dbUtil.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("goods_id", goods_id);
		values.put("image", image);
		values.put("user", user);
		values.put("name", name);
		values.put("price", price);
		values.put("user_id", user_id);
		database.insert("car", null, values );
		database.close();
	}
	public List<GoodsCarEntity> getCar(String users){
		List<GoodsCarEntity> list = new ArrayList<GoodsCarEntity>();
		database = dbUtil.getWritableDatabase();
		GoodsCarEntity carEntity = null;
		Cursor cursor = database.query("car", null, "user="+users, null, null, null, null);
		while(cursor.moveToNext()){
			String goods_id = cursor.getString(cursor.getColumnIndex("goods_id"));
			String user = cursor.getString(cursor.getColumnIndex("user"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String image = cursor.getString(cursor.getColumnIndex("image"));
			String price = cursor.getString(cursor.getColumnIndex("price"));
			String user_id = cursor.getString(cursor.getColumnIndex("user_id"));
			carEntity = new GoodsCarEntity(goods_id,image,user,name,price,user_id);
			list.add(carEntity);
		}
		cursor.close();
		database.close();
		return list;
	}
	
}
