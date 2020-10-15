-- data to be inserted into tables
INSERT INTO Artist (name) VALUES ('SZA');
INSERT INTO Artist (name) VALUES ('Drake');
INSERT INTO Artist (name) VALUES ('Kehlani');
INSERT INTO Artist (name) VALUES ('21 Savage');

INSERT INTO Album (title, artist_name) VALUES ('ctrl', 'SZA');
INSERT INTO Album (title, artist_name) VALUES ('More Life', 'Drake');
INSERT INTO Album (title, artist_name) VALUES ('I am > I was','21 Savage');
INSERT INTO Album (title, artist_name) VALUES ('It Was Good Until It Wasnt','Kehlani');
INSERT INTO Album (title, artist_name) VALUES ('Scorpion','Drake');
INSERT INTO Album (title, artist_name) VALUES ('S','SZA');
INSERT INTO Album (title, artist_name) VALUES ('SweetSexySavage','Kehlani');
INSERT INTO Album (title, artist_name) VALUES ('Z','SZA');
INSERT INTO Album (title, artist_name) VALUES ('Issa Album','21 Savage');


-- this query finds the artist's name from the artist table, and then pastes it into the album table
UPDATE Album SET artist_name = (SELECT name FROM Artist WHERE name = artist_name);