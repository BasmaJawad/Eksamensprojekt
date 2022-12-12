use data;

create table contractPrice
(
    contractID   int unique,
    basePrice    int,
    extraKmPrice int,
    addOnPrices  int,
    finalPrice   int
)