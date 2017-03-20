package com.tryout.rentpad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    public EditText max_lat;
    public EditText min_lat;
    public EditText max_long;
    public EditText min_long;
    public EditText number_bathroom;
    public EditText number_bedroom;
    public Switch type_rent;
    public Button button_search;
    public ProgressBar progressBar;
    public double xmin;
    public double xmax;
    public double ymin;
    public double ymax;
    public int n_ba;
    public int n_bd;
    public int type;

    private static double MIN_LONG = 49.2765;
    private static double MIN_LAT = -123.2177;
    private static int BATH_BED = 1;

    RentAPI_request rentAPI_request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rentAPI_request = new RentAPI_request();

        max_lat = (EditText) findViewById(R.id.Edit_Maximum_Latitude);
        min_lat = (EditText) findViewById(R.id.Edit_Maximum_Latitude);
        max_long = (EditText) findViewById(R.id.Edit_Maximum_Longitude);
        min_long = (EditText) findViewById(R.id.Edit_Minimum_Longitude);
        number_bathroom = (EditText) findViewById(R.id.Edit_bathroom);
        number_bedroom = (EditText) findViewById(R.id.Edit_bedroom);
        type_rent = (Switch) findViewById(R.id.Type_Rent);
        button_search = (Button) findViewById(R.id.button_search);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        // if statements to make up something
        if(min_long.toString() !=null) xmin = (double) Integer.parseInt(min_long.toString());
        else xmin = MIN_LONG;

        if(min_lat.toString() !=null) ymin = (double) Integer.parseInt(min_lat.toString());
        else ymin = MIN_LAT;

        if(max_long.toString() !=null) xmax = (double) Integer.parseInt(max_long.toString());
        else xmax = MIN_LONG+5.00;

        if(max_lat.toString() !=null) ymax = (double) Integer.parseInt(max_lat.toString());
        else ymax = MIN_LAT+5.00;

        if(number_bathroom.toString() !=null) n_ba = Integer.parseInt(number_bathroom.toString());
        else n_ba = BATH_BED;

        if(number_bedroom.toString() !=null) n_bd = Integer.parseInt(number_bedroom.toString());
        else n_bd = BATH_BED;

        if(type_rent.isChecked()) type = 2;
        else type = 1;

        // Making an intent to call maps after click of search
        final Intent intent = new Intent(this,MapsActivity.class);

        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rentAPI_request.execute();
                startActivity(intent);
                ;
            }
        });

    }
}
