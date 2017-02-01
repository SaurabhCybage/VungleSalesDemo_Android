package com.vungle.demo.network.inf;

/**
 * Created by saurabhgupt on 1/31/2017.
 */
public interface AdCallBack {

    void onSuccess(Object responseData);

    void onFailure(Throwable exception);
}
