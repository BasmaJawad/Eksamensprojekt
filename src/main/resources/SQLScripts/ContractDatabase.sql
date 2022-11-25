create table contracts
(
    contractID        int,
    subLength         ENUM ('THREE_MONTHS','SIX_MONTHS','TWELVE_MONTHS','TWENTYFOUR_MONTHS','THIRTYSIX_MONTHS'),
    finalPrice        int,
    VIN varchar(50),
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


