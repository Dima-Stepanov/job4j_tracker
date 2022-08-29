create table if not exists items (
    item_id serial primary key,
    item_name varchar(2000),
    created timestamp
);