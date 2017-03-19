package com.tryout.rentpad;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.provider.ContactsContract;
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

    private static String API_URL = "http://www.rentrent.org/RENT/Ads.aspx?";
    private static String X_MIN = "xmin=";
    private static String Y_MIN = "&ymin=";
    private static String X_MAX = "&xmax=";
    private static String Y_MAX = "&ymax=";
    private static String BD = "&bd=";
    private static String BA = "&ba=";
    private static String TYPE = "&type=";

    MainActivity mainActivity = new MainActivity();
    Listing listing = new Listing();
    // http://www.rentrent.org/RENT/Ads.aspx?xmin=&ymin=&xmax=&ymax=&bd=&ba=&type=

    @Override
    protected String doInBackground(Void... urls) {
        try {
            URL url  = new URL(
            API_URL+X_MIN+mainActivity.xmin+Y_MIN+mainActivity.ymin+ X_MAX+mainActivity.xmax+Y_MAX+mainActivity.ymax
            +BD+mainActivity.n_bd+BA+mainActivity.n_ba+TYPE+mainActivity.type);
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
        mainActivity.max_lat.setText("");
        mainActivity.min_lat.setText("");
        mainActivity.max_long.setText("");
        mainActivity.min_long.setText("");
        mainActivity.number_bathroom.setText("");
        mainActivity.number_bedroom.setText("");
        mainActivity.type_rent.setChecked(false);
        mainActivity.progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onPostExecute(String response) {
        if (response == null) response = "There was an error";
        mainActivity.progressBar.setVisibility(View.GONE);
        try {
            jsonParser(response);
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



}
