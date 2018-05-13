
package com.example.ivc17088adm.pizzamvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Query {
    @SerializedName("results")
    private Results results;

    public Results getResults() {
        return results;
    }
}
