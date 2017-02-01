package com.vungle.demo.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vungle.demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonetizeFragment extends Fragment {


    public MonetizeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_monetize, container, false);
    }

}
