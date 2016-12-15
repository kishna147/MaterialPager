package com.stingo.materialpager.activities;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.bumptech.glide.Glide;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.stingo.materialpager.R;
import com.stingo.materialpager.fragments.Fragment1;
import com.stingo.materialpager.fragments.Fragment2;
import com.stingo.materialpager.fragments.Fragment3;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by kishna.147 on 12/12/16.
 */

public class NavDrawer extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AppBarLayout appBarLayout;
    private KenBurnsView img_kenburn;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(getLayoutResourceId());
      //  setSupportActionBar(getToolbar());







        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);


     //   viewpagertab=(SmartTabLayout) findViewById(R.id.viewpagertab);

       tabLayout = (TabLayout) findViewById(R.id.tabs);
        img_kenburn=(KenBurnsView) findViewById(R.id.img_kenburn);
       tabLayout.setupWithViewPager(viewPager);
     //   viewpagertab.setViewPager(viewPager);
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        NestedScrollView scrollView = (NestedScrollView) findViewById (R.id.nest_scrollview);
        scrollView.setFillViewport (true);


    //   Glide.with(NavDrawer.this).load("https://shop.nosegraze.com/wp-content/uploads/2012/01/aquatica-wallpaper.jpg").override(600,300).into(img_kenburn);

       // Glide.with(NavDrawer.this).load("http://www.technocrazed.com/wp-content/uploads/2015/12/Landscape-wallpaper-10.jpg").override(600,300).into(img_kenburn);

     //  Glide.with(NavDrawer.this).load("http://thewallpaper.co/wp-content/uploads/2016/10/Beautiful-winter-now-wallpaper-landscape-download-windows-apple-colourful-amazing-cool-desktop-wallpapers-high-definition-1920x1080-736x459.jpg").override(600,300).into(img_kenburn);

      //  Glide.with(NavDrawer.this).load("http://i1.wallpaperscraft.com/image/city_night_church_lights_beauty_58859_1920x1080.jpg").override(600,300).into(img_kenburn);

       Glide.with(NavDrawer.this).load("https://thisconjecture.files.wordpress.com/2013/11/so-so-beutiful.jpg").override(600,300).into(img_kenburn);

   //     Glide.with(NavDrawer.this).load("http://www.androidpolice.com/wp-content/uploads/2013/11/nexusae0_wallpaper_51.jpg").override(600,300).into(img_kenburn);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0)
                {   // Collapsed
                    img_kenburn.resume();

                }
                else
                {
                    // Not collapsed
                    img_kenburn.pause();

                }
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_nav_drawer;
    }

    @Override
    protected Toolbar getToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        return toolbar;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment2(), "ONE");
        adapter.addFragment(new Fragment1(), "TWO");
        adapter.addFragment(new Fragment3(), "THREE");
        adapter.addFragment(new Fragment2(), "FOUR");
        adapter.addFragment(new Fragment1(), "FIVE");
        adapter.addFragment(new Fragment3(), "SIX");
        viewPager.setAdapter(adapter);
    }



    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
