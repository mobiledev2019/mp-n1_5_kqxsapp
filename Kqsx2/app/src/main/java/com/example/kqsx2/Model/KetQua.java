package com.example.kqsx2.Model;

import java.util.ArrayList;
import java.util.List;

public class KetQua {
    private String giai;
    private List<String> stringList = new ArrayList<>();
    private int numGiai;

    public KetQua() {
    }

    public KetQua(String giai, List<String> stringList, int numGiai) {
        this.giai = giai;
        this.stringList = stringList;
        this.numGiai = numGiai;
    }

    public String getGiai() {
        return giai;
    }

    public void setGiai(String giai) {
        this.giai = giai;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public int getNumGiai() {
        return numGiai;
    }

    public void setNumGiai(int numGiai) {
        this.numGiai = numGiai;
    }
}