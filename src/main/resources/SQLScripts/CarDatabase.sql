USE data;

drop table gasCar;
drop table electricCar;
create table gasCar
(
    carModel  varchar(50),
    carBrand  varchar(50),
    VIN       long ,
    kmPrLiter varchar(50),
    co2PrKm varchar(50)
);

create table electricCar
(
    carModel varchar(50),
    carBrand varchar(50),
    VIN      long ,
    kmPrCharge varchar(50),
    cleverNetworkCharging binary,
    cleverCharging binary
);

INSERT INTO gasCar(CarModel, CarBrand, VIN,kmPrLiter, co2PrKm)
VALUES ('208 envy 82 HK', 'Peugeot', 11111111111111111,'23,4km/L', '109g/km');
INSERT INTO gasCar(CarModel, CarBrand, VIN,kmPrLiter, co2PrKm)
VALUES ('C3 Le Mans 83 HK', 'Citroên', 22222222222222222,'18,5km/L', '123g/km');
INSERT INTO gasCar(CarModel, CarBrand, VIN,kmPrLiter, co2PrKm)
VALUES ('208 Active+', 'Peugeot', 33333333333333333,'18,9km/L', '125g/km');
