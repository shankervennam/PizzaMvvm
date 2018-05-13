
package com.example.ivc17088adm.pizzamvvm.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Rating implements Serializable {

    @SerializedName("AverageRating")
    private String averageRating;
    @SerializedName("TotalRatings")
    private String totalRatings;
    @SerializedName("TotalReviews")
    private String totalReviews;

    public String getLastReviewIntro() {
        return lastReviewIntro;
    }

    @SerializedName("LastReviewIntro")
    private String lastReviewIntro;
}
