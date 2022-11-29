USE data;

drop table gasCar;
drop table electricCar;
create table gasCar
(
    carModel  varchar(50),
    carBrand  varchar(50),
    VIN       varchar(17) unique ,
    kmPrLiter varchar(50),
    co2PrKm varchar(50)
);

create table electricCar
(
    carModel varchar(50),
    carBrand varchar(50),
    VIN      varchar(17) unique ,
    kmPrCharge varchar(50),
    cleverNetworkCharging boolean,
    cleverCharging boolean
);

INSERT INTO gasCar(CarModel, CarBrand, VIN, kmPrLiter,co2PrKm)
VALUES ('C1 Le Mans 72 HK', 'Citroën', 1648463896837495, '15km/L', '109g/km');
INSERT INTO gasCar(CarModel, CarBrand, VIN,kmPrLiter, co2PrKm)
VALUES ('108 Active+ 72 HK', 'Peugeot', 16484636453574612,'15km/L', '111g/km');
INSERT INTO electricCar(CarModel, CarBrand, VIN, kmPrCharge, cleverNetworkCharging, cleverCharging)
VALUES ('500e Icon Pack 118 HK', 'Fiat', 45783636453574612, 300,0,0);
INSERT INTO gasCar(CarModel, CarBrand, VIN,kmPrLiter, co2PrKm)
VALUES ('208 Active+', 'Peugeot', 33333333333333333,'18,9km/L', '125g/km');
