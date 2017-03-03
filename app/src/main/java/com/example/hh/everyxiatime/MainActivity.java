package com.example.hh.everyxiatime;

        import android.app.ActionBar;
        import android.app.Activity;
        import android.app.TabActivity;
        import android.content.Intent;
        import android.content.res.Resources;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentActivity;
        import android.support.v4.app.FragmentPagerAdapter;
        import android.support.v4.view.ViewPager;
        import android.support.v4.widget.SearchViewCompat;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TabHost;
        import android.widget.Toast;

        import com.google.android.youtube.player.YouTubeApiServiceUtil;
        import com.google.android.youtube.player.YouTubeBaseActivity;
        import com.google.android.youtube.player.YouTubeInitializationResult;
        import com.google.android.youtube.player.YouTubePlayer;
        import com.google.android.youtube.player.YouTubePlayer.Provider;
        import com.google.android.youtube.player.YouTubePlayerView;



public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private int NUM_PAGES = 3;

    public  final static int FRAGMENT_PAGE1 = 0;
    public  final static int FRAGMENT_PAGE2 = 1;
    public  final static int FRAGMENT_PAGE3 = 2;

    ViewPager mViewPager;

    Button p1, p2, p3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        mViewPager.setCurrentItem(FRAGMENT_PAGE1);

        p1 = (Button) findViewById(R.id.button);
        p1.setOnClickListener(this);
        p2 = (Button) findViewById(R.id.button2);
        p2.setOnClickListener(this);
        p3 = (Button) findViewById(R.id.button3);
        p3.setOnClickListener(this);

    }

    private class pagerAdapter extends FragmentPagerAdapter {
        public pagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case FRAGMENT_PAGE1:
                    return new test1();
                case FRAGMENT_PAGE2:
                    return new test2();
                case FRAGMENT_PAGE3:
                    return new test3();
                default:
                    return null;
            }

        }

        @Override
        public int getCount(){
            return NUM_PAGES;
        }
    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button:
                mViewPager.setCurrentItem(FRAGMENT_PAGE1);
                break;
            case R.id.button2:
                mViewPager.setCurrentItem(FRAGMENT_PAGE2);
                break;
            case R.id.button3:
                mViewPager.setCurrentItem(FRAGMENT_PAGE3);
                break;
        }
    }
}