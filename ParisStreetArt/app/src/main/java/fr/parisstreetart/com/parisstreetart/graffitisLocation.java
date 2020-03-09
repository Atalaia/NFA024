package fr.parisstreetart.com.parisstreetart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class graffitisLocation extends AppCompatActivity
        implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_graffitis_location);
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Ajout des marquers
        // positionner la caméra sur les marqueurs
        LatLng graffiti1 = new LatLng(48.889834, 2.36661);
        LatLng graffiti2 = new LatLng(48.859252, 2.351654);
        LatLng graffiti3 = new LatLng(48.833199, 2.362704);

        googleMap.addMarker(new MarkerOptions().position(graffiti1)
                .title("68 Rue Riquet, 75018 Paris, France"));
        googleMap.addMarker(new MarkerOptions().position(graffiti2)
                .title("2 Rue Brisemiche, 75004 Paris, France"));
        googleMap.addMarker(new MarkerOptions().position(graffiti3)
                .title("122 Boulevard Vincent-Auriol, 75013 Paris, France"));


        googleMap.moveCamera(CameraUpdateFactory.newLatLng(graffiti1));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(graffiti2));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(graffiti3));

    }
}