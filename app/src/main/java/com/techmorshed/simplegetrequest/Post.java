package com.techmorshed.simplegetrequest;

import com.google.gson.annotations.SerializedName;

public class Post {

    private int userId;

    private int id;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("body")
    private String mBody;


    public Post(int userId, String mTitle, String mBody) {
        this.userId = userId;
        this.mTitle = mTitle;
        this.mBody = mBody;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmBody() {
        return mBody;
    }

    public void setmBody(String mBody) {
        this.mBody = mBody;
    }
}
