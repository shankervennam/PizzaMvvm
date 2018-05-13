package com.example.ivc17088adm.pizzamvvm.viewmodel;

import android.view.View;

import com.example.ivc17088adm.pizzamvvm.model.Result;
import com.example.ivc17088adm.pizzamvvm.view.DetailsActivity;

public class DetailsItemViewModel {
    private Result result;
    DetailsActivity detailsActivity;

    public DetailsItemViewModel(Result result) {
        this.result = result;
    }

    public String getTitle() {
        return result.title;
    }

    public String getCity() {
        return result.city;
    }

    public String getDate() {
        return result.getAddress() + "," + result.getCity() + "," + result.getState() ;
    }

    public String getReview() {
        return result.getRating().getLastReviewIntro();
    }

    public void onLocationClick(View view) {
        DetailsActivity.launchLocation(view.getContext());
    }

    public void onPhoneClick(View view) {
        DetailsActivity.launchPhoneCall(view.getContext(), result);
    }
}
