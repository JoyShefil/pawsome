package com.example.pawsome;

import com.google.gson.JsonObject;

public class ModelClass {

    private JsonObject image;

    private String id;

    private String name;

    private String temperament;

    private String life_span;

    private String alt_names;

    private String wikipedia_url;

    private String origin;

    private JsonObject weight;

    private String country_code;

    private JsonObject height;

    JsonObject getImage(){
        return image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTemperament() {
        return temperament;
    }

    public String getLife_span() {
        return life_span;
    }

    public String getAlt_names() {
        return alt_names;
    }

    public String getWikipedia_url() {
        return wikipedia_url;
    }

    public String getOrigin() {
        return origin;
    }

    public JsonObject getWeight() {
        return weight;
    }

    public String getCountry_code() {
        return country_code;
    }

    public JsonObject getHeight() {
        return height;
    }
}
