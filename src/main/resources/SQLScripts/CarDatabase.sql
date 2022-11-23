USE data;

CREATE TABLE cars(CarID int unique AUTO_INCREMENT, CarModel varchar(50), CarBrand varchar(40), VIN long, co2Emission varchar(50));

INSERT INTO cars(CarModel, CarBrand, VIN, co2Emission) VALUES ('C1 Le Mans 72 HK', 'Citroën', 1648463896837495, '109g/km');
INSERT INTO cars(CarModel, CarBrand, VIN, co2Emission) VALUES ('108 Active+ 72 HK', 'Peugeot', 16484636453574612, '111g/km');
INSERT INTO cars(CarModel, CarBrand, VIN, co2Emission) VALUES ('500e Icon Pack 118 HK', 'Fiat', 45783636453574612, '0g/km');
INSERT INTO cars(CarModel, CarBrand, VIN, co2Emission) VALUES ('C4 Cactus Platinium Benzin', 'Citroën', 45783698142874612, '133g/km');