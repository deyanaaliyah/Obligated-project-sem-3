package kea.sem3.demo.model;

import javax.persistence.*;
import java.util.Set;

// Creates table
@Entity
public class Artist {

    // Generates an id which is auto incremental
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;

    // This is the columns
    private String name;

    // This is the relation type
    @ManyToMany(mappedBy = "artists")
    private Set<Album> album;

    // Getters and setters
    public Long getId() {                                   return id; }
    public void setId(Long id) {                            this.id = id; }
    public String getName() {                               return name; }
    public void setName(String name) {                      this.name = name; }
    public Set<Album> getAlbum() {                          return album; }
    public void setAlbum(Set<Album> album) {                this.album = album; }
}