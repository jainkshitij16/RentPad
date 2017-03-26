package com.tryout.rentpad;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Listing listing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_listing);
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
    /*
      @TODO: Change the window/appearance of the infotext box
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        listing = Listing.getInstance();
        /*
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        */


        double lat = (double) Integer.parseInt(listing.getLatitude_listing());
        double lon = (double) Integer.parseInt(listing.getLongitude_listing());

        LatLng listing_marker_latlng = new LatLng(lat,lon);

          final Marker listing_marker = mMap.addMarker(new MarkerOptions()
                                                .position(listing_marker_latlng)
                                                .title(listing.getTittle_listing())
                                                .snippet(listing.getStreet_name_listing())
                                                .snippet(listing.getCity_listing())
                                                .snippet(listing.getZip_listing())
                                                .snippet(listing.getPhone_listing())
                                                .snippet(listing.getEmail_listing())
                                                .snippet(listing.getPrice_listing())
                                                .snippet(listing.getAdd_date_listing())
                                                .snippet(listing.getNum_ba_listing())
                                                .snippet(listing.getNum_bd_listing()));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.equals(listing_marker)){
                    listing_marker.showInfoWindow();
                    return true;
                }
                return false;
            }
        });

        mMap.moveCamera(CameraUpdateFactory.newLatLng(listing_marker_latlng));

        mMap.getUiSettings().setMapToolbarEnabled(false);
    }

    // sets the listing object to be displayed on the map
    public void setListing_display(Listing lis){
        this.listing = lis;
    }

}
