create table depot_owner
(
    depot_owner_id SERIAL      not null primary key,
    first_name     varchar(50) not null,
    last_name      varchar(50) not null,
   -- email      varchar(50) not null,
    last_updated   timestamp   not null default now()
);

