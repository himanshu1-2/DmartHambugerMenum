package com.example.dmarthambugermenu.model ;

import com.google.gson.annotations.Expose;

public class  EligibleStories {

    @Expose
    private String titleText;
    @Expose
    private boolean isEligible;
    @Expose
    private String orderId;
    @Expose
    private String subText;
    @Expose
    private String bottomText;
    @Expose
    private String actionUrl;
    @Expose
    private String titleFontColor;

    @Expose
    private String subTextFontColor;


    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public boolean isEligible() {
        return isEligible;
    }

    public void setEligible(boolean eligible) {
        isEligible = eligible;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSubText() {
        return subText;
    }

    public void setSubText(String subText) {
        this.subText = subText;
    }

    public String getBottomText() {
        return bottomText;
    }

    public void setBottomText(String bottomText) {
        this.bottomText = bottomText;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public String getTitleFontColor() {
        return titleFontColor;
    }

    public void setTitleFontColor(String titleFontColor) {
        this.titleFontColor = titleFontColor;
    }

    public String getSubTextFontColor() {
        return subTextFontColor;
    }

    public void setSubTextFontColor(String subTextFontColor) {
        this.subTextFontColor = subTextFontColor;
    }
}
