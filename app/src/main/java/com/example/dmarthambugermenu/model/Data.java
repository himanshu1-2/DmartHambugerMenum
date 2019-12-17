
package com.example.dmarthambugermenu.model;

import java.util.List;

import com.google.gson.annotations.Expose;



public class Data {

    @Expose
    private String actionUrl;
    @Expose
    private String descriptionFontColor;
    @Expose
    private String descriptonText;
    @Expose
    private String headerFontColor;
    @Expose
    private String headerText;
    @Expose
    private String leftImagePath;
    @Expose
    private String rightImagePath;
    @Expose
    private List<Widget> widgets;

    @Expose
    private String pincode;




    private List<EligibleStories> eligibleStories;

    private List<ListCells>listCells;

    public List<EligibleStories> getEligibleStories() {
        return eligibleStories;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public String getDescriptionFontColor() {
        return descriptionFontColor;
    }

    public void setDescriptionFontColor(String descriptionFontColor) {
        this.descriptionFontColor = descriptionFontColor;
    }

    public String getDescriptonText() {
        return descriptonText;
    }

    public void setDescriptonText(String descriptonText) {
        this.descriptonText = descriptonText;
    }

    public String getHeaderFontColor() {
        return headerFontColor;
    }

    public void setHeaderFontColor(String headerFontColor) {
        this.headerFontColor = headerFontColor;
    }

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public String getLeftImagePath() {
        return leftImagePath;
    }

    public void setLeftImagePath(String leftImagePath) {
        this.leftImagePath = leftImagePath;
    }

    public String getRightImagePath() {
        return rightImagePath;
    }

    public void setRightImagePath(String rightImagePath) {
        this.rightImagePath = rightImagePath;
    }

    public List<Widget> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<Widget> widgets) {
        this.widgets = widgets;
    }

    public String getPincode() {
        return pincode;
    }

    public List<ListCells> getListCells() {
        return listCells;
    }
}
