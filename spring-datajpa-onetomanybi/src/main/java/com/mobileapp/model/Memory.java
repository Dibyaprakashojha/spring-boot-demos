package com.mobileapp.model;

public enum Memory {
    MEMORY4("4GB"),
    MEMORY6("6GB"),
    MEMORY8("8GB"),
    MEMORY12("12GB");

    public String totalRam;

    Memory(String memories) {
        this.totalRam = memories;
    }
}
