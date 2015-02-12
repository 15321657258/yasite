package net.yasite.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import net.yasite.api.AddCarApi;
import net.yasite.api.BaseAPI;
import net.yasite.api.CarGoodsListApi;
import net.yasite.api.ClassApi;
import net.yasite.api.GoodsDetailApi;
import net.yasite.api.GoodsListAPI;
import net.yasite.api.LoginApi;
import net.yasite.api.RegistApi;
import net.yasite.api.SelectByNameApi;
import net.yasite.api.params.CarGoodsListParam;
import net.yasite.api.params.ClassParam;
import net.yasite.api.params.GoodsListParam;
import net.yasite.api.params.UserInfoParam;
import net.yasite.entity.ClassifyDataEntity;
import net.yasite.entity.GoodListEntity;
import net.yasite.entity.UserCarDataEntity;
import net.yasite.entity.UserInfoData;
import android.content.Context;

public class GoodsService extends BaseService {

	public GoodsService(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public GoodListEntity getGoodsList(int page) {
		GoodsListParam pm = new GoodsListParam();
		pm.setPage(Integer.toString(page));
		BaseAPI api = new GoodsListAPI(context, pm);
		try {
			if (api.doGet()) {
				return (GoodListEntity) api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public GoodListEntity getRequestData(String name, int page) {
		GoodsListParam pm = new GoodsListParam();
		pm.setName(name);
		pm.setPage(Integer.toString(page));
		BaseAPI api = new SelectByNameApi(context, pm);
		try {
			if (api.doGet()) {
				return (GoodListEntity) api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public GoodListEntity getGoodsDetail(int id) {
		GoodsListParam pm = new GoodsListParam();
		pm.setId(Integer.toString(id));
		BaseAPI api = new GoodsDetailApi(context, pm);
		try {
			if (api.doGet()) {
				return (GoodListEntity) api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public UserInfoData getRegist(String name, String pass) {
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(getValue("name", name));
		list.add(getValue("pwd", pass));
		BaseAPI api = new RegistApi(context, list);
		try {
			if (api.doPost()) {
				return (UserInfoData) api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public UserInfoData getLogin(String name, String pass) {
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(getValue("name", name));
		list.add(getValue("pwd", pass));
		BaseAPI api = new LoginApi(context, list);
		try {
			if (api.doPost()) {
				return (UserInfoData) api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public UserCarDataEntity carGoods(String token, String user_id, int goods_id,
			String goods_sn, String goods_name, float market_price,
			float goods_price, int goods_number) {
		UserInfoParam param = new UserInfoParam();
		param.setToken(token);
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(getValue("user_id", user_id));
		list.add(getValue("goods_id", Integer.toString(goods_id)));
		list.add(getValue("goods_sn", goods_sn));
		list.add(getValue("goods_name", goods_name));
		list.add(getValue("market_price", Float.toString(market_price)));
		list.add(getValue("goods_price", Float.toString(goods_price)));
		list.add(getValue("goods_number", Integer.toString(goods_number)));
		BaseAPI api = new AddCarApi(context, list, param);
		try {
			if(api.doPost()){
				return (UserCarDataEntity) api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ClassifyDataEntity getClassify(int id){
		ClassParam param = new ClassParam();
		param.setId(Integer.toString(id));
		BaseAPI api = new ClassApi(context, param);
		try {
			if(api.doGet()){
				return (ClassifyDataEntity) api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void getCarGoodsList(String id,String token){
		CarGoodsListParam param = new CarGoodsListParam();
		param.setToken(token);
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(getValue("id", id));
		BaseAPI api = new CarGoodsListApi(context, list, param);
		try {
			if(api.doPost()){
				api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
