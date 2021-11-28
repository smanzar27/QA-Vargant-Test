package com.vafgrant.qa.test.models;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Sys {

    protected int type;
    protected int id;
    protected double message;
    protected String country;
    protected int sunrise;
    protected int sunset;

    public int getType() { return type; }
    public int getId() { return id; }
    public double getMessage() { return message; }
    public String getCountry() { return country; }
    public int getSunrise() { return sunrise; }
    public int getSunset() { return sunset; }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .append("id", id)
                .append("message", message)
                .append("country", country)
                .append("sunrise", sunrise)
                .append("sunset", sunset)
                .toString();
    }
}
