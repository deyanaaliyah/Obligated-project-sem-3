package kea.sem3.demo.repository;

import kea.sem3.demo.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface IAlbumRepository extends CrudRepository<Album, Long> {

    //public boolean create(Album album);
    //public List<Album> readAll();
}