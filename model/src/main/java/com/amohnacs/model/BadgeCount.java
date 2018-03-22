package com.amohnacs.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by adrianmohnacs on 3/22/18.
 */

public class BadgeCount { //badge_count

    @SerializedName("bronze")
    int bronze;
    @SerializedName("silver")
    int silver;
    @SerializedName("gold")
    int gold;

    public BadgeCount() {
    }

    public int getBronze() {
        return bronze;
    }

    public void setBronze(int bronze) {
        this.bronze = bronze;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
