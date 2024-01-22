package com.codegym.springformbinding.model;



public class Form {
    private String language;
    private String size;
    private boolean spamsFilter;
    private String signature;

    public Form(){}

    public Form(String language, String size, boolean spamsFilter, String signature) {
        this.language = language;
        this.size = size;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
