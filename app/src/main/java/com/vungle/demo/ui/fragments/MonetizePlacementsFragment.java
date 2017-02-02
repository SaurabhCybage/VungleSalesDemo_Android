package com.vungle.demo.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vungle.demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonetizePlacementsFragment extends Fragment {


    public MonetizePlacementsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_monetize_placements, container, false);

        TextView textViewAdHeaderTitle = (TextView) view.findViewById(R.id.textViewAdHeaderTitle);
        textViewAdHeaderTitle.setText("Placements");

        return view;
    }

}
