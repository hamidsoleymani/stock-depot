create table stock
(
    stock_name          varchar(20)      not null,
    depot_id            integer          not null,
    wkn                 varchar(20)      not null primary key,
    isin                varchar(20)      not null,
    stock_exchange_buy  varchar(20)      not null,
    stock_exchange_sell varchar(20),
    buy_date            date,
    sell_date           date,
    buy_price           double precision not null,
    sell_price          double precision,
    quantity            integer          not null,
    currency            varchar(10)      not null,
    last_updated        timestamp        not null default now()
);

