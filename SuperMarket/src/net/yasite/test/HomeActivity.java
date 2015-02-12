package net.yasite.test;

import net.yasite.fragment.CarFragment;
import net.yasite.fragment.ClassiFragment;
import net.yasite.fragment.HomeFragment;
import net.yasite.fragment.RegistFragment;
import net.yasite.sharepre.UserInfoShare;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class HomeActivity extends BaseNewActivity {
	private UserInfoShare infoShare;
	private long exitTime = 0;
	private RadioGroup group;
	private RegistFragment registFragment;
	private FragmentTransaction transaction;
	private HomeFragment fragment;
	private ClassiFragment classiFragment;
	private CarFragment carFragment;
	private Intent intent;
	private RadioButton radio_regist,radia_fen,radio_cart;
	@Override
	public void setupView() {
		// TODO Auto-generated method stub
		infoShare = new UserInfoShare(context);
		group = (RadioGroup) findViewById(R.id.radiogroup);
		radio_regist  = (RadioButton) findViewById(R.id.radio_regist);
		radia_fen = (RadioButton) findViewById(R.id.radio_fen);
		radio_cart = (RadioButton) findViewById(R.id.radio_cart);
		group.setOnCheckedChangeListener(listener);
		intent = getIntent();
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		if(infoShare.getUserInfo("userinfo", MODE_PRIVATE).get("username")==null||infoShare.getUserInfo("userinfo", MODE_PRIVATE).get("username").equals("")){
			
			radio_regist.setVisibility(View.VISIBLE);
		}else{
			radio_regist.setVisibility(View.GONE);
		}
		super.onResume();
	}



	OnCheckedChangeListener listener = new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			switch (checkedId) {
			case R.id.radio_regist:
				registFragment = new RegistFragment();
				replaceFragment(registFragment);
				break;
			case R.id.radio_home:
				fragment = new HomeFragment();
				replaceFragment(fragment);
				break;
			case R.id.radio_fen:
				classiFragment = new ClassiFragment();
				replaceFragment(classiFragment);
				break;
			case R.id.radio_cart:
				carFragment = new CarFragment();
				replaceFragment(carFragment);
				break;
			default:
				break;
			}
		}
	};

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.home_tan1);
	}

	@Override
	public void setModel() {
		// TODO Auto-generated method stub
		fragment = new HomeFragment();
		transaction = getFragmentManager().beginTransaction();
		transaction.add(R.id.ww, fragment);
		transaction.commit();
		if(intent.getStringExtra("regist")!=null){
			if(intent.getStringExtra("regist").equals("regist")){
				registFragment = new RegistFragment();
				replaceFragment(registFragment);
				radio_regist.setChecked(true);
			}
		}
	}

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		
		return true;
	}
	
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			if ((System.currentTimeMillis() - exitTime) > 2000) {

				Toast.makeText(getApplicationContext(), "再按一次退出程序",
						Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			} else {
				infoShare.insertUserInfo("userinfo", MODE_PRIVATE, "", "", "","");
				infoShare.idsertGoodsid("goods", MODE_PRIVATE, -1);
				finish();
				System.exit(0);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	
	public void replaceFragment(Fragment fragment) {
		transaction = getFragmentManager().beginTransaction();
		transaction.replace(R.id.ww, fragment);
		transaction.commit();
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==1&&resultCode==1){
			carFragment = new CarFragment();
			replaceFragment(carFragment);
		}
	}
}
