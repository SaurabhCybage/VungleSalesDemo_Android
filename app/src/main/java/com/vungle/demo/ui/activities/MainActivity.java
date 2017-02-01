package com.vungle.demo.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vungle.demo.R;
import com.vungle.demo.ui.fragments.OneFragment;
import com.vungle.demo.ui.fragments.ThreeFragment;
import com.vungle.demo.ui.fragments.TwoFragment;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        setUpTabLayout(tabLayout);

    }

    private void setUpTabLayout(TabLayout tabLayout) {

        tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_home));
        tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_advertize));
        tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_monetize));
//        //Initialize tabs
//        tabLayout.getTabAt(0).setCustomView(R.layout.tab_home);
//        tabLayout.getTabAt(1).setCustomView(R.layout.tab_advertize);
//        tabLayout.getTabAt(2).setCustomView(R.layout.tab_monetize);

        //Set listeners for tab selection and de-selection, to change the icon accordingly.
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
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

                clearBackStack();

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                switch (tab.getPosition()) {
                    case 0:
                        icon.setImageResource(R.drawable.homeicon_active);
                        fragmentTransaction.replace(R.id.advertiseContainer, new OneFragment()).addToBackStack(null).commit();
                        break;
                    case 1:
                        icon.setImageResource(R.drawable.advertiseicon_active);
                        fragmentTransaction.replace(R.id.advertiseContainer, new TwoFragment()).addToBackStack(null).commit();
                        break;
                    case 2:
                        icon.setImageResource(R.drawable.monetizeicon_active);
                        fragmentTransaction.replace(R.id.advertiseContainer, new ThreeFragment()).addToBackStack(null).commit();
                        break;
                }
            }
        });
    }

    /**
     * Since clicked on tab so clearing all previous back stack entry of fragments.
     */
    private void clearBackStack() {
        FragmentManager fm = getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }

    //
//    @Override
//    public void onBackPressed() {
//        if (getFragmentManager().getBackStackEntryCount() > 0)
//            getFragmentManager().popBackStack();
//        else
//            super.onBackPressed();
//    }
//
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageViewBackButton:
                getFragmentManager().popBackStack();
                break;
        }
    }

}
