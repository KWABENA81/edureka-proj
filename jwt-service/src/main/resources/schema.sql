DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    userName VARCHAR(10) not null,
    password VARCHAR(25) not null
);
