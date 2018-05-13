
package com.example.ivc17088adm.pizzamvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Result implements Serializable {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("xmlns")
    @Expose
    public String xmlns;
    @SerializedName("Title")
    @Expose
    public String title;
    @SerializedName("Address")
    @Expose
    public String address;
    @SerializedName("City")
    @Expose
    public String city;
    @SerializedName("State")
    @Expose
    public String state;
    @SerializedName("Phone")
    @Expose
    public String phone;
    @SerializedName("Latitude")
    @Expose
    public String latitude;
    @SerializedName("Longitude")
    @Expose
    public String longitude;
    @SerializedName("Rating")
    @Expose
    private Rating rating;
    @SerializedName("Distance")
    @Expose
    public String distance;
    @SerializedName("Url")
    @Expose
    private String url;
    @SerializedName("ClickUrl")
    @Expose
    private String clickUrl;
    @SerializedName("MapUrl")
    @Expose
    private String mapUrl;
    @SerializedName("BusinessUrl")
    @Expose
    private String businessUrl;
    @SerializedName("BusinessClickUrl")
    @Expose
    private String businessClickUrl;

//    private Categories categories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
