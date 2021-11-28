package com.vafgrant.qa.test.integrationobjects;

import com.vafgrant.qa.test.configs.ReaderManager;
import com.vafgrant.qa.test.exception.InvalidUserInputException;
import com.vafgrant.qa.test.models.Coord;
import com.vafgrant.qa.test.models.Weather;
import com.vafgrant.qa.test.models.Main;
import com.vafgrant.qa.test.models.Wind;
import com.vafgrant.qa.test.models.Clouds;
import com.vafgrant.qa.test.models.Sys;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ByCityWeatherService extends BaseRestService {

    public Coord coord;
    public List<Weather> weather;
    public String base;
    public Main main;
    public int visibility;
    public Wind wind;
    public Clouds clouds;
    public int dt;
    public Sys sys;
    public int timezone;
    public int id;
    public String name;
    public int cod;


    public  ByCityWeatherService(){
        try {
            base_uri = new URL(ReaderManager.getInstance().getApiConfigReader().getAPIBaseURI());
        } catch (MalformedURLException e) {
            throw new InvalidUserInputException("invalid base uri provided");
        }
    }

    public Coord getCoord() { return coord; }
    public List<Weather> getWeather() { return weather; }
    public String getBase() { return base; }
    public Main getMain() { return main; }
    public int getVisibility() { return visibility; }
    public Wind getWind() { return wind; }
    public Clouds getClouds() { return clouds; }
    public int getDt() { return dt; }
    public Sys getSys() { return sys; }
    public int getTimezone() { return timezone; }
    public int getId() { return id;}
    public String getName() { return name; }
    public int getCod() { return cod; }

    public String  setEndPoint() {
        return "/data/2.5/weather";
    }

    public Map<String,String> setQueryParams(String cityName){
        Map<String, String> mapQueryParams = new HashMap<>();
        mapQueryParams.put("q",cityName);
        mapQueryParams.put("appid",ReaderManager.getInstance().getApiConfigReader().getAPIKey());
        return mapQueryParams;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("coord", coord)
                .append("weather", weather)
                .append("base", base)
                .append("main", main)
                .append("visibility", visibility)
                .append("wind", wind)
                .append("clouds", clouds)
                .append("dt", dt)
                .append("sys", sys)
                .append("timezone", timezone)
                .append("id", id)
                .append("name", name)
                .append("cod", cod)
                .toString();
    }
}
