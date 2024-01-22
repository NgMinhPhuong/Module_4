package com.codegym.springuploadsing.model;

public class Song {
    private String nameSong;
    private String nameSinger;
    private String type;
    private String url;

    public Song(){}
    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Song(String nameSong, String nameSinger, String type, String url) {
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.type = type;
        this.url = url;
    }
}
