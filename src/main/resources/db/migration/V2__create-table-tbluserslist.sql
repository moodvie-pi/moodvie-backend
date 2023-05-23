CREATE TABLE tblContentList (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    idUser INTEGER NOT NULL,
    idMovie INTEGER NOT NULL,
    listType VARCHAR(255) NOT NULL,
    listName VARCHAR(255),
    FOREIGN KEY (idUser) REFERENCES tblusers(id)
);
