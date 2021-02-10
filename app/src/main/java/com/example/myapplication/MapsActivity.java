package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.inputmethodservice.KeyboardView;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
 Button search_btn;
 EditText search_text;
	private GoogleMap mMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maps);
		// Obtain the SupportMapFragment and get notified when the map is ready to be used.
		SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);
		mapFragment.getMapAsync(this);
     search_btn = findViewById(R.id.btn_go);
     search_text = findViewById(R.id.search);
     search_btn.setOnClickListener(new View.OnClickListener() {
	     @Override
	     public void onClick(View v) {
	     	 String text = search_text.getText().toString();
		     List<Address> addresses = null;
		     if(text != null || !text.equalsIgnoreCase(""))
		     {

			     Geocoder geocoder= new Geocoder(MapsActivity.this);
			     try{
			     	addresses = geocoder.getFromLocationName(text,1);
			     }
			      catch (IOException e) {
				     e.printStackTrace();
			     }
		     }
		     if(addresses !=null) {
			     Address address = addresses.get(0);
			     LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
			     mMap.addMarker(new MarkerOptions().position(latLng).title(text));
			     mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
		     }
	     }
     });
	}

	/**
	 * Manipulates the map once available.
	 * This callback is triggered when the map is ready to be used.
	 * This is where we can add markers or lines, add listeners or move the camera. In this case,
	 * we just add a marker near Sydney, Australia.
	 * If Google Play services is not installed on the device, the user will be prompted to install
	 * it inside the SupportMapFragment. This method will only be triggered once the user has
	 * installed Google Play services and returned to the app.
	 */
	@Override
	public void onMapReady(GoogleMap googleMap) {
		mMap = googleMap;
		// Add a marker in Sydney and move the camera
		LatLng sydney = new LatLng(18.528252051150393, 73.87217118234592);
		mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15f));
	}

	@Override
	public void onBackPressed() {
		Intent intent = new Intent(MapsActivity.this, MainActivity.class);
		startActivity(intent);
	}
}