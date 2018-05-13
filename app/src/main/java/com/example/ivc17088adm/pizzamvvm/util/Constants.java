package com.example.ivc17088adm.pizzamvvm.util;

public interface Constants {
    public final String BASE_URL = "https://query.yahooapis.com/v1/public/";
    public final String REMAIN_URL = "%27%20and%20query%3D%27pizza%27&format=json&diagnostics=true&callback=";
    public final String MIDDLE_URL = "yql?q=select%20*%20from%20local.search%20where%20zip%3D%27";
}
