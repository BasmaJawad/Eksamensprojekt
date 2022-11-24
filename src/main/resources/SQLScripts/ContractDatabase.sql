create table contracts
(
    contractID      int,
    carID           int unique,
    customerName    VARCHAR(50),
    customerEmail   VARCHAR(50),
    customerAddress varchar(50),
    customerPhone   varchar(50),
    cpr             varchar(50),
    zipcode         int,
    subLength       VARCHAR(50),
    finalPrice      int,
    pickupDestination varchar(50),
    primary key (contractID)

);
