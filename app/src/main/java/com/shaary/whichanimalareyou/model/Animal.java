package com.shaary.whichanimalareyou.model;

public class Animal {
    private int imageId;
    private float  verticalBias;
    private float horizontalBias;
    private String name;
    private String caption;

    public Animal(String name, int imageId, float verticalBias, float horizontalBias, String caption) {
        this.imageId = imageId;
        this.verticalBias = verticalBias;
        this.horizontalBias = horizontalBias;
        this.caption = caption;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public float getVerticalBias() {
        return verticalBias;
    }

    public float getHorizontalBias() {
        return horizontalBias;
    }

    public String getCaption() {
        return caption;
    }
}
