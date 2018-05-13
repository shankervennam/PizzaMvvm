package com.example.ivc17088adm.pizzamvvm.viewmodel;

import android.content.Context;
import android.view.View;

import com.example.ivc17088adm.pizzamvvm.model.Result;
import com.example.ivc17088adm.pizzamvvm.view.DetailsActivity;

public class DataItemViewModel {
    private Result result;
    private Context context;

    public DataItemViewModel(Result result, Context context) {
        this.result = result;
        this.context = context;
    }

    public String getId() {
        return result.id;
    }

    public void setId(String id) {
        result.id = id;
    }

    public String getTitle() {
        return result.title;
    }

    public void setTitle(String title) {
        result.title = title;
    }

    public String getAddress() {
        return result.address;
    }

    public void setAddress(String address) {
        result.address = address;
    }

    public String getCity() {
        return result.city;
    }

    public void setCity(String city) {
        result.city = city;
    }

    public String getPhone() {
        return result.phone;
    }

    public void setPhone(String phone) {
        result.phone = phone;
    }

    public String getDistance() {
        return result.distance + "m";
    }

    public void setDistance(String distance) {
        result.distance = distance;
    }

    public void onItemClick(View view) {
        context.startActivity(DetailsActivity.launchDetail(view.getContext(), result));
    }
}
