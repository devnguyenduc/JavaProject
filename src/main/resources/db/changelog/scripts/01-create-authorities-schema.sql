CREATE TABLE AUTHORITIES(
    USERNAME VARCHAR_IGNORECASE(50) NOT NULL,
    AUTHORITY VARCHAR_IGNORECASE(50) NOT NULL,
    constraint fk_authorities_customer foreign key(username) references VALID_CUSTOMER(username)
);

CREATE UNIQUE index ix_auth_email on authorities (email, authorities);