package com.vungle.demo.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.vungle.demo.R;
import com.vungle.demo.VungleApplication;
import com.vungle.demo.models.ad_data.AdData;
import com.vungle.demo.network.inf.AdCallBack;
import com.vungle.demo.network.inf.AdServer;
import com.vungle.demo.ui.adapters.AdAdapter;

import java.util.List;

/**
 * Created by saurabhgupt on 2/1/2017.
 */
public class BrandUaFragment extends Fragment {

    public static final String AD_CATEGORY = "brand-ua";
    private RecyclerView recyclerViewGamingUa;
    private AdAdapter mAdAdapter;
    private List<AdData> mAdList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ad_list, container, false);
        setSwipeRefreshLayout(view);

        TextView textViewAdHeaderTitle = (TextView) view.findViewById(R.id.textViewAdHeaderTitle);
        textViewAdHeaderTitle.setText("Brand UA");

        recyclerViewGamingUa = (RecyclerView) view.findViewById(R.id.recyclerViewGamingUA);
        AdServer adServer = VungleApplication.getsApplication().getAdServer();

        mAdList = adServer.getAdsByCategory(AD_CATEGORY);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        recyclerViewGamingUa.setLayoutManager(mLayoutManager);
        recyclerViewGamingUa.setItemAnimator(new DefaultItemAnimator());
        mAdAdapter = new AdAdapter(getActivity(), mAdList);
        recyclerViewGamingUa.setAdapter(mAdAdapter);

        return view;
    }


    private SwipeRefreshLayout mSwipeRefreshLayout;

    private void setSwipeRefreshLayout(View view) {
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                final AdServer adServer = VungleApplication.getsApplication().getAdServer();
                adServer.refreshAdData(new AdCallBack() {
                    @Override
                    public void onSuccess(Object responseData) {
                        mAdList = adServer.getAdsByCategory(AD_CATEGORY);
                        mAdAdapter = new AdAdapter(getActivity(), mAdList);
                        recyclerViewGamingUa.setAdapter(mAdAdapter);
                        mSwipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onFailure(Throwable exception) {
                        Toast.makeText(getActivity(), "Something went wrong!", Toast.LENGTH_SHORT).show();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        });
    }
}
