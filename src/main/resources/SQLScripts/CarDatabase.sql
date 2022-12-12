USE data;

create table gasCar
(
    carModel  varchar(50),
    carBrand  varchar(50),
    VIN       varchar(17) unique,
    kmPrLiter varchar(50),
    co2PrKm   varchar(50),
    carStatus enum ('NOT_RENTED','RENTED','RETURNED')
);

create table electricCar
(
    carModel              varchar(50),
    carBrand              varchar(50),
    VIN                   varchar(17) unique,
    kmPrCharge            varchar(50),
    cleverNetworkCharging boolean,
    cleverCharging        boolean,
    carStatus             enum ('NOT_RENTED','RENTED','RETURNED')
);
