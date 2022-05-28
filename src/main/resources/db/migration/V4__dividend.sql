create table dividend
(
    id              SERIAL      not null primary key,
    dividend_amount double precision     not null,
    wkn             varchar(20) not null,
    depotId         integer     not null,
    currency        varchar(10) not null,
    dividend_date   timestamp   not null,
    last_updated    timestamp   not null default now()
);

