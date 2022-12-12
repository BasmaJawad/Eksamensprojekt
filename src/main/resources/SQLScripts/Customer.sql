USE data;

CREATE TABLE customer
(
    CustomerID  int unique AUTO_INCREMENT,
    name        varchar(50),
    cprNum      varchar(50),
    email       varchar(50),
    address     varchar(50),
    phoneNumber varchar(20),
    ZIPCode     int
);