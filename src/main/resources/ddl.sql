CREATE TABLE chatters
(
    idChatters INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Name VARCHAR(45) NOT NULL,
    session_Id VARCHAR(45)
);
CREATE TABLE messages
(
    userName VARCHAR(45) NOT NULL,
    text LONGTEXT NOT NULL,
    addingTime VARCHAR(20) PRIMARY KEY NOT NULL
);
CREATE UNIQUE INDEX idChatters_UNIQUE ON chatters (idChatters);
