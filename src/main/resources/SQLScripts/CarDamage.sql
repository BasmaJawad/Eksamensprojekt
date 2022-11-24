USE data;

CREATE TABLE carDamages(
    reportID int REFERENCES incidentsReports(reportID),
    damageDescription varchar(255),
    cost int
);



