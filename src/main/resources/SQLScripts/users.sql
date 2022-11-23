
USE data;

CREATE TABLE IF NOT EXISTS users (

    username VARCHAR(50),
    password VARCHAR(50),
    usertype ENUM ('DATA', 'INCIDENT', 'BUSINESS', 'ADMIN'),
    PRIMARY KEY(username)

);

TRUNCATE users;

INSERT INTO users (username, password, usertype)
VALUES('Jaw22','1234','DATA');

INSERT INTO users (username, password, usertype)
VALUES('william12','1234','INCIDENT');

INSERT INTO users (username, password, usertype)
VALUES('bas02','1234','BUSINESS');

INSERT INTO users (username, password, usertype)
VALUES('Albert00','1234','ADMIN');





