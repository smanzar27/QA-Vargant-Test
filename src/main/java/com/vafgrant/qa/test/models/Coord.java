package com.vafgrant.qa.test.models;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Coord {

    protected double lon;
    protected double lat;

    public double getLon() { return lon; }
    public double getLat() { return lat; }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("lon", lon)
                .append("lat", lat)
                .toString();
    }
}
