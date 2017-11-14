package com.example.biz_41.Model;

import com.example.biz_41.R;

/**
 * Created by Karl on 16.05.2017.
 */

public class Category {
    private  String name;
    private String id;
    private boolean isClicked;
    private int background;

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public String getId() {
        return id;
    }

    public Category(String id, String name) {
        this.name = name;
        this.id = id;
        this.isClicked = false;
        this.background = R.drawable.shape_category;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
