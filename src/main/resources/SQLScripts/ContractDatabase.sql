create table contracts
(
    contractID        int,
    carID             int unique,
    customerName      VARCHAR(50),
    customerEmail     VARCHAR(50),
    customerAddress   varchar(50),
    customerPhone     varchar(50),
    cpr               varchar(50),
    zipcode           int,
    subLength         ENUM ('THREE_MONTHS','SIX_MONTHS','TWELVE_MONTHS','TWENTYFOUR_MONTHS','THIRTYSIX_MONTHS'),
    finalPrice        int,
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
    primary key (contractID)

);


