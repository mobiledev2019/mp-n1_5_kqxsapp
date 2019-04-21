package com.example.kqsx2.Model;

import java.util.List;

public class ResultB {
    private Long id;

    private List<String> first;

    private List<String> second;

    private List<String> third;

    private List<String> fourth;

    private List<String> fifth;

    private List<String> sixth;

    private List<String> seventh;

    private List<String> special;

    private String create_date;

    private Long regional;

    public ResultB() {
        super();
    }

    public ResultB(List<String> second, List<String> third, List<String> fourth, List<String> fifth,
                           List<String> sixth, List<String> seventh) {
        super();
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.seventh = seventh;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getFirst() {
        return first;
    }

    public void setFirst(List<String> first) {
        this.first = first;
    }

    public List<String> getSecond() {
        return second;
    }

    public void setSecond(List<String> second) {
        this.second = second;
    }

    public List<String> getThird() {
        return third;
    }

    public void setThird(List<String> third) {
        this.third = third;
    }

    public List<String> getFourth() {
        return fourth;
    }

    public void setFourth(List<String> fourth) {
        this.fourth = fourth;
    }

    public List<String> getFifth() {
        return fifth;
    }

    public void setFifth(List<String> fifth) {
        this.fifth = fifth;
    }

    public List<String> getSixth() {
        return sixth;
    }

    public void setSixth(List<String> sixth) {
        this.sixth = sixth;
    }

    public List<String> getSeventh() {
        return seventh;
    }

    public void setSeventh(List<String> seventh) {
        this.seventh = seventh;
    }

    public List<String> getSpecial() {
        return special;
    }

    public void setSpecial(List<String> special) {
        this.special = special;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public Long getRegional() {
        return regional;
    }

    public void setRegional(Long regional) {
        this.regional = regional;
    }
}
