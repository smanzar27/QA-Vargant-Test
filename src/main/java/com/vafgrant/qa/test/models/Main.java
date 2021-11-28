package com.vafgrant.qa.test.models;

import org.apache.commons.lang.builder.ToStringBuilder;
import  com.vafgrant.qa.test.utils.UtilityOperation;

public class Main {

    protected double temp;
    protected double feels_like;
    protected double temp_min;
    protected double temp_max;
    protected int pressure;
    protected int humidity;
    protected int sea_level;
    protected int grnd_level;

    public int getGrnd_level() {return grnd_level;}
    public int getSea_level() {return sea_level;}
    public double getFeels_like() { return feels_like;}
    public double getTemp_min() { return temp_min; }
    public double getTemp_max() { return temp_max; }
    public int getPressure() { return pressure; }
    public int getHumidity() { return humidity; }
    public double getTemp() { return UtilityOperation.getOnePlaceDecimal(temp-273); }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("temp", temp)
                .append("feels_like", feels_like)
                .append("temp_min", temp_min)
                .append("temp_max", temp_max)
                .append("pressure", pressure)
                .append("humidity", humidity)
                .append("sea_level", sea_level)
                .append("grnd_level", grnd_level)
                .toString();
    }
}
