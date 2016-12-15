package com.example.android.threadsample.materialpager;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by kishna.147 on 12/12/16.
 */

public class ApplicationClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Calligraphy Implementation Is In Progess

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/RobotoCondensed-Regular.ttf")

                .setFontAttrId(R.attr.fontPath)

                .build()
        );
    }
}