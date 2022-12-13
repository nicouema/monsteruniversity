CREATE TABLE monster
(
    id_type         bigint          not null,
    id_monster      bigint          not null,
    lastname        varchar(30)     not null,
    name            varchar(30)     not null,
    birthdate       date            not null,
    street_name     varchar(30)     not null,
    street_number   int             not null,
    city_id         bigint          not null,
    is_active       bit             not null,
    deleted_at      datetime(6)     null,
    updated_at      datetime(6)     null,
    created_at      datetime(6)     not null,
    primary key (id_type, id_monster),
    CONSTRAINT id_type_monster foreign key(id_type) references id_type(id_type),
    CONSTRAINT id_city_monster foreign key(city_id) references city(city_id)
)