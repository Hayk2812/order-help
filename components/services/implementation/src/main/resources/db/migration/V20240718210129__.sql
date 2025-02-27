CREATE TABLE product.user
(
    user_id    UUID primary key not null,
    first_name varchar(64)      not null,
    last_name  varchar(64)      not null,
    email      varchar(64)      not null,
    password   varchar(64)      not null,
    address_id  UUID
);

CREATE TABLE product.address
(
    address_id UUID primary key not null,
    country    varchar(64)      not null,
    city       varchar(64)      not null,
    street     varchar(64)      not null
);