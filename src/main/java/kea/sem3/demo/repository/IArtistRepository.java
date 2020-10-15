package kea.sem3.demo.repository;

import kea.sem3.demo.model.Artist;
import org.springframework.data.repository.CrudRepository;

public interface IArtistRepository extends CrudRepository<Artist, Long> {
}
