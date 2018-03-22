package com.amohnacs.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by adrianmohnacs on 3/22/18.
 */

public class ProfileItems {

    @SerializedName("items")
    List<Profile> items;

    public ProfileItems() {
    }

    public ProfileItems(List<Profile> items) {
        this.items = items;
    }

    public List<Profile> getItems() {
        return items;
    }

    public void setItems(List<Profile> items) {
        this.items = items;
    }
}
