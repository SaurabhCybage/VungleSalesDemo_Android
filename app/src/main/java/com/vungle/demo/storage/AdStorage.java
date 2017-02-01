package com.vungle.demo.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vungle.demo.models.ad_data.AdData;

import java.util.List;

/**
 * Created by saurabhgupt on 1/31/2017.
 */
public class AdStorage {

    public static final String VUNGLE_PREFERENCE_NAME = "vungle";
    public static final String VUNGLE_ADS_IDENTIFIER = "vungle_ads";
    Context context;
    SharedPreferences sharedPreferences;

    /**
     * Parameterize constructor
     *
     * @param context context to store data.
     */
    public AdStorage(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(VUNGLE_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    /**
     * This method will add or replace all ads in data base.
     *
     * @param adDataList List of all ads to be stored.
     */
    public void addOrReplaceAllReceivedAds(List<AdData> adDataList) {
        Gson gson = new Gson();
        String allAdList = gson.toJson(adDataList);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(VUNGLE_ADS_IDENTIFIER, allAdList);
        editor.commit();
    }


    /**
     * This method will return all the available ads in database.
     * @return List of all available ads.
     */
    public List<AdData> getAllAd() {
        String string = sharedPreferences.getString(VUNGLE_ADS_IDENTIFIER, null);
        Gson gson = new Gson();
        List<AdData> adDataList = (List<AdData>) gson.fromJson(string, new TypeToken<List<AdData>>() {
        }.getType());
        return adDataList;
    }


}
