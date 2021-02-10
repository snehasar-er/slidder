package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class SliderActivity extends AppCompatActivity {
ViewFlipper simpleViewFlipper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slider);
		int[] images = {R.drawable.ic_menu_camera, R.drawable.ic_menu_share, R.drawable.ic_baseline_map_24};
		simpleViewFlipper = (ViewFlipper) findViewById(R.id.simpleViewFlipper);
		for (int i = 0; i < images.length; i++) {
			ImageView imageView = new ImageView(this);
			imageView.setImageResource(images[i]);
			simpleViewFlipper.addView(imageView);
		}
		Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
		Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
		simpleViewFlipper.setInAnimation(in);
		simpleViewFlipper.setOutAnimation(out);
		simpleViewFlipper.setFlipInterval(3000);
		simpleViewFlipper.setAutoStart(true);
	}

//	@Override
//	public void onBackPressed() {
//	  startActivity(new Intent(this,MainActivity.class));
//	}


	@Override
	public void onBackPressed() {
		//super.onBackPressed();
		AlertDialog.Builder builder = new AlertDialog.Builder(SliderActivity.this);
		builder.setMessage("Do you want to close ?");
		builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				finish();
			}
		});
		builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				dialogInterface.cancel();
			}
		});
		AlertDialog alertDialog = builder.create();
		alertDialog.setTitle("Alert");
		alertDialog.show();
//		Intent intent = new Intent(this,MainActivity.class);
//		startActivity(intent);
	}
}