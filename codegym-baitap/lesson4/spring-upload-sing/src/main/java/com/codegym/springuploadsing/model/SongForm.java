package com.codegym.springuploadsing.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private String nameSong;
    private String nameSinger;
    private String type;
    private MultipartFile url;

    public SongForm(){}
    public SongForm(String nameSong, String nameSinger, String type, MultipartFile url) {
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.type = type;
        this.url = url;
    }

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

    public MultipartFile getUrl() {
        return url;
    }

    public void setUrl(MultipartFile url) {
        this.url = url;
    }
}
