package com.example.ivc17088adm.pizzamvvm.view;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.example.ivc17088adm.pizzamvvm.R;
import com.example.ivc17088adm.pizzamvvm.databinding.ItemDetailsViewBinding;
import com.example.ivc17088adm.pizzamvvm.model.Result;
import com.example.ivc17088adm.pizzamvvm.viewmodel.DetailsItemViewModel;
import com.example.ivc17088adm.pizzamvvm.viewmodel.PizzaViewModel;

public class DetailsActivity extends AppCompatActivity {

    private static final String EXTRA_PEOPLE = "EXTRA_PEOPLE";

    ItemDetailsViewBinding itemDetailsViewBinding;
    private static PizzaViewModel pizzaViewModel;
    private static Activity applicationContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        itemDetailsViewBinding = DataBindingUtil.setContentView(this, R.layout.item_details_view);

        getExtrasFromIntent();
        pizzaViewModel = new PizzaViewModel(this);
        applicationContext = DetailsActivity.this;
    }

    public static Intent launchDetail(Context context, Result result) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(EXTRA_PEOPLE, result);
        return intent;
    }

    public static void launchLocation(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/?api=1&query="
                + pizzaViewModel.getLocation().getLatitude() + "," + pizzaViewModel.getLocation().getLongitude()));
        applicationContext.startActivity(intent);
    }

    public void getExtrasFromIntent() {
        Result result = (Result) getIntent().getSerializableExtra(EXTRA_PEOPLE);
        DetailsItemViewModel detailsItemViewModel = new DetailsItemViewModel(result);
        itemDetailsViewBinding.setResultDisplay(detailsItemViewModel);
    }

    public static void launchPhoneCall(Context context, Result result) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + result.phone.replaceAll("[\\D]", "")));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(applicationContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                ActivityCompat.requestPermissions(applicationContext, new String[]{Manifest.permission.CALL_PHONE}, 1);
                if (ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    applicationContext.startActivity(intent);
                }
            } else {
                applicationContext.startActivity(intent);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (pizzaViewModel != null) {
            pizzaViewModel = null;
        }

        if (applicationContext != null) {
            applicationContext = null;
        }
    }
}
