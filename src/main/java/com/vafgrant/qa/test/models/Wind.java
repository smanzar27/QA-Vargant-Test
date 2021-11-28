package com.vafgrant.qa.test.models;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Wind {

    protected double speed;
    protected double gust;
    protected int deg;

    public double getSpeed() { return speed; }
    public int getDeg() { return deg; }
    public double getGust() {return gust;}

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("speed", speed)
                .append("gust", gust)
                .append("deg", deg)
                .toString();
    }



}
