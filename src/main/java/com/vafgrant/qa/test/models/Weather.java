package com.vafgrant.qa.test.models;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Weather {

    protected int id;
    protected String main;
    protected String description;
    protected String icon;

    public int getId() { return id; }
    public String getMain() { return main; }
    public String getDescription() { return description; }
    public String getIcon() { return icon; }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("main", main)
                .append("description", description)
                .append("icon", icon)
                .toString();
    }
}
