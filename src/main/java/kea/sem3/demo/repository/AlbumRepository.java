package kea.sem3.demo.repository;

import kea.sem3.demo.model.Album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepository implements IAlbumRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    SqlRowSet sqlRowSet;

    @Override
    public boolean create(Album album) {
        return false;
    }

    @Override
    public List<Album> readAll() {
        // Creates a list to return
        List<Album> albumToReturn = new ArrayList<>();

        String sql = "SELECT * FROM Album";
        sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        while(sqlRowSet.next()){
            albumToReturn.add(new Album(sqlRowSet.getLong("id"),
                    sqlRowSet.getString("title"),
                    sqlRowSet.getString("artistName"),
                    sqlRowSet.getString("genreCategory")));
        }
        return albumToReturn;
    }
}
