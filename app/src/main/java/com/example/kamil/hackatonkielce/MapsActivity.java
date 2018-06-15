package com.example.kamil.hackatonkielce;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseApp;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    private String url;
    private final ArrayList<Marker_date> Marker_date_list = new ArrayList<>();
    private Marker myMarker;
    private int iter_marker_date = 0;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private boolean mlocpergrand = false;
    private static float DEFAULT_ZOOM = 15f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
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
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setTiltGesturesEnabled(true);

        //setUrl("https://androidhack-e4f9d.firebaseio.com/");
        Marker_date_list.add(new Marker_date(new LatLng(50.9001050, 20.5866301), "Moonman", 1));
        Marker_date_list.add(new Marker_date(new LatLng(51.9011050, 20.5866301), "Moonman1", 2));
        Marker_date_list.add(new Marker_date(new LatLng(52.9021050, 20.5866301), "Moonman2", 3));
        Marker_date_list.add(new Marker_date(new LatLng(53.9031050, 20.5866301), "Moonman3", 4));
        Marker_date_list.add(new Marker_date(new LatLng(54.9041050, 20.5866301), "Moonman4", 5));
        Marker_date_list.add(new Marker_date(new LatLng(55.9051050, 20.5866301), "Moonman5", 6));





        mMap.getUiSettings().setMapToolbarEnabled(true);


        if (mlocpergrand==true) {
            getDeviceLocation();
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MapsActivity.this,"pytanie o dostep 1", Toast.LENGTH_SHORT).show();
                return;
            }
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
        }

        if((ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED))
        {
            Toast.makeText(MapsActivity.this,"pytanie o dostep 2", Toast.LENGTH_SHORT).show();
            mlocpergrand=true;
        }
        else
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Toast.makeText(MapsActivity.this, "pytanie o dostep 3", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 457837897);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 457837897);
            }
        }



        for (Marker_date i: Marker_date_list) {

            //mMap.addMarker(new MarkerOptions().position(Marker_date_list.get(iter_marker_date).cord).title(Marker_date_list.get(iter_marker_date).name));
            Marker marker =  mMap.addMarker(new MarkerOptions().position(i.cord));
            marker.setTag(i.id);
            marker.setTitle(i.name);

            //marker.setIcon(BitmapDescriptorFactory.fromBitmap(make_icon(i.name)));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Marker_date_list.get(2).cord));

        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnInfoWindowClickListener(this);

        if (mlocpergrand==true) {
            //getDeviceLocation();
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
            mMap.getUiSettings().setMapToolbarEnabled(true);
            mMap.getUiSettings().setCompassEnabled(true);
            mMap.getUiSettings().setTiltGesturesEnabled(true);


        }
    }
    private void getDeviceLocation()
    {
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        try{
            if(mlocpergrand==true)
            {
                Task location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if(task.isSuccessful()){
                            Location currentlocation = (Location) task.getResult();
                            moveCamera(new LatLng(currentlocation.getLatitude(),currentlocation.getLongitude()),DEFAULT_ZOOM);
                        }
                    }
                });
            }
        }catch(SecurityException e){

        }
    }
//epsg 2178 to epsg 4326
    private void moveCamera(LatLng coord, float zoom)
    {
        Toast.makeText(MapsActivity.this,"move camera", Toast.LENGTH_SHORT).show();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coord,zoom));
    }

    public boolean onMarkerClick(final Marker marker) {

        String name= marker.getTitle()+" "+marker.getTag()+" "+marker.getPosition()+" Marker";
        marker.showInfoWindow();

        mMap.getUiSettings().setMapToolbarEnabled(true);
        Toast.makeText(MapsActivity.this,name, Toast.LENGTH_SHORT).show();

        return false;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {

        marker.hideInfoWindow();
        String name= marker.getTitle()+" "+marker.getTag()+" "+marker.getPosition()+" Infowindow";
        Toast.makeText(MapsActivity.this,name, Toast.LENGTH_SHORT).show();
        mMap.getUiSettings().setMapToolbarEnabled(false);
    }

    private class Marker_date{
        LatLng cord;
        String name;
        int id;
        Marker_date(LatLng cord,String name,int id){
            this.cord=cord;
            this.name=name;
            this.id=id;
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private Bitmap  make_icon(String text) {

        Paint paint = new Paint();
        paint.setTextSize(text.length());
        paint.setColor(Color.WHITE);
        paint.setTextAlign(Paint.Align.LEFT);
        float baseline = -paint.ascent(); // ascent() is negative
        int width = (int) (paint.measureText(text) + 3.5f); // round
        int height = (int) (baseline + paint.descent() + 3.5f);
        Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(image);
        canvas.drawColor(Color.RED);
        canvas.drawText(text, 0, baseline, paint);
        return image;

    }

}
