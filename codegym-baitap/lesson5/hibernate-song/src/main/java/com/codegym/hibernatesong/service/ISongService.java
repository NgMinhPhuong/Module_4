package com.codegym.hibernatesong.service;

import com.codegym.hibernatesong.model.Song;

import java.util.ArrayList;
import java.util.List;

public interface ISongService {
    List<Song> getAll();
    void save(Song song);

    Song getById(int id);
}
