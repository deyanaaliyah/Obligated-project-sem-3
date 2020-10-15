package kea.sem3.demo.controller;

import kea.sem3.demo.model.Album;
import kea.sem3.demo.repository.IAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class HomeController {

    // Instantiates the album repository interface
    @Autowired
    private IAlbumRepository repository;
    //IAlbumRepository albumRepository;
    //public HomeController(IAlbumRepository albumRepository){
        //this.albumRepository = albumRepository;
    //}

    // Reserves a customizable URL and body contains methods to be executed inside HTML
    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("albumsToReturn", repository.findAll());
        return "index";
    }

    @GetMapping("/create-album")
    public String create(Model model){

        model.addAttribute("album", new Album());
        return "create";
    }
    @PostMapping("/create-album")
    public String createAlbum(Album album){

        repository.save(album);
        return "index";
    }
}