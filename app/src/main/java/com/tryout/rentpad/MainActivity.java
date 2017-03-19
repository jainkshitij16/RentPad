package com.tryout.rentpad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
