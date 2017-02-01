package com.vungle.demo.network.inf;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by saurabhgupt on 1/31/2017.
 */
public interface FileDownloadingService {

    @GET
    Call<ResponseBody> downloadFileWithFixedUrl();
}
