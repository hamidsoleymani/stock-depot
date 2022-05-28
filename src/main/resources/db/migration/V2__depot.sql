create table depot
(
    depot_id       SERIAL      not null primary key,
    depot_owner_id integer     not null,
    depot_name     varchar(50) not null,
    broker_name    varchar(50) not null,
    last_updated   timestamp   not null default now()
);

