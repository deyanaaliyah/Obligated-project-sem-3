package kea.sem3.demo.controller;

import kea.sem3.demo.repository.AlbumRepository;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    // Instantiates the album repository interface
    AlbumRepository albumRepository;
    public HomeController(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }

    // Reserves a customizable URL
    @GetMapping("/")
    public String index(){

        return "index";
    }
}