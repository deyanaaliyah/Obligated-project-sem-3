package kea.sem3.demo.model;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

// Creates a table
@Entity
public class Album {

    // Generates an id which is auto incremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // This is the columns
    private String title;
    private String artistName;

    // This is the relation type
    @ManyToMany
    private Set<Artist> artists;


    // Getters and setters
    public Long getId() {                                   return id; }
    public void setId(Long id) {                            this.id = id; }
    public String getTitle() {                              return title; }
    public void setTitle(String title) {                    this.title = title; }
    public String getArtistName() {                         return artistName; }
    public void setArtistName(String artistName) {          this.artistName = artistName; }
    public Set<Artist> getArtists() {                       return artists; }
    public void setArtists(Set<Artist> artists) {           this.artists = artists; }
}