package com.example.carlistapp;

import java.io.Serializable;

public class PersonObject implements Serializable {

    private String auto, color, url;


    public PersonObject() {
    }

    public PersonObject(String auto, String color, String url) {
        // always set your constructor!!!!
        this.auto = auto;
        this.color = color;
        this.url = url;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImageUrl() {
        return url;
    }

    public void setImageurl(String imageurl) {
        this.url = imageurl;
    }

    }

