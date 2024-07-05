CREATE TABLE BOOK (
  ID INT AUTO_INCREMENT,
  TITLE VARCHAR(255) NOT NULL,
  PAGES INT NOT NULL,
  AUTHOR VARCHAR(255) NOT NULL
);

--INSERT INTO BOOK (TITLE, PAGES, AUTHOR) VALUES ('SPRING IN ACTION', 100, 'DAN VEGA');
--INSERT INTO BOOK (TITLE, PAGES, AUTHOR) VALUES ('ANGULAR IN ACTION', 150, 'VINAYAK JONDHALE');
--INSERT INTO BOOK (TITLE, PAGES, AUTHOR) VALUES ('KAFKA BASICS', 200, 'POOJA PUJI');

CREATE TABLE ADDRESS(
    ADDRESS_ID INT AUTO_INCREMENT PRIMARY KEY,
    STREET1 VARCHAR(250) NOT NULL,
    STREET2 VARCHAR(250) NOT NULL
);

CREATE TABLE USERS(
    USER_ID INT AUTO_INCREMENT,
    NAME VARCHAR(250) NOT NULL,
    AGE INT NOT NULL,
    ADDRESS_ID INT,
    FOREIGN KEY (ADDRESS_ID) REFERENCES ADDRESS(ADDRESS_ID)
);



--INSERT INTO ADDRESS(STREET1, STREET2) VALUES("XYZ" "ABC");
--INSERT INTO ADDRESS(STREET1, STREET2) VALUES("JKL" "MNO");

--INSERT INTO USER(NAME, AGE) VALUES ("VINAYAK J", 35);
--INSERT INTO USER(NAME, AGE) VALUES ("POOJA J", 32);


