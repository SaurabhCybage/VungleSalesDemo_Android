package com.vungle.demo.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.vungle.demo.R;

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
                    Toast.makeText(getActivity(), "imageViewGamingUA", Toast.LENGTH_SHORT).show();
                    transaction.replace(R.id.advertiseContainer, new GamingUaFragment());
                    transaction.commit();
                    break;
                case R.id.imageViewBrandUA:
                    Toast.makeText(getActivity(), "imageViewBrandUA", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.imageViewDynamicTemplates:
                    Toast.makeText(getActivity(), "imageViewDynamicTemplates", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.imageViewNativeAdUnits:
                    Toast.makeText(getActivity(), "imageViewNativeAdUnits", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.imageViewCreativeLabs:
                    Toast.makeText(getActivity(), "imageViewCreativeLabs", Toast.LENGTH_SHORT).show();
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
}
