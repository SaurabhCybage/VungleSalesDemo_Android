package com.vungle.demo.ui.adapters;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.vungle.demo.R;
import com.vungle.demo.models.ad_data.AdData;

import java.util.List;

/**
 * Created by saurabhgupt on 2/1/2017.
 */
public class AdAdapter extends RecyclerView.Adapter<AdAdapter.GamingUAViewHolder> {

    FragmentActivity activityContext;
    List<AdData> adDataList;
    private DisplayImageOptions displayOptions;

    public AdAdapter(FragmentActivity activityContext, List<AdData> adDataList) {
        this.activityContext = activityContext;
        this.adDataList = adDataList;
        setImageLoaderDisplayOption();
    }


    public class GamingUAViewHolder extends RecyclerView.ViewHolder {
        public TextView adTitle;
        public ImageView adImage;

        public GamingUAViewHolder(View view) {
            super(view);
            adTitle = (TextView) view.findViewById(R.id.textViewAdTitle);
            adImage = (ImageView) view.findViewById(R.id.imageViewAd);
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
        AdData adData = adDataList.get(position);
        String adTitle = adData.getTitle();
        holder.adTitle.setText(adTitle);
        holder.adImage.setVisibility(View.VISIBLE);
        ImageLoader.getInstance().displayImage(adData.getAdImageUrl(), holder.adImage, displayOptions);

    }

    @Override
    public int getItemCount() {
        return adDataList.size();
    }


    private void setImageLoaderDisplayOption() {
        displayOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();

    }

}
