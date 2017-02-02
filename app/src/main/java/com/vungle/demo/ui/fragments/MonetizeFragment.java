package com.vungle.demo.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.vungle.demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonetizeFragment extends Fragment {


    /**
     * Click listeners
     */
    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            switch (view.getId()) {
                case R.id.imageViewDynamicTemplates:
                    transaction.replace(R.id.advertiseContainer, new MonetizeDTemplatesFragment()).addToBackStack(null);
                    transaction.commit();
                    break;
                case R.id.imageViewNativeAdUnits:
                    transaction.replace(R.id.advertiseContainer, new MonetizeNativeAdFragment()).addToBackStack(null);
                    transaction.commit();
                    break;
                case R.id.imageViewPlacements:
                    transaction.replace(R.id.advertiseContainer, new MonetizePlacementsFragment()).addToBackStack(null);
                    transaction.commit();
                    break;
            }
        }
    };

    public MonetizeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_monetize, container, false);

        ImageView dynamicTemplates = (ImageView) view.findViewById(R.id.imageViewDynamicTemplates);
        dynamicTemplates.setOnClickListener(onClickListener);

        ImageView nativeAdUnits = (ImageView) view.findViewById(R.id.imageViewNativeAdUnits);
        nativeAdUnits.setOnClickListener(onClickListener);

        ImageView imageViewPlacements = (ImageView) view.findViewById(R.id.imageViewPlacements);
        imageViewPlacements.setOnClickListener(onClickListener);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
