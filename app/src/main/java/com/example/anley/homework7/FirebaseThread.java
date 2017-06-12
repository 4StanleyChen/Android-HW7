package com.example.anley.homework7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;

import com.google.firebase.database.DataSnapshot;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anley on 2017/6/13.
 */

public class FirebaseThread extends Thread{
    private DataSnapshot dataSnapshot;
    private HotelArrayAdapter adapter = null;
    private static final int LIST_HOTELS = 1;

    public FirebaseThread(DataSnapshot dataSnapshot) {
        this.dataSnapshot = dataSnapshot;
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case LIST_HOTELS: {
                    List<Hotel> hotels = (List<Hotel>)msg.obj;
                    refreshPetList(hotels);
                    break;
                }
            }
        }
    };

    private void refreshPetList(List<Hotel> hotels) {
        adapter.clear();
        adapter.addAll(hotels);
    }

    public void run(){
        List<Hotel> lsHotels = new ArrayList<>();
        for (DataSnapshot ds : dataSnapshot.getChildren()){
            DataSnapshot dsName = ds.child("Name");
            DataSnapshot dsTel = ds.child("Tel");
            String name = (String)dsName.getValue();
            String tel = (String)dsTel.getValue();

            DataSnapshot dsImg = ds.child("Picture1");
            String imgUrl = (String) dsImg.getValue();
            Bitmap petImg = getImgBitmap(imgUrl);

            Hotel aHotel = new Hotel();
            aHotel.setName(name);
            aHotel.setTel(tel);
            aHotel.setImgUrl(petImg);
            lsHotels.add(aHotel);

            Message msg = new Message();
            msg.what = LIST_HOTELS;
            msg.obj = lsHotels;
            handler.sendMessage(msg);
        }
    }

    private Bitmap getImgBitmap(String imgUrl){
        try {
            URL url = new URL(imgUrl); Bitmap bm = BitmapFactory.decodeStream(
                url.openConnection() .getInputStream()); return bm;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
