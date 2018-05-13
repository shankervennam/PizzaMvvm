package com.example.ivc17088adm.pizzamvvm.retrofit;

import com.example.ivc17088adm.pizzamvvm.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiInterface {
    @GET Call<Example> getItem(@Url String url);
}
