package com.example.kamil.hackatonkielce;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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


        ArrayList <LatLng> list = new ArrayList<>();

        list.add(new LatLng(50.9001050, 20.5866301));
        list.add(new LatLng(50.9002050, 20.5866301));
        list.add(new LatLng(50.9003050, 20.5866301));
        list.add(new LatLng(50.9004050, 20.5866301));
        list.add(new LatLng(50.9005050, 20.5866301));
        list.add(new LatLng(50.9006050, 20.5866301));
        list.add(new LatLng(50.9007050, 20.5866301));
        list.add(new LatLng(50.9008050, 20.5866301));
        list.add(new LatLng(50.9009050, 20.5866301));
        list.add(new LatLng(50.9010050, 20.5866301));

        for (LatLng i: list) {
            mMap.addMarker(new MarkerOptions().position(i).title(i.toString()));
            Marker marker =  mMap.addMarker(new MarkerOptions().position(i));
            marker.setTag(marker.getPosition());

        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(list.get(4)));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String hamas = marker.getTag().toString();
                Toast.makeText(MapsActivity.this,hamas , Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}
