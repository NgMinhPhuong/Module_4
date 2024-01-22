package com.codegym.springuploadsing.controller;

import com.codegym.springuploadsing.model.Song;
import com.codegym.springuploadsing.model.SongForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SongController {
    List<Song> list = new ArrayList<>();
    @Value("${file}")
    private String file;
    private static int cnt = 0;
    @GetMapping("/info")
    public String info(Model model){
        model.addAttribute("songs", list);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("songForm", new SongForm());
        return "/create";
    }
    @PostMapping("/createe")
    public String doo(@ModelAttribute SongForm songForm, Model model){
        MultipartFile multipartFile = songForm.getUrl();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(file + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Song song = new Song(songForm.getNameSong(), songForm.getNameSinger(), songForm.getType(), fileName);
        list.add(song);
        model.addAttribute("message", cnt++);
        return "/create";
    }
}
