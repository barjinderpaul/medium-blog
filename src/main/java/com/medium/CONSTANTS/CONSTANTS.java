package com.medium.CONSTANTS;

public enum CONSTANTS {
    PREFIX_FOR_VIEWS("/WEB-INF/"),
    VIEWS_EXTENSION(".jsp");

    public final String value;

    CONSTANTS(String value){
        this.value = value;
    }
}
