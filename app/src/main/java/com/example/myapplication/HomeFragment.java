package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment {
	View view ;
	Button btn_fragment ,btn_backactivity ;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		view= inflater.inflate(R.layout.fragment_home, container, false);
		btn_fragment = view.findViewById(R.id.btn_fragment);
		btn_backactivity=view.findViewById(R.id.btn_backtofragment);
		btn_fragment.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				GalleryFragment galleryFragment = new GalleryFragment();
				FragmentManager manager =getActivity().getSupportFragmentManager();
				FragmentTransaction transaction = manager.beginTransaction();
				transaction.replace(R.id.frame, galleryFragment);
				transaction.addToBackStack(null);
				transaction.commit();

			}
		});
		btn_backactivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			startActivity(new Intent(getActivity(),MainActivity.class));
			}
		});
		return view;
	}

}