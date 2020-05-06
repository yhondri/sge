CREATE TABLE `product_product` (
    `id` integer NOT NULL,
    `default_code` numeric,
    `active` numeric,
    `barcode` varchar(200),
    `volume` numeric,
    `weight` numeric
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;