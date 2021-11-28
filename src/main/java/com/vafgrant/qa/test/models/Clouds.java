package com.vafgrant.qa.test.models;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Clouds {

    protected int all;

    public int getAll() { return all; }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("all", all)
                .toString();
    }
}
