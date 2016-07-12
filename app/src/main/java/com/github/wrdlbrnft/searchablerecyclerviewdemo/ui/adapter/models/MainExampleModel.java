package com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.adapter.models;

public class MainExampleModel {

    private String contactName;
    private String contactType;
    private String specialLog;


    public MainExampleModel(String contactName, String contactType, String specialLog) {
        this.contactName = contactName;
        this.contactType = contactType;
        this.specialLog = specialLog;
    }


    public String getContactName() {
        return contactName;
    }

    public String getContactType() {
        return contactType;
    }

    public String getSpecialLog() {
        return specialLog;
    }
}
