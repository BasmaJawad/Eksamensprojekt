USE data;

CREATE TABLE IF NOT EXISTS incidentsReports
(
    reportID   int unique auto_increment,
    contractID int REFERENCES contracts (contractID),
    date       VARCHAR(10),
    PRIMARY KEY (reportID)
);


insert into incidentsReports(contractID,date)
values (1, '2022-11-24');