package com.amohnacs.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

/**
 * Created by adrianmohnacs on 3/22/18.
 */

public class Profile {

    @SerializedName("badge_counts")
    BadgeCount badgeCount;

    @SerializedName("account_id")
    int accountId;
    @SerializedName("is_employee")
    boolean isEmployee;
    @SerializedName("last_modified_date")
    long lastModifiedDate; //may_be_absent
    @SerializedName("last_access_date")
    long lastAccessDate;
    @SerializedName("age")
    int age; //may_be_absent

    @SerializedName("reputation_change_year")
    int reputationChangeYear; //x
    @SerializedName("reputation_change_quarter")
    int reputationChangeQuarter; //
    @SerializedName("reputation_change_month")
    int reputationChangeMonth;; //
    @SerializedName("reputation_change_day")
    int reputationChangeDay;; //
    @SerializedName("reputation")
    int reputation;

    @SerializedName("creation_date")
    long creationDate; //
    @SerializedName("user_type")
    String user_type; //
    @SerializedName("accept_rate")
    int acceptRate; // //may_be_absent
    @SerializedName("location")
    String location; ////may_be_absent
    @SerializedName("website_url")
    String websiteUrl; ////may_be_absent
    @SerializedName("link")
    String link;
    @SerializedName("profile_image")
    String profileImage; ////may_be_absent
    @SerializedName("display_name")
    String displayName; ////may_be_absent

    //todo builder pattern


    public Profile(JSONObject object) {
        setFields(object);
    }

    public void setFields(JSONObject fields) {
    }

    public BadgeCount getBadgeCount() {
        return badgeCount;
    }

    public void setBadgeCount(BadgeCount badgeCount) {
        this.badgeCount = badgeCount;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    @Nullable
    public long getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(long lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public long getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(long lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getReputationChangeYear() {
        return reputationChangeYear;
    }

    public void setReputationChangeYear(int reputationChangeYear) {
        this.reputationChangeYear = reputationChangeYear;
    }

    public int getReputationChangeQuarter() {
        return reputationChangeQuarter;
    }

    public void setReputationChangeQuarter(int reputationChangeQuarter) {
        this.reputationChangeQuarter = reputationChangeQuarter;
    }

    public int getReputationChangeMonth() {
        return reputationChangeMonth;
    }

    public void setReputationChangeMonth(int reputationChangeMonth) {
        this.reputationChangeMonth = reputationChangeMonth;
    }

    public int getReputationChangeDay() {
        return reputationChangeDay;
    }

    public void setReputationChangeDay(int reputationChangeDay) {
        this.reputationChangeDay = reputationChangeDay;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    @Nullable
    public int getAcceptRate() {
        return acceptRate;
    }

    public void setAcceptRate(int acceptRate) {
        this.acceptRate = acceptRate;
    }

    @Nullable
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Nullable
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Nullable
    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Nullable
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
