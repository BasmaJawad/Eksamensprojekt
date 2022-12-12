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
    kmPrMonth         enum ('FIFTEEN_HUNDRED', 'SEVENTEEN_HUNDRED_AND_FIFTY', 'TWO_THOUSAND', 'TWO_THOUSAND_FIVE_HUNDRED', 'THREE_THOUSAND', 'THREE_THOUSAND_FIVE_HUNDRED', 'FOUR_THOUSAND', 'FOUR_THOUSAND_FIVE_HUNDRED'),
    date              varchar(10),
    contractStatus    enum ('LIVE','CANCELLED','DEAD'),
    primary key (contractID)
);