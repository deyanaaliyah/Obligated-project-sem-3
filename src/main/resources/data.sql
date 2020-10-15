-- data to be inserted into tables
INSERT INTO Artist (name)                                       VALUES ('SZA');
INSERT INTO Artist (name)                                       VALUES ('Drake');
INSERT INTO Artist (name)                                       VALUES ('Kehlani');
INSERT INTO Artist (name)                                       VALUES ('21 Savage');

INSERT INTO Genre (category)                                    VALUES ('Hip/Hop');
INSERT INTO Genre (category)                                    VALUES ('Rap');
INSERT INTO Genre (category)                                    VALUES ('RnB');
INSERT INTO Genre (category)                                    VALUES ('Soul');
INSERT INTO Genre (category)                                    VALUES ('Rock');
INSERT INTO Genre (category)                                    VALUES ('EDM');
INSERT INTO Genre (category)                                    VALUES ('Classic');
INSERT INTO Genre (category)                                    VALUES ('Trap');
INSERT INTO Genre (category)                                    VALUES ('Afro');

INSERT INTO Album (title, artist_name, genre_category)          VALUES ('ctrl', 'SZA', 'RnB');
INSERT INTO Album (title, artist_name, genre_category)          VALUES ('More Life', 'Drake', 'Hip/Hop');
INSERT INTO Album (title, artist_name, genre_category)          VALUES ('I am > I was','21 Savage', 'Rap');
INSERT INTO Album (title, artist_name, genre_category)          VALUES ('It Was Good Until It Wasnt','Kehlani','RnB');
INSERT INTO Album (title, artist_name, genre_category)          VALUES ('Scorpion','Drake','Soul');
INSERT INTO Album (title, artist_name, genre_category)          VALUES ('S','SZA','Soul');
INSERT INTO Album (title, artist_name, genre_category)          VALUES ('SweetSexySavage','Kehlani','RnB');
INSERT INTO Album (title, artist_name, genre_category)          VALUES ('Z','SZA','RnB');
INSERT INTO Album (title, artist_name, genre_category)          VALUES ('Issa Album','21 Savage','Rap');

-- this query finds the artist's name from the artist table, and then pastes it into the album table
-- UPDATE Album SET artist_name = (SELECT name FROM Artist WHERE name = artist_name);
-- this query finds the genre of the album from the genre-table
UPDATE Album SET genre_category = (SELECT category FROM Genre WHERE category = genre_category);