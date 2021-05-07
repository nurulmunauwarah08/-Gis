package com.example.giss;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.giss.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

        // Add a marker in Rumah and move the camera
        LatLng Rumah = new LatLng(-1.8900713, 119.3619399);
        LatLng P1 = new LatLng(-1.8537099302189992, 119.38404356871186);
        LatLng P2 = new LatLng(-1.9241241713193227, 119.35662995011864);
        LatLng P3 = new LatLng(-1.885198600244474, 119.36485487925394);
        LatLng P4 = new LatLng(-1.9956894630657394, 119.30415570787966);

        //custom size marker
        int tinggi = 100;
        int lebar = 100;
        BitmapDrawable bitmapStart = (BitmapDrawable)getResources().getDrawable(R.drawable.nurul);
        BitmapDrawable bitmapP1 = (BitmapDrawable)getResources().getDrawable(R.drawable.puskesmas);
        BitmapDrawable bitmapP2 = (BitmapDrawable)getResources().getDrawable(R.drawable.puskesmas);
        BitmapDrawable bitmapP3 = (BitmapDrawable)getResources().getDrawable(R.drawable.puskesmas);
        BitmapDrawable bitmapP4 = (BitmapDrawable)getResources().getDrawable(R.drawable.puskesmas);
        Bitmap R = bitmapStart.getBitmap();
        Bitmap d = bitmapP1.getBitmap();
        Bitmap P = bitmapP2.getBitmap();
        Bitmap poli = bitmapP3.getBitmap();
        Bitmap PS = bitmapP3.getBitmap();
        Bitmap markerStart = Bitmap.createScaledBitmap(R,lebar, tinggi,false);
        Bitmap markerP1 = Bitmap.createScaledBitmap(d,lebar, tinggi,false);
        Bitmap markerP2 = Bitmap.createScaledBitmap(P,lebar, tinggi,false);
        Bitmap markerP3 = Bitmap.createScaledBitmap(poli,lebar, tinggi,false);
        Bitmap markerP4 = Bitmap.createScaledBitmap(PS,lebar, tinggi,false);

        //add marker to map
        mMap.addMarker(new MarkerOptions().position(Rumah).title("Rumah")
            .snippet("Nurul's Home")
            .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));

        mMap.addMarker(new MarkerOptions().position(P1).title("Puskesmas Lara")
                .snippet("Pelayanan 24 jam")
                .icon(BitmapDescriptorFactory.fromBitmap(markerP1)));

        mMap.addMarker(new MarkerOptions().position(P2).title("Puskesmas Tomemba")
                .snippet("kurang lengkap")
                .icon(BitmapDescriptorFactory.fromBitmap(markerP2)));

        mMap.addMarker(new MarkerOptions().position(P3).title("Poliklinik")
                .snippet("Buka Praktek 17.00-22.00")
                .icon(BitmapDescriptorFactory.fromBitmap(markerP3)));


        mMap.addMarker(new MarkerOptions().position(P4).title("Puskesmas Salupangkang")
                .snippet("Pelayanan 24 Jam")
                .icon(BitmapDescriptorFactory.fromBitmap(markerP4)));

        mMap.addPolyline(new PolylineOptions().add(
                Rumah,
                new LatLng(-1.8900713, 119.3619399),
                new LatLng(-1.8900391146288813, 119.36222860520608),
                new LatLng(-1.8890316926639923, 119.3622114028069),
                new LatLng(-1.8865227959159447, 119.36428739623115),
                new LatLng(-1.8852832806064945, 119.36447459428736),
                new LatLng(-1.8824585944545087, 119.36377974127404),
                new LatLng(-1.8814010193999617, 119.36393639987571),
                new LatLng(-1.8788985934387612, 119.36496598918494),
                new LatLng(-1.8700043453873751, 119.37046344485508),
                new LatLng(-1.86301160423063, 119.3743926756478),
                new LatLng(-1.8607928178551214, 119.37768150309253),
                new LatLng(-1.8581336281374086, 119.37799089193255),
                new LatLng(-1.8575891703297154, 119.37825437654024),
                new LatLng(-1.855335735013618, 119.38237908259755),
                new LatLng(-1.8555858767902105, 119.38336563087098),
                new LatLng(-1.8544706626165366, 119.38369822479771),
                new LatLng(-1.8537099302189992, 119.38404356871186),
                P1

            ).width(10)
                .color(Color.RED)


        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Rumah,13f));
    }
}