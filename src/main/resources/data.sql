-- data to be inserted into tables
INSERT INTO Artist (name)
VALUES ('SZA'),
       ('Drake'),
       ('Kehlani'),
       ('21 Savage');


INSERT INTO Genre (category)
VALUES ('RnB'),
       ('Hip/Hop'),
       ('Rap'),
       ('Soul'),
       ('Rock'),
       ('EDM'),
       ('Classic'),
       ('Trap'),
       ('Afro');

INSERT INTO Album (title, artist_name, genre_category)
VALUES ('ctrl',                         '1', '1'),
       ('More Life',                    '2', '2'),
       ('I am > I was',                 '4', '3'),
       ('It Was Good Until It Wasnt',   '3', '1'),
       ('Scorpion',                     '2', '4'),
       ('S',                            '1', '4'),
       ('SweetSexySavage',              '3', '1'),
       ('Issa Album',                   '4', '3'),
       ('Z',                            '1', '1');

-- this query finds the artist's name from the artist table, and then pastes it into the album table
UPDATE Album SET artist_name = (SELECT name FROM artist WHERE id = 1) WHERE artist_name = '1';
UPDATE Album SET artist_name = (SELECT name FROM artist WHERE id = 2) WHERE artist_name = '2';
UPDATE Album SET artist_name = (SELECT name FROM artist WHERE id = 3) WHERE artist_name = '3';
UPDATE Album SET artist_name = (SELECT name FROM artist WHERE id = 4) WHERE artist_name = '4';

-- this query finds the genre of the album by replacing the numbers with the genres id
UPDATE Album SET genre_category = (SELECT category FROM genre WHERE id = 1) WHERE genre_category = '1';
UPDATE Album SET genre_category = (SELECT category FROM genre WHERE id = 2) WHERE genre_category = '2';
UPDATE Album SET genre_category = (SELECT category FROM genre WHERE id = 3) WHERE genre_category = '3';
UPDATE Album SET genre_category = (SELECT category FROM genre WHERE id = 4) WHERE genre_category = '4';
UPDATE Album SET genre_category = (SELECT category FROM genre WHERE id = 5) WHERE genre_category = '5';
UPDATE Album SET genre_category = (SELECT category FROM genre WHERE id = 6) WHERE genre_category = '6';
UPDATE Album SET genre_category = (SELECT category FROM genre WHERE id = 7) WHERE genre_category = '7';
UPDATE Album SET genre_category = (SELECT category FROM genre WHERE id = 8) WHERE genre_category = '8';