package kea.sem3.demo.repository;

import kea.sem3.demo.model.Album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlbumRepository  {

    /*@Override
    public boolean create(Album album) {
        return false;
    }

    @Override
    public List<Album> readAll() {
        // Creates a list to return
        List<Album> albumToReturn = new ArrayList<>();

        String sql = "SELECT * FROM ALBUM";
        sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        while(sqlRowSet.next()){
            albumToReturn.add(new Album(sqlRowSet.getLong("id"),
                    sqlRowSet.getString("artist_name"),
                    sqlRowSet.getString("genre_category"),
                    sqlRowSet.getString("title")));
        }
        return albumToReturn;
    }*/
}
