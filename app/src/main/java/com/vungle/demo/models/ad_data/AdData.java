package com.vungle.demo.models.ad_data;

/**
 * Created by saurabhgupt on 1/30/2017.
 */
public final class AdData {

    private String adId;
    private String title;
    private String description;
    private String adImageUrl;
    private String videoUrl;
    private String webpageZipFileUrl;
    private String adImageAligement;
    private String parentCategorty;
    private String subCategory;


    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdImageUrl() {
        return adImageUrl;
    }

    public void setAdImageUrl(String adImageUrl) {
        this.adImageUrl = adImageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getWebpageZipFileUrl() {
        return webpageZipFileUrl;
    }

    public void setWebpageZipFileUrl(String webpageZipFileUrl) {
        this.webpageZipFileUrl = webpageZipFileUrl;
    }

    public String getAdImageAligement() {
        return adImageAligement;
    }

    public void setAdImageAligement(String adImageAligement) {
        this.adImageAligement = adImageAligement;
    }

    public String getParentCategorty() {
        return parentCategorty;
    }

    public void setParentCategorty(String parentCategorty) {
        this.parentCategorty = parentCategorty;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public String toString() {
        return "AdData{" +
                "adId='" + adId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", adImageUrl='" + adImageUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", webpageZipFileUrl='" + webpageZipFileUrl + '\'' +
                ", adImageAligement='" + adImageAligement + '\'' +
                ", parentCategorty='" + parentCategorty + '\'' +
                ", subCategory='" + subCategory + '\'' +
                '}';
    }
}
