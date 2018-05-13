package com.example.ivc17088adm.pizzamvvm.viewmodel;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.example.ivc17088adm.pizzamvvm.adapter.PizzaAdapter;
import com.example.ivc17088adm.pizzamvvm.location.GpsTracker;
import com.example.ivc17088adm.pizzamvvm.model.Example;
import com.example.ivc17088adm.pizzamvvm.retrofit.ApiClient;
import com.example.ivc17088adm.pizzamvvm.retrofit.ApiInterface;
import com.example.ivc17088adm.pizzamvvm.util.Constants;
import com.example.ivc17088adm.pizzamvvm.view.DetailsActivity;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PizzaViewModel {

    private String postalCode;
    private Context context;

    public PizzaViewModel(Context context) {
        this.context = context;
    }

    public void fetchPizzaList(final RecyclerView recyclerView) {
        getLocation();
        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<Example> call = apiInterface.getItem(Constants.MIDDLE_URL + postalCode + Constants.REMAIN_URL);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(@NonNull Call<Example> call, @NonNull final Response<Example> response) {
                recyclerView.setAdapter(new PizzaAdapter(response.body().getQuery().getResults().getResult()));
            }

            @Override
            public void onFailure(@NonNull Call<Example> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public Location getLocation() {

        GpsTracker gpsTracker = new GpsTracker(context);
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());

        Location location = gpsTracker.getLocation();
        if (location != null) {
            try {
                List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                postalCode = addresses.get(0).getPostalCode();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return location;
    }
}