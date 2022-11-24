USE data;

CREATE TABLE carDamages(
    reportID int REFERENCES incidentsReports(reportID),
    damageDescription varchar(255),
    cost int
);

insert into carDamages (reportID, damageDescription, cost)
values (10, 'flækket bilrude', 2000);
insert into carDamages (reportID, damageDescription, cost)
values (10, 'Brændt forlygter ', 900);



