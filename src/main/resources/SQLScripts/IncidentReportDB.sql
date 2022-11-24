USE data;


CREATE TABLE  IF NOT EXISTS incidentsReports(

    damageDescription VARCHAR(250),
    damageCost int,
    contractID int REFERENCES contracts(contractID),
    VIN long

);

truncate incidentsreports;




