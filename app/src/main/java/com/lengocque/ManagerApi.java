package com.lengocque;

import com.lengocque.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ManagerApi {
    public static String DOMAIN="http://dataservice.accuweather.com/";
    @GET("forecasts/v1/hourly/12hour/353412?apikey=ZQaAtjI4mHuWCazGdeLXUGQeRQpGYSdh&language=vi-vn&metric=true")
    Call<List<Item>> getdata();
}
