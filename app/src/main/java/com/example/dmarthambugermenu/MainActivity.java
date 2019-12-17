package com.example.dmarthambugermenu;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dmarthambugermenu.adapter.MenuRVAdapter;
import com.example.dmarthambugermenu.model.EligibleStories;
import com.example.dmarthambugermenu.model.ListCells;
import com.example.dmarthambugermenu.model.MenuDynamicsObject;
import com.example.dmarthambugermenu.model.Widget;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String name = "Ramesh";
    TextView txtHeader, txtDescriptiveHeader;
    ImageView ivleftImage, ivRightImage;
    boolean flag = true;
    MenuDynamicsObject menuDynamicsObject;
    TextView txtPersonalizedText, txtPersonalizedSubHeader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout llmenuLayout = findViewById(R.id.ll_activity_main_menullayout);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.tb_activity_main_toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        menuDynamicsObject = menuObject();

        if (menuDynamicsObject != null)

            if (menuDynamicsObject.getHamburgerMenu() != null)
                if (menuDynamicsObject.getHamburgerMenu().getData() != null) {
                    List<Widget> menuWidgets;
                    menuWidgets = menuDynamicsObject.getHamburgerMenu().getData().getWidgets();
                    if (AppUtil.nullArrayListCheck(menuWidgets))
                        for (int k = 0; k < menuWidgets.size(); k++) {
                            Log.d("loop check main", "onCreate: " + menuDynamicsObject.getHamburgerMenu().getData().getWidgets().size());

                            if (menuDynamicsObject.getHamburgerMenu().getData().getWidgets().get(k).getContext() != null)
                                if (AppUtil.nullAndEmptyCheck(menuDynamicsObject.getHamburgerMenu().getData().getWidgets().get(k).getContext().getTemplate())) {
                                    switch (menuDynamicsObject.getHamburgerMenu().getData().getWidgets().get(k).getContext()
                                            .getTemplate()) {

                                        case "GreetingAndPincodeWidget":
                                            View menuHeaderView = getLayoutInflater().inflate(R.layout.view_menuheader, null);
                                            ivleftImage = menuHeaderView.findViewById(R.id.iv_view_menuheader_left_image);
                                            ivRightImage = menuHeaderView.findViewById(R.id.iv_view_menuheader_right_image);
                                            txtHeader = menuHeaderView.findViewById(R.id.txt_view_menuheader_header);
                                            txtDescriptiveHeader = menuHeaderView.findViewById(R.id.txt_view_menuheader_descriptive_text);
                                            Object greetingAndPincodeWidgetData = menuDynamicsObject.getHamburgerMenu().getData().getWidgets().get(k).getData();
                                            if (AppUtil.nullArrayListCheck(menuWidgets))
                                                if (greetingAndPincodeWidgetData != null) {
                                                    String jsonDespcriptiveText = menuDynamicsObject.getHamburgerMenu().getData().getWidgets().get(k).getData().getDescriptonText();
                                                    String jsonUsername = menuWidgets.get(k).getData().getHeaderText();
                                                    String leftUrl = menuWidgets.get(k).getData().getLeftImagePath();
                                                    String rightUrl = menuWidgets.get(k).getData().getRightImagePath();
                                                    Log.d("righturltest", rightUrl);

                                                    if (AppUtil.nullAndEmptyCheck(jsonUsername)) {
                                                        if (jsonUsername.contains("#USERNAME"))
                                                            txtHeader.setText(jsonUsername.replace("#USERNAME", name));
                                                        else
                                                            txtHeader.setText(jsonUsername);

                                                        if (AppUtil.colorCheck(menuWidgets.get(k).getData().getHeaderFontColor()))
                                                            txtHeader.setTextColor(Color.parseColor(menuWidgets.get(k).getData().getHeaderFontColor()));
                                                    }


                                                    if (AppUtil.nullAndEmptyCheck(jsonDespcriptiveText)) {
                                                        if (jsonDespcriptiveText.contains("#USERPINCODE"))
                                                            txtDescriptiveHeader.setText(jsonDespcriptiveText.replace("#USERPINCODE", menuWidgets.get(k).getData().getPincode()));
                                                        else
                                                            txtDescriptiveHeader.setText(jsonDespcriptiveText.replace("#USERPINCODE", menuWidgets.get(k).getData().getPincode()));

                                                        if (AppUtil.colorCheck((menuWidgets.get(k).getData().getDescriptionFontColor())))
                                                            txtDescriptiveHeader.setTextColor(Color.parseColor(menuWidgets.get(k).getData().getDescriptionFontColor()));
                                                    }


                                                    Picasso.Builder leftImageBuilder = new Picasso.Builder(this);
                                                    leftImageBuilder.listener(new Picasso.Listener() {
                                                        @Override
                                                        public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                                                            ivleftImage.setVisibility(View.GONE);

                                                        }
                                                    });

                                                    if (AppUtil.nullAndEmptyCheck(leftUrl)) {

                                                        leftImageBuilder.build().load(leftUrl).into(ivleftImage);
                                                        Log.d("bbbbbbbbbbbbbbbbb", "onCreate: " + leftUrl);
                                                    } else {
                                                        ivleftImage.setVisibility(View.GONE);


                                                    }

                                                    Picasso.Builder rightImageBuilder = new Picasso.Builder(this);
                                                    rightImageBuilder.listener(new Picasso.Listener() {
                                                        @Override
                                                        public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                                                            ivRightImage.setVisibility(View.GONE);
                                                        }
                                                    });

                                                    if (AppUtil.nullAndEmptyCheck(rightUrl))
                                                        rightImageBuilder.build().load(rightUrl).into(ivRightImage);
                                                } else
                                                    ivRightImage.setVisibility(View.GONE);
                                            llmenuLayout.addView(menuHeaderView);
                                            break;


                                        case ("PersonalizedMessageWidget"):
                                            int personalizedWidgetArraySize = 0;
                                            Object personalizedMessageWidgetData = menuWidgets.get(k).getData();
                                            if (personalizedMessageWidgetData != null) {
                                                if (AppUtil.nullArrayListCheck(menuWidgets.get(k).getData().getEligibleStories()))
                                                    personalizedWidgetArraySize = menuWidgets.get(k).getData().getEligibleStories().size();
                                                List<EligibleStories> eligibleStories ;
                                                eligibleStories = menuWidgets.get(k).getData().getEligibleStories();
                                                for (int i = 0; i < personalizedWidgetArraySize; i++) {
                                                    View subHeaderView = getLayoutInflater().inflate(R.layout.view_submenuheader, null);
                                                    Log.d("loop check", "onCreate: " + subHeaderView);
                                                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                                                    layoutParams.setMargins(0, 30, 0, 30);
                                                    if (AppUtil.colorCheck(menuWidgets.get(k).getContext().getBgColor())) {
                                                        subHeaderView.setBackgroundColor(Color.parseColor(menuWidgets.get(k).getContext().getBgColor()));
                                                        subHeaderView.setBackground(getResources().getDrawable(R.drawable.subheaderbackground));

                                                    }
                                                    if (AppUtil.nullArrayListCheck(eligibleStories)) {
                                                        txtPersonalizedSubHeader = subHeaderView.findViewById(R.id.txt_submenuheader_subtitle_text);
                                                        txtPersonalizedText = subHeaderView.findViewById(R.id.txt_submenuheader_title_text);
                                                        String personalizedWidgetArrayHeader = eligibleStories.get(i).getTitleText();
                                                        String personalizedOrderId = eligibleStories.get(i).getOrderId();
                                                        String pesonalizedSubHeader = eligibleStories.get(i).getSubText();
                                                        if (AppUtil.nullAndEmptyCheck(personalizedWidgetArrayHeader)) {

                                                            if (personalizedWidgetArrayHeader.contains("#ORDERID"))
                                                                txtPersonalizedText.setText(personalizedWidgetArrayHeader.replace("#ORDERID", personalizedOrderId));
                                                            else
                                                                txtPersonalizedText.setText(personalizedWidgetArrayHeader);

                                                            if (AppUtil.colorCheck(eligibleStories.get(i).getTitleFontColor()))
                                                                txtPersonalizedText.setTextColor(Color.parseColor(eligibleStories.get(i).getTitleFontColor()));

                                                        } else {
                                                            txtPersonalizedText.setVisibility(View.GONE);

                                                        }

                                                        if (AppUtil.nullAndEmptyCheck(pesonalizedSubHeader)) {
                                                            if (pesonalizedSubHeader.contains("#ORDERID") && AppUtil.nullAndEmptyCheck(personalizedOrderId))
                                                                txtPersonalizedSubHeader.setText(pesonalizedSubHeader.replace("#ORDERID", personalizedOrderId));
                                                            else
                                                                txtPersonalizedSubHeader.setText(pesonalizedSubHeader);
                                                        } else
                                                            txtPersonalizedSubHeader.setVisibility(View.GONE);

                                                        llmenuLayout.addView(subHeaderView,layoutParams);
                                                    }
                                                }
                                            }

                                            break;


                                        case "DynamicListWidget":

                                            View menurecyclerview = getLayoutInflater().inflate(R.layout.menu_list_cells, null);
                                            RecyclerView rvMenuListItems = menurecyclerview.findViewById(R.id.rv_menu_list_cells);
                                            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                                            rvMenuListItems.setLayoutManager(layoutManager);
                                            Object dyanmicWidgetData = menuWidgets.get(k).getData();
                                            if (dyanmicWidgetData != null) {
                                                List<ListCells> menuListCells;
                                                menuListCells = menuWidgets.get(k).getData().getListCells();
                                                if ((menuWidgets.get(k).getContext().getType().equals("dynamic")) || menuWidgets.get(k).getContext().getType().equals("static")) {
                                                    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvMenuListItems.getContext(), ((LinearLayoutManager) layoutManager).getOrientation());
                                                    rvMenuListItems.addItemDecoration(dividerItemDecoration);
                                                }
                                                Log.d("listcheck", "onCreate: " + menuListCells);
                                                if (AppUtil.nullArrayListCheck(menuListCells)) {
                                                    MenuRVAdapter rvAdapter = new MenuRVAdapter(menuListCells, this, menuWidgets.get(k).getContext());
                                                    rvMenuListItems.setAdapter(rvAdapter);
                                                }
                                                if (AppUtil.colorCheck(menuWidgets.get(k).getContext().getDividerColor()))
                                                    rvMenuListItems.setBackgroundColor(Color.parseColor(menuWidgets.get(k).getContext().getDividerColor()));
                                                rvMenuListItems.setNestedScrollingEnabled(false);
                                                llmenuLayout.addView(menurecyclerview);
                                                break;
                                            }
                                    }
                                }
                        }
                }
    }

    public MenuDynamicsObject menuObject() {
        String json = "";
        try {
            InputStream is = getAssets().open("DmartHambugerJson.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            if (AppUtil.nullAndEmptyCheck(json))
                return null;
        }
        Gson gson = new Gson();
        menuDynamicsObject = gson.fromJson(json, MenuDynamicsObject.class);
        return menuDynamicsObject;

    }
}


