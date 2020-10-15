package kea.sem3.demo.controller;

import kea.sem3.demo.repository.AlbumRepository;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    AlbumRepository albumRepository;
    public HomeController(AlbumRepository albumRepository){        this.albumRepository = albumRepository; }

    @GetMapping("/")
    public String index(){

        return "/Users/deyanaaliyah/Desktop/softwarekonstruktion/idk/obligated-project/src/main/resources/templates/index.html";
    }
}