package com.vungle.demo.ui.adapters;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vungle.demo.R;
import com.vungle.demo.models.ad_data.AdData;

import java.util.List;

/**
 * Created by saurabhgupt on 2/1/2017.
 */
public class GamingUaAdapter extends RecyclerView.Adapter<GamingUaAdapter.GamingUAViewHolder> {

    FragmentActivity activityContext;
    List<AdData> adDataList;

    public GamingUaAdapter(FragmentActivity activityContext, List<AdData> adDataList) {
        this.activityContext = activityContext;
        this.adDataList = adDataList;
    }

    public class GamingUAViewHolder extends RecyclerView.ViewHolder {
        public TextView adTitle;

        public GamingUAViewHolder(View view) {
            super(view);
            adTitle = (TextView) view.findViewById(R.id.textViewAdTitle);
        }
    }

    @Override
    public GamingUAViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gaming_ua_list_item, parent, false);
        return new GamingUAViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(GamingUAViewHolder holder, int position) {
        String adTitle = adDataList.get(position).getTitle();
        holder.adTitle.setText(adTitle);
    }

    @Override
    public int getItemCount() {
        return adDataList.size();
    }

}
