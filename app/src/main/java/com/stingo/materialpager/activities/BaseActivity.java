package com.stingo.materialpager.activities;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.stingo.materialpager.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by kishna.147 on 12/9/16.
 */

public abstract  class BaseActivity extends AppCompatActivity {
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        setSupportActionBar(getToolbar());


        final Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/PlayfairDisplay-Regular.otf");
        ((CollapsingToolbarLayout) findViewById(R.id.toolbar_layout)).setCollapsedTitleTypeface(tf);
        ((CollapsingToolbarLayout) findViewById(R.id.toolbar_layout)).setExpandedTitleTypeface(tf);

     //   getSupportActionBar().setDisplayShowTitleEnabled(false);
    /*    SpannableString s = new SpannableString("Nav Drawer");
        s.setSpan(new TypefaceSpan("gtw.ttf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Update the action bar title with the TypefaceSpan instance

        getSupportActionBar().setTitle(s);*/
    }

    protected abstract int getLayoutResourceId();

    protected abstract Toolbar getToolbar();

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
