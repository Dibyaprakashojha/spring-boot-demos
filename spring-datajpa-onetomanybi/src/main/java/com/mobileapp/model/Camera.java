package com.mobileapp.model;

public enum Camera {
    FRONT("front camera"),
    REAR("rear camera"),
    DUAL("front and rear camera");

    private String cameraType;

    Camera(String cameraType) {
        this.cameraType = cameraType;
    }

    public String getCamera() {
        return cameraType;
    }
}
