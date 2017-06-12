package com.example.anley.homework7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Anley on 2017/6/13.
 */

public class HotelArrayAdapter extends ArrayAdapter<Hotel> {
    Context context;
    public HotelArrayAdapter(Context context, List<Hotel> items) {
            super(context, 0, items);
            this.context = context;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        LinearLayout itemlayout = null;

        if (convertView == null) {
            itemlayout = (LinearLayout) inflater.inflate(R.layout.hotel_item, null);
        }
        else {
            itemlayout = (LinearLayout) convertView;
        }
        Hotel item = (Hotel) getItem(position);
        TextView tvName = (TextView) itemlayout.findViewById(R.id.h_name);
        tvName.setText(item.getName());
        TextView tvTel = (TextView) itemlayout.findViewById(R.id.h_tel);
        tvTel.setText(item.getTel());
        ImageView ivPet = (ImageView) itemlayout.findViewById(R.id.h_img);
        ivPet.setImageBitmap(item.getImgUrl());

        return itemlayout;
    }



}
