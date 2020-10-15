package kea.sem3.demo.controller;

import kea.sem3.demo.model.Album;
import kea.sem3.demo.repository.IAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Optional;

@Controller
public class HomeController {

    // Instantiates the album repository interface
    @Autowired
    private IAlbumRepository repository;

    // Reserves a customizable URL and body contains methods to be executed inside HTML
    @GetMapping("/")
    public String index(Model model){

        // Prints out all albums on homepage via model.addAttribute method
        model.addAttribute("albumsToReturn", repository.findAll());
        return "index";
    }

    // Create a mapping for create or edit album
    @GetMapping(path = {"/add", "edit/{id}"})
    public String addOrEditForm(@PathVariable("id") Optional<Long> id, Model model){

        if(id.isPresent()){
            model.addAttribute("album",repository.findAllById(Collections.singleton(id.get())));
        }
        else{
            model.addAttribute("album",new Album());
        }

        return "add_edit_album";
    }

    // Post is equal to "I requested some things to be added/updated, now I tell the DB to handle and save my choices."
    @PostMapping("/addEdit")
    private String albumAddedOrUpdated(Album album){

        // If an ID is not provided, then create/save a new one
        if(album.getId() == null){
            repository.save(album);
        }

        // If ID is provided, then change these fields:
        else{
            // Use Optional to find specific album to be updated
            Optional<Album> a = repository.findById(album.getId());
            // When that album is found... (1/2)

            if(a.isPresent()){
                // ... then update all these fields (2/2)
                Album editAlbum = a.get();
                editAlbum.setTitle(album.getTitle());
                editAlbum.setArtistName(album.getArtistName());
                editAlbum.setGenreCategory(album.getGenreCategory());

                // Finally, save updated fields
                repository.save(editAlbum);
            }
        }
        return "successful";
    }

    // Delete an album via its ID
    @GetMapping("/delete/{id}")
    private String deleteAlbum(@PathVariable("id") Long id){

        // Once again, use Optional to find the specific album to be deleted
        Optional<Album> album = repository.findById(id);

        // And now use the CrudRepository-infused object to delete it
        repository.deleteById(album.get().getId());

        return "successful";
    }
}