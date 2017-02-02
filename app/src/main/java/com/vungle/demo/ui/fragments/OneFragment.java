
package com.vungle.demo.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vungle.demo.R;

import me.relex.circleindicator.CircleIndicator;

public class OneFragment extends Fragment {

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View mRootView = inflater.inflate(R.layout.parentviewpagerfrag, container, false);

        ViewPager mViewPager = (ViewPager) mRootView.findViewById(R.id.viewPager);
        CircleIndicator indicator = (CircleIndicator) mRootView.findViewById(R.id.indicator);
        mViewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        indicator.setViewPager(mViewPager);

        return mRootView;

    }

    /*
     * @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
     * super.onViewCreated(view, savedInstanceState); ViewPager mViewPager = (ViewPager)
     * view.findViewById(R.id.viewPager); CircleIndicator indicator = (CircleIndicator)
     * view.findViewById(R.id.indicator); mViewPager.setAdapter(new
     * MyAdapter(getChildFragmentManager())); indicator.setViewPager(mViewPager); }
     */

    public static class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new HomeSlide1Fragment();

                case 1:
                    return new HomeSlide2Fragment();

                case 2:
                    return new HomeSlide3Fragment();

                case 3:
                    return new HomeSlide4Fragment();

                default:
                    return new HomeSlide1Fragment();

                /*
                 * Bundle args = new Bundle(); args.putInt(ChildFragment.POSITION_KEY, position);
                 * return ChildFragment.newInstance(args);
                 */
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Child Fragment " + position;
        }

    }
}
