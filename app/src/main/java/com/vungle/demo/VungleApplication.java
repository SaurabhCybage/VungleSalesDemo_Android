package com.vungle.demo;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.vungle.demo.models.ad_data.AdData;
import com.vungle.demo.network.inf.AdCallBack;
import com.vungle.demo.network.inf.AdServer;

import java.util.List;

/**
 * Custom application class
 * Created by saurabhgupt on 2/1/2017.
 */
public class VungleApplication extends Application {

    private static VungleApplication sVungleApplication;
    private static Context sContext;


    private AdServer mAdServer;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    public static VungleApplication getsApplication() {
        if (sVungleApplication == null) {
            synchronized (VungleApplication.class) {
                if (sVungleApplication == null)
                    sVungleApplication = new VungleApplication();
            }
        }
        return sVungleApplication;
    }

    public AdServer getAdServer() {
        return mAdServer;
    }

    public void initialiseAdServer() {
        mAdServer = new AdServer(sContext);
        mAdServer.initialiseAdServer(new AdCallBack() {
            @Override
            public void onSuccess(Object responseData) {
                List<AdData> adDataList = (List<AdData>) responseData;

                for (AdData adData : adDataList) {
                    Log.i("saurabh", adData.toString());
                }
            }

            @Override
            public void onFailure(Throwable exception) {

            }
        });
    }


}
