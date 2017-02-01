package com.vungle.demo.network.inf;



import com.vungle.demo.models.ad_data.AdData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by saurabhgupt on 1/30/2017.
 */
public interface AdApis {


    @GET("ads")
    Call<List<AdData>> getDataResponse();


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://172.27.237.97:8080/salesdemo/wp-json/wp/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
