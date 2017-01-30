package com.vungle.demo.ui.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vungle.demo.R;
import com.vungle.demo.ui.fragments.OneFragment;
import com.vungle.demo.ui.fragments.ThreeFragment;
import com.vungle.demo.ui.fragments.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);


        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setUpTabLayout(tabLayout);



    }

    private void setUpTabLayout(TabLayout tabLayout) {

        //Initialize tabs
        tabLayout.getTabAt(0).setCustomView(R.layout.tab_home);
        tabLayout.getTabAt(1).setCustomView(R.layout.tab_advertize);
        tabLayout.getTabAt(2).setCustomView(R.layout.tab_monetize);

        //Set listeners for tab selection and de-selection, to change the icon accordingly.
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                onTabSelection(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                TextView textView = (TextView) customView.findViewById(R.id.text);
                textView.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.text_gray));
                ImageView icon = (ImageView) customView.findViewById(R.id.icon);
                switch (tab.getPosition()) {
                    case 0:
                        icon.setImageResource(R.drawable.homeicon);
                        break;
                    case 1:
                        icon.setImageResource(R.drawable.advertiseicon);
                        break;
                    case 2:
                        icon.setImageResource(R.drawable.monetizeicon);
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                onTabSelected(tab);
            }

            private void onTabSelection(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                TextView textView = (TextView) customView.findViewById(R.id.text);
                textView.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.text_white));
                ImageView icon = (ImageView) customView.findViewById(R.id.icon);
                switch (tab.getPosition()) {
                    case 0:
                        icon.setImageResource(R.drawable.homeicon_active);
                        break;
                    case 1:
                        icon.setImageResource(R.drawable.advertiseicon_active);
                        break;
                    case 2:
                        icon.setImageResource(R.drawable.monetizeicon_active);
                        break;
                }
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        //Disabling swipping controls
        viewPager.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "ONE");
        adapter.addFragment(new TwoFragment(), "TWO");
        adapter.addFragment(new ThreeFragment(), "Three");
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


    public void onClick(View v){

    }
}
