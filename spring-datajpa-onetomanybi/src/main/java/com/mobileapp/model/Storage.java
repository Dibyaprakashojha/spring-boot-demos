package com.mobileapp.model;

public enum Storage {
    STORAGE32("32GB"),
    STORAGE64("64GB"),
    STORAGE128("128GB"),
    STORAGE256("256GB");

    public String capacity;

    Storage(String capacity) {
        this.capacity = capacity;
    }
}
