CREATE TABLE studied
(
    id_career                   bigint              not null,
    id_subject                  bigint              not null,
    id_type                     bigint              not null,
    id_monster                  bigint              not null,
    inscription_date            date                not null,
    state                       varchar(30)         null,
    date_state                  date                null,
    primary key (id_career, id_subject, id_type, id_monster),
    CONSTRAINT fk_career_subject foreign key (id_career, id_subject) references career_subject(id_career, id_subject),
    CONSTRAINT fk_monster_studied foreign key (id_type, id_monster) references monster(id_type, id_monster)
)