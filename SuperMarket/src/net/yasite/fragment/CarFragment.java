package net.yasite.fragment;

import java.util.List;

import net.yasite.dao.GoodsDao;
import net.yasite.entity.GoodsCarEntity;
import net.yasite.model.GoodsListModel;
import net.yasite.net.HandlerHelp;
import net.yasite.sharepre.UserInfoShare;
import net.yasite.test.LoginActivity;
import net.yasite.test.R;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CarFragment extends Fragment{
	private UserInfoShare infoShare;
	private Context context;
	private String userName,token,userId;
	private GoodsListModel model;
	
	List<GoodsCarEntity> list;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		context = getActivity();
		View view = inflater.inflate(R.layout.car_frgment, null);
	
		infoShare = new UserInfoShare(context);
		userName = (String) infoShare.getUserInfo("userinfo", context.MODE_PRIVATE).get("username");
		token = (String) infoShare.getUserInfo("userinfo", context.MODE_PRIVATE).get("token");
//		userId = (String) infoShare.getUserInfo("userinfo", context.MODE_PRIVATE).get("user_id");
		model = new GoodsListModel(context);
		if(token==null||token.equals("")){
			Intent intent = new Intent(context, LoginActivity.class);
			intent.putExtra("login", "car");
			getActivity().startActivityForResult(intent, 1);
		}else{
			userId = infoShare.getUserId("userid", context.MODE_PRIVATE);
			new MyHelper(context).execute();
		}
		return view;
	}
	 class MyHelper extends HandlerHelp{

		public MyHelper(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub
		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			model.getCarGoodsList(userId, token);
			
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
			
		}
		 
	 }
}
