
package com.example.ivc17088adm.pizzamvvm.model;

import android.location.Location;

import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("query")
    private Query query;

    public void setQuery(Query query) {
        this.query = query;
    }
    public Query getQuery() {
        return query;
    }
}
