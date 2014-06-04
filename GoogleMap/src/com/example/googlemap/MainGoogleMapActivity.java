package com.example.googlemap;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;

public class MainGoogleMapActivity extends Activity {

	GoogleMap map;
	MapFragment fm;
    @SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_google_map);
        fm=((MapFragment)getFragmentManager().findFragmentById(R.id.map));
		map=fm.getMap();
		
		if(map!=null){
			MyUtilities.tost(getBaseContext(), "Yeah,you have google map feature");
		}else{
			MyUtilities.tost(getBaseContext(), "Sorry, you dont have google map facility");
		}
    }

    protected void onResume() {
		super.onResume();
		MarkerOptions marker=new MarkerOptions();
		BitmapDescriptor icon=BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE);
		LatLng latLng=new LatLng(12.968970, 77.536968);
		marker.icon(icon);
		marker.title("McDonald's");
		marker.position(latLng);
		map.addMarker(marker);
		
		map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
		map.animateCamera(CameraUpdateFactory.zoomIn());
		map.animateCamera(CameraUpdateFactory.zoomTo(19), 2000, null);
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		
		map.setOnMarkerClickListener(new OnMarkerClickListener() {
			
			@Override
			public boolean onMarkerClick(Marker marker) {
				if(marker.getTitle().contains("McDonald's")){
					MyUtilities.tost(getBaseContext(), "Awesome food is available here");
				}
				return true;
			}

			
		});
	}

   
    
}
