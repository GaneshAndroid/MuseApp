package com.example.museapp;

import info.androidhive.tabsswipe.adapter.TabsPagerAdapter;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

@SuppressLint("NewApi") 
public class MainPageActivity extends FragmentActivity implements ActionBar.TabListener {
	
	private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    // Tab titles
    private String[] tabs = { "Top Rated", "Near by", "Reviews" };
 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_page_file);
		viewPager=(ViewPager) findViewById(R.id.pager);
		actionBar=getActionBar();
		mAdapter=new TabsPagerAdapter(getSupportFragmentManager());
		
		viewPager.setAdapter(mAdapter);
		actionBar.setHomeButtonEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		//actionBar.hide();
		
		
		
		
		
		for(String tab_name:tabs){
			actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
		}
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			 
		    @Override
		    public void onPageSelected(int position) {
		        // on changing the page
		        // make respected tab selected
		        actionBar.setSelectedNavigationItem(position);
		    }
		 
		    @Override
		    public void onPageScrolled(int arg0, float arg1, int arg2) {
		    }
		 
		    @Override
		    public void onPageScrollStateChanged(int arg0) {
		    }
		});
	}


	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		viewPager.setCurrentItem(arg0.getPosition());
		
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
	
	

}
