USE data;

CREATE TABLE IF NOT EXISTS incidentsReports
(
    reportID   int unique auto_increment,
    contractID int REFERENCES contracts (contractID),
    VIN        VARCHAR(17),
    date       VARCHAR(10),
    PRIMARY KEY (reportID)
);


insert into incidentsReports(contractID, VIN, date)
values (1, '164846389683749', '2022-11-24');