package com.tryout.rentpad;

import android.media.Image;
import android.provider.ContactsContract;

import java.net.URL;
import java.util.Date;

/**
 * Created by Kshitij on 2017-03-19.
 */
public class Listing {

    private String tittle_listing;
    private URL url_listing;
    private int price_listing;
    private String street_name_listing;
    private String city_listing;
    private String zip_listing;
    private Date add_date_listing;
    private Image image_listing;
    private int longitude_listing;
    private int latitude_listing;
    private int phone_listing;
    private int num_bd_listing;
    private int num_ba_listing;
    private ContactsContract.CommonDataKinds.Email email_listing;


    public Listing(){
    }

    public Listing(String tittle_listing, String street_name_listing, int phone_listing) {
        this.tittle_listing = tittle_listing;
        this.street_name_listing = street_name_listing;
        this.phone_listing = phone_listing;
    }

    public Listing(String tittle_listing, String street_name_listing, ContactsContract.CommonDataKinds.Email email_listing) {
        this.tittle_listing = tittle_listing;
        this.street_name_listing = street_name_listing;
        this.email_listing = email_listing;
    }

    public void setTittle_listing(String tittle_listing) {
        this.tittle_listing = tittle_listing;
    }

    public void setUrl_listing(URL url_listing) {
        this.url_listing = url_listing;
    }

    public void setPrice_listing(int price_listing) {
        this.price_listing = price_listing;
    }

    public void setStreet_name_listing(String street_name_listing) {
        this.street_name_listing = street_name_listing;
    }

    public void setCity_listing(String city_listing) {
        this.city_listing = city_listing;
    }

    public void setZip_listing(String zip_listing) {
        this.zip_listing = zip_listing;
    }

    public void setAdd_date_listing(Date add_date_listing) {
        this.add_date_listing = add_date_listing;
    }

    public void setImage_listing(Image image_listing) {
        this.image_listing = image_listing;
    }

    public void setLongtitude_listing(int longtitude_listing) {
        this.longitude_listing = longtitude_listing;
    }

    public void setLatitude_listing(int latitude_listing) {
        this.latitude_listing = latitude_listing;
    }

    public void setPhone_listing(int phone_listing) {
        this.phone_listing = phone_listing;
    }

    public void setNum_bd_listing(int num_bd_listing) {
        this.num_bd_listing = num_bd_listing;
    }

    public void setNum_ba_listing(int num_ba_listing) {
        this.num_ba_listing = num_ba_listing;
    }

    public void setEmail_listing(ContactsContract.CommonDataKinds.Email email_listing) {
        this.email_listing = email_listing;
    }

    public String getTittle_listing() {
        return tittle_listing;
    }

    public URL getUrl_listing() {
        return url_listing;
    }

    public int getPrice_listing() {
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

    public Date getAdd_date_listing() {
        return add_date_listing;
    }

    public Image getImage_listing() {
        return image_listing;
    }

    public int getLongtitude_listing() {
        return longitude_listing;
    }

    public int getLatitude_listing() {
        return latitude_listing;
    }

    public int getPhone_listing() {
        return phone_listing;
    }

    public int getNum_bd_listing() {
        return num_bd_listing;
    }

    public int getNum_ba_listing() {
        return num_ba_listing;
    }

    public ContactsContract.CommonDataKinds.Email getEmail_listing() {
        return email_listing;
    }
}
