package kea.sem3.demo.repository;

import kea.sem3.demo.model.Album;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AlbumRepository extends CrudRepository<Album, Long> {
    Optional<Album> findByArtists(String artist);
}