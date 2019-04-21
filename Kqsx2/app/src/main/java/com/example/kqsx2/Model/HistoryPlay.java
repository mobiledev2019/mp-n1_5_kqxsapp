package com.example.kqsx2.Model;

public class HistoryPlay {
    private String point;
    private String type;
    private String time;

    public HistoryPlay(String point, String type, String time) {
        this.point = point;
        this.type = type;
        this.time = time;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
