
package com.example.dmarthambugermenu.model;


import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Context {

    @Expose
    private String bgColor;
    @Expose
    private String bottomCurve;
    @Expose
    private String bottomShadow;
    @Expose
    private String channelType;
    @Expose
    private String description;
    @Expose
    private String masterLayoutId;
    @Expose
    private String template;
    @Expose
    private String topCurve;
    @Expose
    private String topMargin;
    @Expose
    private String topShadow;
    @Expose
    private String url;

    @Expose
    private String type;

    @Expose
    private String dividerColor;


    public String getFontColor() {
        return fontColor;
    }

    public String getDividerColor() {
        return dividerColor;
    }
    @Expose
    private String fontColor;


    public String getType() {
        return type;
    }


    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getBottomCurve() {
        return bottomCurve;
    }

    public void setBottomCurve(String bottomCurve) {
        this.bottomCurve = bottomCurve;
    }

    public String getBottomShadow() {
        return bottomShadow;
    }

    public void setBottomShadow(String bottomShadow) {
        this.bottomShadow = bottomShadow;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMasterLayoutId() {
        return masterLayoutId;
    }

    public void setMasterLayoutId(String masterLayoutId) {
        this.masterLayoutId = masterLayoutId;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTopCurve() {
        return topCurve;
    }

    public void setTopCurve(String topCurve) {
        this.topCurve = topCurve;
    }

    public String getTopMargin() {
        return topMargin;
    }

    public void setTopMargin(String topMargin) {
        this.topMargin = topMargin;
    }

    public String getTopShadow() {
        return topShadow;
    }

    public void setTopShadow(String topShadow) {
        this.topShadow = topShadow;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
