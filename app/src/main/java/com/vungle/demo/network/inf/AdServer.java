package com.vungle.demo.network.inf;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.vungle.demo.models.ad_data.AdData;
import com.vungle.demo.storage.AdStorage;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saurabhgupt on 1/31/2017.
 */
public class AdServer {


    private final AdApis adApis;
    private AdStorage adStorage;

    public AdServer(Context context) {
        adApis = AdApis.retrofit.create(AdApis.class);
        adStorage = new AdStorage(context);
    }


    public void initialiseAdServer(final AdCallBack adCallBack) {
        Call<List<AdData>> call = adApis.getDataResponse();
        call.enqueue(new Callback<List<AdData>>() {
            @Override
            public void onResponse(Call<List<AdData>> call, Response<List<AdData>> response) {
                List<AdData> adList = response.body();
                adStorage.addOrReplaceAllReceivedAds(adList);
                adCallBack.onSuccess(adList);
            }

            @Override
            public void onFailure(Call<List<AdData>> call, Throwable t) {
                Log.e("AdServer", t.toString());
                adCallBack.onFailure(t);
            }
        });
    }


    public List<AdData> getAdsByCategory(String category) throws InvalidParameterException {
        if (TextUtils.isEmpty(category)) {
            throw new InvalidParameterException("Invalid ad category");
        }
        //TODO: validation for list of category
        List<AdData> adsByCategory = new ArrayList<AdData>();
        List<AdData> allAd = adStorage.getAllAd();
        for (AdData adData : allAd) {
            if (adData != null && adData.getSubCategory().toLowerCase().equals(category)) {
                adsByCategory.add(adData);
            }
        }
        return adsByCategory;
    }

}
