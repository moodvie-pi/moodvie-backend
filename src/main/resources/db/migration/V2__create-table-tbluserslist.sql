CREATE TABLE tblContentList (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    idUser INTEGER NOT NULL,
    idContent INTEGER NOT NULL,
    listType VARCHAR(255) NOT NULL,
    listName VARCHAR(255),
    type VARCHAR(255) NOT NULL,
    FOREIGN KEY (idUser) REFERENCES tblusers(id)
);
