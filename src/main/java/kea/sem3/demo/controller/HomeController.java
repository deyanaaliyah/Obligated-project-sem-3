package kea.sem3.demo.controller;

import kea.sem3.demo.model.Album;
import kea.sem3.demo.repository.IAlbumRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

public class HomeController {

    // Instantiates the album repository interface
    IAlbumRepository albumRepository;
    public HomeController(IAlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }

    // Reserves a customizable URL
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("albums", albumRepository.readAll());

        return "index";
    }
}