package kea.sem3.demo.repository;

import kea.sem3.demo.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface IGenreRepository extends CrudRepository<Genre, Long> {
}
