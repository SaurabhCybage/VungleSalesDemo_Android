package com.vungle.demo.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.vungle.demo.R;

public class ChildFragment extends Fragment implements View.OnClickListener {

    public static final String POSITION_KEY = "FragmentPositionKey";
    private int position;

    public static ChildFragment newInstance(Bundle args) {
        ChildFragment fragment = new ChildFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        position = getArguments().getInt(POSITION_KEY);

        View root = inflater.inflate(R.layout.fragment_one, container, false);
        TextView textview = (TextView) root.findViewById(R.id.textView);
        textview.setText(Integer.toString(position));
        textview.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), "Clicked Position: " + position, Toast.LENGTH_LONG).show();
    }
}