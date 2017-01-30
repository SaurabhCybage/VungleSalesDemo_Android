package com.vungle.demo.network.inf;



import com.vungle.demo.models.ad_data.GetAdDataResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by saurabhgupt on 1/30/2017.
 */
public interface AdApis {


    @GET
    Call<GetAdDataResponse> GetDataResponse();

}
