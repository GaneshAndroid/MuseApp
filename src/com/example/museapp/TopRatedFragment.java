package com.example.museapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TopRatedFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rooView=inflater.inflate(R.layout.fragment_top_rated, container,false);
		return rooView;
	}
	
 
    }


