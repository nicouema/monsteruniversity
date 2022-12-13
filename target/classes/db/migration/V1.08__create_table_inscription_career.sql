CREATE TABLE inscription_career
(
    id_career           bigint          not null,
    id_type             bigint          not null,
    id_monster          bigint          not null,
    inscription_date    date            not null,
    is_active           bit             not null,
    deleted_at          datetime(6)     null,
    updated_at          datetime(6)     null,
    created_at          datetime(6)     not null,
    primary key (id_career, id_type, id_monster),
    CONSTRAINT fk_career foreign key (id_career) references career(id_career),
    CONSTRAINT fk_monster foreign key (id_type, id_monster) references monster(id_type, id_monster)
)