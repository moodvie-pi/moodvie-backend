CREATE TABLE tblPreference (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    ageLimit VARCHAR(10),
    ignoreWatched BIT,
    blockedGenders VARCHAR(255),
    lang VARCHAR(10),
    theme VARCHAR(100),
    idUser INTEGER NOT NULL,
    FOREIGN KEY (idUser) REFERENCES tblusers(id)
);
CREATE TABLE tblRating (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    rating DOUBLE NOT NULL,
    idUser INTEGER NOT NULL,
    idContent INTEGER NOT NULL,
    FOREIGN KEY (idUser) REFERENCES tblusers(id)
);