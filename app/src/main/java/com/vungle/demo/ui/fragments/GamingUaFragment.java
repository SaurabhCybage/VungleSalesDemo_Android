package com.vungle.demo.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vungle.demo.R;
import com.vungle.demo.VungleApplication;
import com.vungle.demo.models.ad_data.AdData;
import com.vungle.demo.network.inf.AdServer;
import com.vungle.demo.ui.adapters.GamingUaAdapter;

import java.util.List;

/**
 * Created by saurabhgupt on 2/1/2017.
 */
public class GamingUaFragment extends Fragment {

    private RecyclerView recyclerViewGamingUa;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gamingua, container, false);
        recyclerViewGamingUa = (RecyclerView) view.findViewById(R.id.recyclerViewGamingUA);
        AdServer adServer = VungleApplication.getsApplication().getAdServer();

        List<AdData> gamingUaAds = adServer.getAdsByCategory("gaming-ua");
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        recyclerViewGamingUa.setLayoutManager(mLayoutManager);
        recyclerViewGamingUa.setItemAnimator(new DefaultItemAnimator());
        recyclerViewGamingUa.setAdapter(new GamingUaAdapter(getActivity(), gamingUaAds));

        return view;
    }

}
