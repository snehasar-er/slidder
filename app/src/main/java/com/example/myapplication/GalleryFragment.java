package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class GalleryFragment extends Fragment implements View.OnClickListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		Button btn_backfragment;
		View view= inflater.inflate(R.layout.fragment_gallery, container, false);
		btn_backfragment= view.findViewById(R.id.btn_backtofragment);
		btn_backfragment.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId())
		{
			case R.id.btn_backtofragment:
				FragmentManager fm = getActivity().getSupportFragmentManager();
				if (fm.getBackStackEntryCount() > 0) {
					Log.i("MainActivity", "popping backstack");
					fm.popBackStack();
				}
				break;
		}
	}
}