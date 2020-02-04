CREATE TABLE COIN(
    ID INT NOT NULL PRIMARY KEY,
    COINNAME VARCHAR(40) NOT NULL ,
    VALUE DOUBLE(30,d) NOT NULL
);

CREATE TABLE CUSTOMER(
    ID INT NOT NULL PRIMARY KEY,
    FIRSTNAME VARCHAR(20) NOT NULL,
    LASTNAME VARCHAR(40) NOT NULL
);

insert into COIN(ID,COINNAME,VALUE) values(1, "Ethereum", 166.0);
insert into COIN(ID,COIMNAME,VALUE) values(2, "Bitcoin", 8700.0);
insert into COIN(ID,COINNAME,VALUE) values(3, "Bitcoin Cash", 170.0);

insert into CUSTOMER(ID,FIRSTNAME,LASTNAME) values(1, "Jack", "Bauer");
insert into CUSTOMER(ID,FIRSTNAME,LASTNAME) values(2, "Chloe", "O'Brain");
insert into CUSTOMER(ID,FIRSTNAME,LASTNAME) values(3, "Kim", "Bauer");
insert into CUSTOMER(ID,FIRSTNAME,LASTNAME) values(4, "David", "Palmer");
insert into CUSTOMER(ID,FIRSTNAME,LASTNAME) values(5, "Michelle", "Dessler");
