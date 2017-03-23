package com.tryout.rentpad;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Kshitij on 2017-03-18.
 */
public class RentAPI_request extends AsyncTask<Void,Void,String> {

    // Constants
    private static String API_URL = "http://www.rentrent.org/RENT/Ads.aspx?";
    private static String X_MIN = "xmin=";
    private static String Y_MIN = "&ymin=";
    private static String X_MAX = "&xmax=";
    private static String Y_MAX = "&ymax=";
    private static String BD = "&bd=";
    private static String BA = "&ba=";
    private static String TYPE = "&type=";
    private static double MIN_LONG = 49.2765;
    private static double MIN_LAT = -123.2177;
    private static int BATH_BED = 1;

    // Variables
    public double xmin;
    public double xmax;
    public double ymin;
    public double ymax;
    public int n_ba;
    public int n_bd;
    public int type;

    // Classes to be initialized
    MainActivity mainActivity;
    Listing listing;
    MapsActivity mapsActivity;

    // http://www.rentrent.org/RENT/Ads.aspx?xmin=&ymin=&xmax=&ymax=&bd=&ba=&type=

    public RentAPI_request(){
        mainActivity = new MainActivity();
        listing = new Listing();
        mapsActivity = new MapsActivity();
    }

    @Override
    protected String doInBackground(Void... urls) {
        try {
            URL url  = new URL(
            API_URL+X_MIN+xmin+Y_MIN+ymin+ X_MAX+xmax+Y_MAX+ymax+BD+n_bd+BA+n_ba+TYPE+type);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
                readStream(inputStream);

            }catch (Exception e){
                Log.e(e.getMessage(),"No data retrieved");
            }
            finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            Log.e(e.getMessage(),"URL not found");
        }
        return null;
    }


    protected void onPreExecute() {
        setValues_URL();
    }


    @Override
    protected void onPostExecute(String response) {
        if (response == null) response = "There was an error";
        mainActivity.progressBar.setVisibility(View.GONE);
        try {
            Listing lis = jsonParser(response);
            // Helps in setting the listing and displaying it on map
            mapsActivity.setListing_display(lis);
        } catch (Exception e) {
            Log.e(e.getMessage(),"Data not parsed correctly");
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        mainActivity.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCancelled() {
        onPreExecute();
    }

    public String readStream(InputStream inputStream) throws IOException{
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
        String line = buffer.readLine();
        while (line != null){
            stringBuilder.append(line);
        }
        inputStream.close();
        return stringBuilder.toString();
    }

    /*
    public static Drawable LoadImageFromWebOperations(String url) {
    try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
     */

    /*
     Parses the JSON data into a listing object containing all the attributes to display.
     parses each attribute as a string and url as a url
     */
    public Listing jsonParser(String response) throws JSONException, MalformedURLException {
        JSONObject jsonObject = new JSONObject(response);
        listing.setUrl_listing(new URL(jsonObject.getString("rssurl")));
        listing.setPrice_listing(jsonObject.getString("price"));
        listing.setTitle_listing(jsonObject.getString("title"));
        listing.setStreet_name_listing(jsonObject.getString("housenumstreetname"));
        listing.setCity_listing(jsonObject.getString("city"));
        listing.setZip_listing(jsonObject.getString("zip"));
        //listing.setImage_listing(LoadImageFromWebOperations(jsonObject.getString("images")));
        listing.setLongitude_listing(jsonObject.getString("x"));
        listing.setLatitude_listing(jsonObject.getString("y"));
        listing.setAdd_date_listing(jsonObject.getString("addate"));
        listing.setPhone_listing(jsonObject.getString("phone"));
        listing.setNum_bd_listing(jsonObject.getString("bedrooms"));
        listing.setNum_ba_listing(jsonObject.getString("bathrooms"));
        listing.setEmail_listing(jsonObject.getString("email"));

        return listing;
    }

    /*
     Uses the MainActivity edit_text fields to assign data to form a request
     */
    public void setValues_URL (){
        // if statements to make up something
        if(mainActivity.min_long.toString() !=null) xmin = (double) Integer.parseInt(mainActivity.min_long.toString());
        else xmin = MIN_LONG;

        if(mainActivity.min_lat.toString() !=null) ymin = (double) Integer.parseInt(mainActivity.min_lat.toString());
        else ymin = MIN_LAT;

        if(mainActivity.max_long.toString() !=null) xmax = (double) Integer.parseInt(mainActivity.max_long.toString());
        else xmax = MIN_LONG+5.00;

        if(mainActivity.max_lat.toString() !=null) ymax = (double) Integer.parseInt(mainActivity.max_lat.toString());
        else ymax = MIN_LAT+5.00;

        if(mainActivity.number_bathroom.toString() !=null) n_ba = Integer.parseInt(mainActivity.number_bathroom.toString());
        else n_ba = BATH_BED;

        if(mainActivity.number_bedroom.toString() !=null) n_bd = Integer.parseInt(mainActivity.number_bedroom.toString());
        else n_bd = BATH_BED;

        if(mainActivity.type_rent.isChecked()) type = 2;
        else type = 1;


    }

}
