
package com.example.dmarthambugermenu.model;

import com.google.gson.annotations.Expose;



public class HamburgerMenu {

    @Expose
    private Context context;
    @Expose
    private Data data;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
