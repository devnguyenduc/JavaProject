CREATE TABLE VALID_CUSTOMER(
    EMAIL VARCHAR(50) NOT NULL PRIMARY KEY,
    PASSWORD VARCHAR(26) NOT NULL,
    ENABLED BOOLEAN NOT NULL,
    ROLES VARCHAR(10) NOT NULL
);

INSERT INTO VALID_CUSTOMER(email,password,enabled,roles) values("admin@coindesk.com","admin",1,"ADMIN");
INSERT INTO VALID_CUSTOMER(email,password,enabled,roles) values("customer@coindesk.com","pass",1,"USER");