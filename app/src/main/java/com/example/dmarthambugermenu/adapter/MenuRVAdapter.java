package com.example.dmarthambugermenu.adapter;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dmarthambugermenu.AppUtil;
import com.example.dmarthambugermenu.R;
import com.example.dmarthambugermenu.model.ListCells;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MenuRVAdapter extends RecyclerView.Adapter<MenuRVAdapter.DynamicWidgetViewHolder> {

    com.example.dmarthambugermenu.model.Context contextCategory;

    List<ListCells> userList;
    Context context;

    public MenuRVAdapter(List userList, Context context, com.example.dmarthambugermenu.model.Context contextCategory) {
        this.context = context;
        this.userList = userList;
        this.contextCategory = contextCategory;
    }


    @NonNull
    @Override
    public DynamicWidgetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = null;
        if (contextCategory.getType().equals("category")) {
            view = LayoutInflater.from(context).inflate(R.layout.listitem_category, viewGroup, false);
            if (AppUtil.nullAndEmptyCheck(contextCategory.getTopShadow()))
                if (contextCategory.getTopShadow().equals("true"))
                {    view.setElevation(16);

                }

        } else if (contextCategory.getType().equals("dynamic")) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_dyamic, viewGroup, false);
        } else if (contextCategory.getType().equals("static")) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_static, viewGroup, false);
        }
        return new DynamicWidgetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DynamicWidgetViewHolder dynamicWidgetViewHolder, int i) {


        if (contextCategory.getType().equals("category")) {
            if (AppUtil.nullAndEmptyCheck(userList.get(i).getDisplayText()))
                dynamicWidgetViewHolder.txtCategoryText.setText(userList.get(i).getDisplayText());

            if (AppUtil.colorCheck(contextCategory.getBgColor())) {
                dynamicWidgetViewHolder.llCategory.setBackgroundColor(Color.parseColor(contextCategory.getBgColor()));
            }
            if (AppUtil.colorCheck(contextCategory.getFontColor())) {
                dynamicWidgetViewHolder.txtCategoryText.setTextColor(Color.parseColor(contextCategory.getFontColor()));
            }

            imageCheck(dynamicWidgetViewHolder.ivRightArrow, dynamicWidgetViewHolder.ivCategoryLeft, i);

        } else if (contextCategory.getType().equals("dynamic")) {

            if (AppUtil.nullAndEmptyCheck(userList.get(i).getDisplayText()))
                dynamicWidgetViewHolder.txtDyamicText.setText(userList.get(i).getDisplayText());
            if (AppUtil.colorCheck(contextCategory.getBgColor()))
                dynamicWidgetViewHolder.llDynamic.setBackgroundColor(Color.parseColor(contextCategory.getBgColor()));
            if (AppUtil.colorCheck(contextCategory.getFontColor()))
                dynamicWidgetViewHolder.txtDyamicText.setTextColor(Color.parseColor(contextCategory.getFontColor()));
            imageCheck(dynamicWidgetViewHolder.ivDyamicRight, dynamicWidgetViewHolder.ivDyanicLeft, i);

        } else if (contextCategory.getType().equals("static")) {
            if (AppUtil.nullAndEmptyCheck(userList.get(i).getDisplayText()))
                dynamicWidgetViewHolder.txtStaticText.setText(userList.get(i).getDisplayText());
            if (AppUtil.colorCheck(contextCategory.getFontColor()))
                dynamicWidgetViewHolder.txtStaticText.setTextColor(Color.parseColor(contextCategory.getFontColor()));
            if (AppUtil.colorCheck(contextCategory.getBgColor()))
                dynamicWidgetViewHolder.llStatic.setBackgroundColor(Color.parseColor(contextCategory.getBgColor()));
            imageCheck(dynamicWidgetViewHolder.ivStaticImageRight, dynamicWidgetViewHolder.ivStaticImageLeft, i);

        }


    }

    @Override
    public int getItemCount() {

        return userList.size();

    }

    public static class DynamicWidgetViewHolder extends RecyclerView.ViewHolder {
        TextView txtCategoryText;
        LinearLayout llDynamic;
         LinearLayout    llStatic;
        RelativeLayout llCategory;
        TextView txtDyamicText, txtStaticText;
        ImageView ivStaticImageRight, ivRightArrow, ivStaticImageLeft, ivCategoryLeft, ivDyanicLeft, ivDyamicRight;


        public DynamicWidgetViewHolder(@NonNull View itemView) {
            super(itemView);
            ivDyanicLeft = itemView.findViewById(R.id.iv_menu_list_item_dyanamic_imageleft);
            ivDyamicRight = itemView.findViewById(R.id.iv_menu_list_item_dyanamic_imageright);
            llDynamic = itemView.findViewById(R.id.ll_list_item_dynamic_list);
            txtCategoryText = itemView.findViewById(R.id.txt_list_item_category_text);
            llCategory = itemView.findViewById(R.id.ll_listitem_category);
            txtDyamicText = itemView.findViewById(R.id.txt_list_item_dyanamic_text);
            txtStaticText = itemView.findViewById(R.id.txt_menu_list_item_text);
            llStatic = itemView.findViewById(R.id.ll_list_item_static_list);
            ivStaticImageRight = itemView.findViewById(R.id.iv_list_item_static_imageright);
            ivRightArrow = itemView.findViewById(R.id.iv_list_item_category_arrow);
            ivStaticImageLeft = itemView.findViewById(R.id.iv_menu_list_item_left_image);
            ivCategoryLeft = itemView.findViewById(R.id.iv_list_item_category_arrow_left);


        }


    }

    public void imageCheck(final ImageView leftImage, final ImageView rightImage, int position) {
        Picasso.Builder rightImageBuilder = new Picasso.Builder(context);
        rightImageBuilder.listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                leftImage.setVisibility(View.GONE);

            }
        });
        if (AppUtil.nullAndEmptyCheck(userList.get(position).getRightImagePath())) {
            rightImageBuilder.build().load(userList.get(position).getRightImagePath()).into(leftImage);

        }


        Picasso.Builder leftImageBuilder = new Picasso.Builder(context);
        leftImageBuilder.listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                rightImage.setVisibility(View.GONE);
            }
        });
        if (AppUtil.nullAndEmptyCheck(userList.get(position).getLeftImagePath())) {
            leftImageBuilder.build().load(userList.get(position).getLeftImagePath()).into(rightImage);

        }

    }
}
