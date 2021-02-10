package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.sql.ResultSet;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

	private AppBarConfiguration mAppBarConfiguration;
	public static final int REQUEST_CODE_FOR_APP_STORAGE_AND_CLEAR_CACHE= 788;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		FloatingActionButton fab = findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});
		DrawerLayout drawer = findViewById(R.id.drawer_layout);
		NavigationView navigationView = findViewById(R.id.nav_view);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.addDrawerListener(toggle);
		toggle.syncState();
		navigationView.setNavigationItemSelectedListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public boolean onNavigationItemSelected(@NonNull MenuItem item) {
		switch(item.getItemId())
		{
			case R.id.nav_home:
           loadFragment(new HomeFragment());
				break ;
			case R.id.nav_gallery:
				loadFragment(new GalleryFragment());
				break;
			case R.id.nav_slideshow :
				Intent intent1 = new Intent(MainActivity.this, SliderActivity.class);
				startActivity(intent1);
				break ;
			case R.id.nav_googlemap :
				Intent intent = new Intent(MainActivity.this, MapsActivity.class);
				startActivityForResult(intent,101);
				break ;

		}
		DrawerLayout drawer = findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;

	}
	void loadFragment(Fragment fragment)
	{
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.frame, fragment);
		transaction.commit();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == REQUEST_CODE_FOR_APP_STORAGE_AND_CLEAR_CACHE && resultCode == RESULT_OK)
		{
			return;
		}
		else if (requestCode == 102 )
		{
			return;
		}
	}
}