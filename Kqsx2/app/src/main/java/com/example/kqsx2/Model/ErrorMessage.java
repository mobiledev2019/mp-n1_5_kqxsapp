package com.example.kqsx2.Model;

import com.google.gson.annotations.SerializedName;

public class ErrorMessage {
    @SerializedName("type")
    private String type;
    @SerializedName("title")
    private String title = " Error Unknown";
    @SerializedName("status")
    private int status ;

    public ErrorMessage(String type, String title, int status) {
        this.type = type;
        this.title = title;
        this.status = status;
    }

    public ErrorMessage() {
    }

    public ErrorMessage(int status,String title) {
        this.title = title;
        this.status = status;
    }

    public ErrorMessage(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
