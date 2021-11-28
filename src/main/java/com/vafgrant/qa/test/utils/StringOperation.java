package com.vafgrant.qa.test.utils;

public class StringOperation {

    public static int extractInteger(String stringValue){
        return Integer.parseInt(stringValue.replaceAll("[^0-9]", ""));
    }
}
