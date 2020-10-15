package kea.sem3.demo.repository;

import kea.sem3.demo.model.Album;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IAlbumRepository {
    public boolean create(Album album);
    public List<Album> readAll();
}