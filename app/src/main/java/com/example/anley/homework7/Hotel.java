package com.example.anley.homework7;

import android.graphics.Bitmap;

/**
 * Created by Anley on 2017/6/13.
 */

public class Hotel {
    private String Name;
    private String Tel;
    private Bitmap imgUrl;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public Bitmap getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(Bitmap imgUri) {
        this.imgUrl = imgUri;
    }
}
