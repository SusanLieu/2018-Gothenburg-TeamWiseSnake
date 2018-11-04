package com.movetogbg;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import ru.noties.ccf.CCFAnimator;


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
        final Handler handler = new Handler();
        // Add a marker in Sydney and move the camera
        final LatLng gothenburg = new LatLng(57.7089, 11.9746);
        final LatLng gothenburgsouth = new LatLng(57.692927, 11.963073);
        final LatLng chalmers = new LatLng(57.689873, 11.974144);
        final LatLng liseberg = new LatLng(57.695414, 11.992496);
        final LatLng lindhsciencepark = new LatLng(57.707420, 11.939349);
        final LatLng johasciencepark = new LatLng(57.685633, 11.978635);
        final LatLng universeum = new LatLng(57.695697, 11.989456);
        final LatLng centralstation = new LatLng(57.708948, 11.973306);
        final LatLng cabinrent = new LatLng(57.686574, 11.948815);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gothenburg));
        final Circle gothCircle= mMap.addCircle(new CircleOptions()
                .center(gothenburg)
                .radius(30000)
                .strokeColor(getResources().getColor(R.color.circleStroke))
                .fillColor(getResources().getColor(R.color.circleFill)));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(gothenburg, 9f));
            }
        }, 1000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(gothenburgsouth, 13f));

            }
        }, 3000);
        final CCFAnimator ccf = CCFAnimator.argb(getResources().getColor(R.color.circleFill),getResources().getColor(R.color.circleFade));
        final ValueAnimator animator = ccf.asValueAnimator(new CCFAnimator.OnNewColorListener() {
            @Override
            public void onNewColor(int color) {
                gothCircle.setFillColor(color);
            }
        });
        animator.setDuration(4000L);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mMap.addMarker(new MarkerOptions().position(chalmers).title("Chalmers Institute Of Technology").icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("greenmarker",85,85))));
                mMap.addMarker(new MarkerOptions().position(liseberg).title("Liseberg Amusement Park").icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("bluemarker",85,85))));
                mMap.addMarker(new MarkerOptions().position(lindhsciencepark).title("Lindholmen Science Park").icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("yellowmarker",85,85))));
                mMap.addMarker(new MarkerOptions().position(centralstation).title("Central Station Of Gothenburg").icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("bluemarker",85,85))));
                mMap.addMarker(new MarkerOptions().position(johasciencepark).title("Johanneberg Science Park").icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("yellowmarker",85,85))));
                mMap.addMarker(new MarkerOptions().position(universeum).title("Universeum").icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("greenmarker",85,85))));
                mMap.addMarker(new MarkerOptions().position(cabinrent).title("Forest Cabins").icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("bluemarker",85,85))));
            }
        }, 5000);



    }
    public Bitmap resizeMapIcons(String iconName,int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(iconName, "drawable", getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }
}
