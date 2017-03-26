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

    RentAPI_request rentAPI_request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        max_lat = (EditText) findViewById(R.id.Edit_Maximum_Latitude);
        min_lat = (EditText) findViewById(R.id.Edit_Maximum_Latitude);
        max_long = (EditText) findViewById(R.id.Edit_Maximum_Longitude);
        min_long = (EditText) findViewById(R.id.Edit_Minimum_Longitude);
        number_bathroom = (EditText) findViewById(R.id.Edit_bathroom);
        number_bedroom = (EditText) findViewById(R.id.Edit_bedroom);
        type_rent = (Switch) findViewById(R.id.Type_Rent);
        button_search = (Button) findViewById(R.id.button_search);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        rentAPI_request = new RentAPI_request(MainActivity.this);
        rentAPI_request.setValues_URL(min_long,max_long,min_lat,max_lat,number_bathroom,number_bedroom,type_rent);

        // Making an intent to call maps after click of search
        final Intent intent = new Intent(this,MapsActivity.class);

        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rentAPI_request.execute();
                startActivity(intent);
            }
        });

    }
}
