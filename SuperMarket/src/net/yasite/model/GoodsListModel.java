package net.yasite.model;

import net.yasite.entity.ClassifyDataEntity;
import net.yasite.entity.GoodListEntity;
import net.yasite.entity.UserCarDataEntity;
import net.yasite.entity.UserInfoData;
import net.yasite.service.GoodsService;
import android.content.Context;

public class GoodsListModel extends Model {
	GoodsService service;

	public GoodsListModel(Context context) {
		this.context = context;
		service = new GoodsService(context);
	}

	public GoodListEntity getGoodList(int page) {
		return service.getGoodsList(page);
	}

	public GoodListEntity getData(String name, int page) {
		return service.getRequestData(name, page);
	}
	public GoodListEntity getGoodsDetail(int id){
		return service.getGoodsDetail(id);
	}
	public UserInfoData getRegist(String name,String pass){
		return service.getRegist(name, pass);
	}
	public UserInfoData getLogin(String name,String pass){
		return service.getLogin(name, pass);
	}
	public UserCarDataEntity getCar(String token, String user_id, int goods_id,
			String goods_sn, String goods_name, float market_price,
			float goods_price, int goods_number){
		return service.carGoods(token, user_id, goods_id, goods_sn, goods_name, market_price, goods_price, goods_number);
	}
	
	public ClassifyDataEntity getClassify(int id){
		return service.getClassify(id);
	}
	
	public void getCarGoodsList(String id,String token){
		service.getCarGoodsList(id, token);
	}
}
