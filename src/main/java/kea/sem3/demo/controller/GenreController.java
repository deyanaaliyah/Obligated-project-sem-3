package kea.sem3.demo.controller;

import kea.sem3.demo.model.Genre;
import kea.sem3.demo.repository.IGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Optional;

@Controller
public class GenreController {

    @Autowired
    private IGenreRepository repository;

    @GetMapping("/genres")
    public String seeAllGenres(Model model){
        model.addAttribute("category",repository.findAll());

        return "genres";
    }

    // Create a mapping for create or edit genre
    @GetMapping(path = {"/genre/add", "edit/{id}"})
    public String genreAddOrEditForm(@PathVariable("id") Optional<Long> id, Model model){

        if(id.isPresent()){
            model.addAttribute("genre",repository.findAllById(Collections.singleton(id.get())));
        }
        else{
            model.addAttribute("genre",new Genre());
        }

        return "add_edit_genre";
    }

    // Post is equal to "I requested some things to be added/updated, now I tell the DB to handle and save my choices."
    @PostMapping("/genre/addEdit")
    private String genreAddedOrUpdated(Genre genre){

        // If an ID is not provided, then create/save a new one
        if(genre.getId() == null){
            repository.save(genre);
        }

        // If ID is provided, then change these fields:
        else{
            // Use Optional to find specific genre to be updated
            Optional<Genre> g = repository.findById(genre.getId());
            // When that artist is found... (1/2)

            if(g.isPresent()){
                // ... then update all these fields (2/2)
                Genre editGenre = g.get();
                editGenre.setCategory(g.get().getCategory());

                // Finally, save updated fields
                repository.save(editGenre);
            }
        }
        return "successful";
    }

    // Delete an genre via its ID
    @GetMapping("/genre/delete/{id}")
    private String deleteArtist(@PathVariable("id") Long id){

        // Once again, use Optional to find the specific genre to be deleted
        Optional<Genre> genre = repository.findById(id);

        // And now use the CrudRepository-infused object to delete it
        repository.deleteById(genre.get().getId());

        return "successful";
    }
}
