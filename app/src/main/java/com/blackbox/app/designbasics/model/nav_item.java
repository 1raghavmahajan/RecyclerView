package com.blackbox.app.designbasics.model;

import android.widget.ImageView;

import com.blackbox.app.designbasics.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raghav on 30-May-17.
 */

public class nav_item {

    int img_id;
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public static List<nav_item> getData(){
        List<nav_item> list = new ArrayList<>();

        int[] imageIDs = getImages();
        String[] titles = getTitles();

        for (int i = 0; i < titles.length; i++) {
            nav_item navItem = new nav_item();
            navItem.setTitle(titles[i]);
            navItem.setImg_id(imageIDs[i]);
            list.add(navItem);
        }

        return list;
    }

    private static int[] getImages() {

        return new int[]{
                R.drawable.ic_birds, R.drawable.ic_animal,
                R.drawable.ic_forest, R.drawable.ic_ocean,
                R.drawable.ic_planet, R.drawable.ic_landscape};
    }

    private static String[] getTitles() {

        return new String[] {
                "Birds", "Animals", "Forest", "Ocean", "Planets", "Landscape"
        };
    }

}
