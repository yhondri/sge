CREATE TABLE `product_product` (
    `id` integer NOT NULL,
    `default_code` varchar(200),
    `active` int(11),
    `product_tmpl_id` numeric NOT NULL,
    `barcode` varchar(200),
    `volume` numeric,
    `weight` numeric,
    `message_last_post` DATETIME,
   `activity_date_deadline` DATETIME,
    `create_uid` numeric,
    `create_date` DATETIME,
    `write_uid` numeric,
    `write_date` DATETIME
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;