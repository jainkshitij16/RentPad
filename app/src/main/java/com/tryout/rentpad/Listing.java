package com.tryout.rentpad;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.provider.ContactsContract;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;

/**
 * Created by Kshitij on 2017-03-19.
 */
public class Listing {

    private String title_listing;
    private URL url_listing;
    private String price_listing;
    private String street_name_listing;
    private String city_listing;
    private String zip_listing;
    private String add_date_listing;
   // private Drawable image_listing;
    private String longitude_listing;
    private String latitude_listing;
    private String phone_listing;
    private String num_bd_listing;
    private String num_ba_listing;
    private String email_listing;


    public Listing(){
    }

    public Listing(String title_listing, String street_name_listing, String phone_listing) {
        this.title_listing = title_listing;
        this.street_name_listing = street_name_listing;
        this.phone_listing = phone_listing;
    }


    public void setTitle_listing(String title_listing) {
        this.title_listing = title_listing;
    }

    public void setUrl_listing(URL url_listing) {
        this.url_listing = url_listing;
    }

    public void setPrice_listing(String price_listing) {
        this.price_listing = price_listing;
        if(price_listing=="")this.price_listing = "Not available";
    }

    public void setStreet_name_listing(String street_name_listing) {
        this.street_name_listing = street_name_listing;
        if(street_name_listing=="")this.street_name_listing = "Not available";
    }

    public void setCity_listing(String city_listing) {
        this.city_listing = city_listing;
        if(city_listing=="")this.city_listing = "Not available";
    }

    public void setZip_listing(String zip_listing) {
        this.zip_listing = zip_listing;
        if(zip_listing=="")this.zip_listing = "Not available";
    }

    public void setAdd_date_listing(String add_date_listing) {
        this.add_date_listing = add_date_listing;
        if(add_date_listing=="")this.add_date_listing = "Not available";
    }
    /*
    public void setImage_listing(Drawable image_listing) {
        this.image_listing = image_listing;
        if(image_listing.)

    }
     */

    public void setLongitude_listing(String longitude_listing) {
        this.longitude_listing = longitude_listing;
        if(longitude_listing=="")this.longitude_listing = "Not available";
    }

    public void setLatitude_listing(String latitude_listing) {
        this.latitude_listing = latitude_listing;
        if(latitude_listing=="")this.latitude_listing = "Not available";
    }

    public void setPhone_listing(String phone_listing) {
        this.phone_listing = phone_listing;
        if(phone_listing=="")this.phone_listing = "Not available";
    }

    public void setNum_bd_listing(String num_bd_listing) {
        this.num_bd_listing = num_bd_listing;
        if(num_bd_listing=="")this.num_bd_listing = "Not available";
    }

    public void setNum_ba_listing(String num_ba_listing) {
        this.num_ba_listing = num_ba_listing;
        if(num_ba_listing=="")this.num_ba_listing = "Not available";
    }

    public void setEmail_listing(String email_listing) {
        this.email_listing = email_listing;
    }

    public String getTittle_listing() {
        return title_listing;
    }

    public URL getUrl_listing() {
        return url_listing;
    }

    public String getPrice_listing() {
        return price_listing;
    }

    public String getStreet_name_listing() {
        return street_name_listing;
    }

    public String getCity_listing() {
        return city_listing;
    }

    public String getZip_listing() {
        return zip_listing;
    }

    public String getAdd_date_listing() {
        return add_date_listing;
    }

   /*
    public Drawable getImage_listing() {
     return image_listing;
    }

     */

    public String getLongitude_listing() {
        return longitude_listing;
    }

    public String getLatitude_listing() {
        return latitude_listing;
    }

    public String getPhone_listing() {
        return phone_listing;
    }

    public String getNum_bd_listing() {
        return num_bd_listing;
    }

    public String getNum_ba_listing() {
        return num_ba_listing;
    }

    public String getEmail_listing() {
        return email_listing;
    }
}
