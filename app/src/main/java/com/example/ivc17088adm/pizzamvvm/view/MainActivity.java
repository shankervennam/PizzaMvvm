package com.example.ivc17088adm.pizzamvvm.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Geocoder;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ivc17088adm.pizzamvvm.R;
import com.example.ivc17088adm.pizzamvvm.databinding.ActivityMainBinding;
import com.example.ivc17088adm.pizzamvvm.location.GpsTracker;
import com.example.ivc17088adm.pizzamvvm.viewmodel.PizzaViewModel;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final int PERMISSION_REQ = 123;
    private ActivityMainBinding activityMainBinding;
    GpsTracker gpsTracker;
    Geocoder geocoder;
    PizzaViewModel mPizzaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mPizzaViewModel = new PizzaViewModel(MainActivity.this);

        initLocation();
    }

    private void initRecyclerView(final RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        mPizzaViewModel.fetchPizzaList(recyclerView);

        gpsTracker = new GpsTracker(getApplicationContext());
        geocoder = new Geocoder(getBaseContext(), Locale.getDefault());
    }

    private void initLocation() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_REQ);
            } else {
                initRecyclerView(activityMainBinding.recyclerViewList);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQ:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initRecyclerView(activityMainBinding.recyclerViewList);
                }
        }
    }
}
