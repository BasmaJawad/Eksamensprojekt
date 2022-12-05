use data;

drop table contracts;

create table contracts
(
    contractID        int unique auto_increment,
    VIN               varchar(17),
    customerID        int,
    subLength         ENUM ('THREE_MONTHS','SIX_MONTHS','TWELVE_MONTHS','TWENTYFOUR_MONTHS','THIRTYSIX_MONTHS'),
    pickupDestination ENUM ('FDM_AARHUS',
        'FMD_VEJLE',
        'FDM_SOENDERBORG',
        'FDM_SILKEBORG',
        'FDM_ODENSE',
        'FDM_NAESTVED',
        'FDM_FREDERICIA',
        'FDM_AALBORG',
        'FDM_HILLEROED',
        'KW_BRUUN'),
    winterTires       boolean,
    vikingHelp        boolean,
    lowDeductible     boolean,
    deliveryInsurance boolean,
    primary key (contractID)

);


ALTER TABLE contracts ADD contractStatus ENUM('LIVE', 'DEAD', 'CANCELLED')



