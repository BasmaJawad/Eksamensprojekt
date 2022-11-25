USE data;

CREATE TABLE  IF NOT EXISTS incidentsReports(

    contractID int REFERENCES contracts(contractID),
    VIN long,
    reportID int
);

insert into incidentsReports(contractID,VIN,reportID)
values (100,1648463896837495,10);

truncate incidentsReports;










