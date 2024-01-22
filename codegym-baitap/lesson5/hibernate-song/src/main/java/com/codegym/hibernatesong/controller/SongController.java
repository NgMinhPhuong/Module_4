package com.codegym.hibernatesong.controller;

import com.codegym.hibernatesong.model.Song;
import com.codegym.hibernatesong.service.ISongService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class SongController {
    @Value("${file}")
    private String file;
    @Autowired
    ISongService iSongService;
    @GetMapping("/songs")
    public String getSong(Model model) {
        model.addAttribute("song", new Song());
        model.addAttribute("songs", iSongService.getAll());
        return "/index";
    }

    @PostMapping("/songs")
    public String save(@ModelAttribute Song song, @RequestParam MultipartFile multiPartFile){
        String fileName = multiPartFile.getOriginalFilename();
        song.setUrl(fileName);
        try{
            FileCopyUtils.copy(multiPartFile.getBytes(), new File(file + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        iSongService.save(song);
        return "redirect:/songs";
    }
}
