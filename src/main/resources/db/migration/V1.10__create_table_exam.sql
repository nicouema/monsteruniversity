CREATE TABLE exam
(
    id_career                           bigint              not null ,
    id_subject                          bigint              not null ,
    id_type                             bigint              not null ,
    id_monster                          bigint              not null ,
    date                                date                not null ,
    is_absent                           bit                 null,
    mark                                int                 null,
    is_active                           bit                 not null,
    deleted_at                          datetime(6)         null,
    updated_at                          datetime(6)         null,
    created_at                          datetime(6)         not null,
    primary key (id_career, id_subject, id_type, id_monster, date),
    CONSTRAINT fk_studied foreign key (id_career, id_subject, id_type, id_monster)
        references studied(id_career, id_subject, id_type, id_monster)
)