package kea.sem3.demo.controller;

import kea.sem3.demo.model.Artist;
import kea.sem3.demo.repository.IArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Optional;

@Controller
public class ArtistController {

    @Autowired
    private IArtistRepository repository;

    @GetMapping("/artists")
    public String seeAllArtists(Model model){
        model.addAttribute("artists",repository.findAll());

        return "artists";
    }

    // Create a mapping for create or edit artist
    @GetMapping(path = {"/artist/add", "edit/{id}"})
    public String artistAddOrEditForm(@PathVariable("id") Optional<Long> id, Model model){

        if(id.isPresent()){
            model.addAttribute("artist",repository.findAllById(Collections.singleton(id.get())));
        }
        else{
            model.addAttribute("artist",new Artist());
        }

        return "add_edit_artist";
    }

    // Post is equal to "I requested some things to be added/updated, now I tell the DB to handle and save my choices."
    @PostMapping("/artist/addEdit")
    private String artistAddedOrUpdated(Artist artist){

        // If an ID is not provided, then create/save a new one
        if(artist.getId() == null){
            repository.save(artist);
        }

        // If ID is provided, then change these fields:
        else{
            // Use Optional to find specific artist to be updated
            Optional<Artist> a = repository.findById(artist.getId());
            // When that artist is found... (1/2)

            if(a.isPresent()){
                // ... then update all these fields (2/2)
                Artist editArtist = a.get();
                editArtist.setName(artist.getName());

                // Finally, save updated fields
                repository.save(editArtist);
            }
        }
        return "successful";
    }

    // Delete an artist via its ID
    @GetMapping("/artist/delete/{id}")
    private String deleteArtist(@PathVariable("id") Long id){

        // Once again, use Optional to find the specific artist to be deleted
        Optional<Artist> artist = repository.findById(id);

        // And now use the CrudRepository-infused object to delete it
        repository.deleteById(artist.get().getId());

        return "successful";
    }
}
