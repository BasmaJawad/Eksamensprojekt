USE data;

CREATE TABLE IF NOT EXISTS incidentsReports
(
    reportID   int unique,
    contractID int REFERENCES contracts (contractID),
    VIN        long,
    PRIMARY KEY (reportID)

);


insert into incidentsReports(contractID, VIN, reportID)
values (100, 1648463896837495, 10);