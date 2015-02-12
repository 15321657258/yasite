package net.yasite.api;

import java.util.List;

import net.yasite.api.params.BaseHttpParam;
import net.yasite.api.params.CarGoodsListParam;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class CarGoodsListApi extends BaseAPI {

	public CarGoodsListApi(Context context, List<NameValuePair> pm,
			CarGoodsListParam params) {
		super(context, pm, params);
		setMethod("http://www.yasite.net/shopapi/index.php/cartController/getGoodList/"+params.getToken());
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return json.toString();
	}

}
