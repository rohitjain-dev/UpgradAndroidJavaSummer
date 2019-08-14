package com.upgrad.chatterbox;

public class SocietyData {

    String name;
    String details;
    String url;
    String admin;

    public SocietyData(String name, String details, String url, String admin) {
        this.name = name;
        this.details = details;
        this.url = url;
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public String getUrl() {
        return url;
    }

    public String getAdmin() {
        return admin;
    }
}
