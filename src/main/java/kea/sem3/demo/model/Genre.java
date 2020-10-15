package kea.sem3.demo.model;

import javax.persistence.*;
import java.util.Set;

// Creates a table
@Entity
public class Genre {

    // Generates an id which is auto incremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // This is the columns
    private String category;

    // Getters and setters
    public Long getId() {                                       return id; }
    public void setId(Long id) {                                this.id = id; }
    public String getCategory() {                               return category; }
    public void setCategory(String category) {                  this.category = category;  }
    public Set<Album> getAlbumSet() {                           return albumSet; }
    public void setAlbumSet(Set<Album> albumSet) {              this.albumSet = albumSet; }

    // This is the relation types
    @OneToMany(mappedBy = "genres")
    private Set<Album> albumSet;
}