package com.android.shorttext;

import java.util.List;
import java.util.Vector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.KeyEvent;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.viewpagerindicator.LinePageIndicator;
import com.viewpagerindicator.SwipeyTabsView;
import com.viewpagerindicator.TabsAdapter;

public class ViewActivity extends SherlockFragmentActivity {

	private PagerAdapter mPagerAdapter;
	private TabsAdapter mSwipeyTabsAdapter;
	private SwipeyTabsView mSwipeyTabs;

	ViewPager pager;
	LinePageIndicator cIndicator;
	List<Fragment> fragments = new Vector<Fragment>();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.vp);
		if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY) > 0) {
		   finish();    
		}
		
		

		this.initialisePaging();

		// TODO Auto-generated method stub
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.activitymenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
//		case R.id.menu:
//			Toast.makeText(this, "You selected Phonejkhkhkh",
//					Toast.LENGTH_SHORT).show();
//			return true;
		case R.id.AD:
			showPopup2();
			return true;

		case R.id.Exit:
//			Intent intent = new Intent(
//					Intent.ACTION_MAIN);
//			intent.addCategory(Intent.CATEGORY_HOME);
//			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//			startActivity(intent);
			finish();
			return true;

		}
		return super.onOptionsItemSelected(item);
	}

	ActionBar actionBar;

	private void initialisePaging() {

		initViewPager();
		mSwipeyTabs = (SwipeyTabsView) findViewById(R.id.swipey_tabs);

		mSwipeyTabsAdapter = new SwipeyTabsAdapter(this);

		mSwipeyTabs.setAdapter(mSwipeyTabsAdapter);
		mSwipeyTabs.setViewPager(pager);

		actionBar = getSupportActionBar();
		// actionBar.setHomeLogo(R.drawable.ic_launcher);
		// actionBar.setTitle("              SMS Slang");
		//
		// final Action menuAction = new IntentAction(this, createMenuIntent(),
		// R.drawable.menulist34);
		// actionBar.addAction(menuAction);

	}

	private Intent createMenuIntent() {
		final Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_TEXT, "Shared from the ActionBar widget.");
		return Intent.createChooser(intent, "Share");
	}

	private void initViewPager() {
		pager = (ViewPager) findViewById(R.id.viewpager);
		

		fragments.add(Fragment.instantiate(this, Main.class.getName()));
//		fragments.add(Fragment.instantiate(this, Main2.class.getName()));
		fragments.add(Fragment.instantiate(this, SlangList.class.getName()));
		fragments.add(Fragment.instantiate(this, AddSlang.class.getName()));
		this.mPagerAdapter = new ExamplePagerAdapter(
				super.getSupportFragmentManager(), fragments);
		pager.setAdapter(mPagerAdapter);
		 pager.setCurrentItem(0);
		 //pager.setPageMargin(1);
//		 pager.setPageMarginDrawable(getResources().getColor(R.color.yellow));
	}
	
	private void showPopup2() {
		final PopupWindow window = new PopupWindow(this);

		window.setWidth(430);
		window.setHeight(600);
		// window.setBackgroundDrawable(getResources().getDrawable(R.color.));

		window.setTouchable(true);
		window.setFocusable(true);

		TextView text = new TextView(this);
		text.setTextColor(getResources().getColor(R.color.Cream));

		text.setText("\n" + "\n"+"\n"+"\n"+"\n"+"			App Info" + "\n"+ "\n"+ "\n" +"	SMS Slang app is developed "+"\n"+"	by Immanuel I George."+"\n"+"\n"+"	Version: 1.0 "+"\n"+"\n"+"	FeedBack: smsslang@gmail.com "+"\n"+"\n"+"	Developer Website: www.imgeorge.co.cc");

		text.setTextSize(14);

		// text.setOnClickListener(new View.OnClickListener() {
		// public void onClick(View v) {
		// startActivity(new Intent("com.android.shorttext.AddSlang"));
		// }
		//
		// });// button

		window.setContentView(text);
		// window.setContentView(bt);
		window.showAtLocation(text, Gravity.CENTER, 0, 0);

	}
	@Override
	public void onBackPressed() {
	    finish();
	    return;
	}
	  @Override
	  public void onStop() {
		  super.onStop();
		  //Intent intent = getIntent();
		  finish();
		  //startActivity(intent);
	  }
	

}
