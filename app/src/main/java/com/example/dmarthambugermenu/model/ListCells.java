package com.example.dmarthambugermenu.model;

import com.google.gson.annotations.Expose;

public class ListCells {
    @Expose
    private String displayText;
    @Expose
    private String leftImagePath;
    @Expose
    private String rightImagePath;

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
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


}
