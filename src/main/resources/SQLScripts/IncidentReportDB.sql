USE data;

CREATE TABLE  IF NOT EXISTS incidentsReports(

    damageDescription VARCHAR(250) references carDamages(damageDescription),
    damageCost int references carDamages(cost),
    contractID int REFERENCES contracts(contractID),
    VIN long REFERENCES cars(VIN),
    reportID int
);

insert into incidentsReports(damageDescription,damageCost,contractID,VIN,reportID)
values ('Flækkes bagrude',2000,100,1648463896837495,10);
insert into incidentsReports(damageDescription,damageCost,contractID,VIN,reportID)
values ('Defekt radio',1500,100,1648463896837495,10);










