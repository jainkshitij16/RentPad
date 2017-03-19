package com.tryout.rentpad;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Kshitij on 2017-03-18.
 */
public class RentAPI_request extends AsyncTask<Void,Void,Void> {

    private static String API_URL = "http://www.rentrent.org/RENT/Ads.aspx?";
    private static String X_MIN = "xmin=";
    private static String Y_MIN = "&ymin=";
    private static String X_MAX = "&xmax=";
    private static String Y_MAX = "&ymax=";
    private static String BD = "&bd=";
    private static String BA = "&ba=";
    private static String TYPE = "&type=";

    MainActivity mainActivity = new MainActivity();
    // http://www.rentrent.org/RENT/Ads.aspx?xmin=&ymin=&xmax=&ymax=&bd=&ba=&type=

    @Override
    protected Void doInBackground(Void... urls) {
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

    public String readStream (InputStream inputStream) throws IOException{
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
        String line = buffer.readLine();
        while (line != null){
            stringBuilder.append(line);
        }
        inputStream.close();
        return stringBuilder.toString();
    }

}
