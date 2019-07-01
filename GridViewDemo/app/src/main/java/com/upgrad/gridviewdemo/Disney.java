package com.upgrad.gridviewdemo;

public class Disney {
    private String charaterName;
    private String tagLine;
    private int imgID;

    public Disney(String charaterName, String tagLine, int imgID) {
        this.charaterName = charaterName;
        this.tagLine = tagLine;
        this.imgID = imgID;
    }


    public String getCharaterName() {
        return charaterName;
    }

    public String getTagLine() {
        return tagLine;
    }

    public int getImgID() {
        return imgID;
    }
}
