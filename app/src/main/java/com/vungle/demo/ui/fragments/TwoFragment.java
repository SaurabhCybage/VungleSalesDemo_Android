package com.vungle.demo.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.vungle.demo.R;
import com.vungle.demo.ui.activities.MainActivity;

/**
 * Created by saurabhgupt on 1/17/2017.
 */
public class TwoFragment extends Fragment {

    public TwoFragment() {
        // Required empty public constructor
    }

    //OnClick listeners for all image view in advertising page
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            switch (view.getId()) {
                case R.id.imageViewGamingUA:
                    transaction.replace(R.id.advertiseContainer, new GamingUaFragment()).addToBackStack(null);
                    transaction.commit();
                    break;
                case R.id.imageViewBrandUA:
                    transaction.replace(R.id.advertiseContainer, new BrandUaFragment()).addToBackStack(null);
                    transaction.commit();
                    break;
                case R.id.imageViewDynamicTemplates:
                    transaction.replace(R.id.advertiseContainer, new MonetizeDTemplatesFragment()).addToBackStack(null);
                    transaction.commit();
                    break;
                case R.id.imageViewNativeAdUnits:
                    transaction.replace(R.id.advertiseContainer, new MonetizeNativeAdFragment()).addToBackStack(null);
                    transaction.commit();
                    break;
                case R.id.imageViewCreativeLabs:
                    transaction.replace(R.id.advertiseContainer, new CreativeLabsFragment()).addToBackStack(null);
                    transaction.commit();
                    break;

            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_advertise_new, container, false);

        ImageView gamingUa = (ImageView) view.findViewById(R.id.imageViewGamingUA);
        gamingUa.setOnClickListener(onClickListener);

        ImageView brandUA = (ImageView) view.findViewById(R.id.imageViewBrandUA);
        brandUA.setOnClickListener(onClickListener);

        ImageView dynamicTemplates = (ImageView) view.findViewById(R.id.imageViewDynamicTemplates);
        dynamicTemplates.setOnClickListener(onClickListener);

        ImageView nativeAdUnits = (ImageView) view.findViewById(R.id.imageViewNativeAdUnits);
        nativeAdUnits.setOnClickListener(onClickListener);

        ImageView creativeLabs = (ImageView) view.findViewById(R.id.imageViewCreativeLabs);
        creativeLabs.setOnClickListener(onClickListener);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
