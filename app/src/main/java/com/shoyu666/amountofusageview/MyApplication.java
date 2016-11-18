package com.shoyu666.amountofusageview;

import android.app.Application;

/**
 * Created by n on 2016/11/18.
 */

public class MyApplication extends android.app.Application{
    public static Application mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext=this;
    }
}
