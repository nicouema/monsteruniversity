CREATE table career_subject
(
    id_career   bigint      not null,
    id_subject  bigint      not null,
    `description` varchar(50) null,
    `year`        int         null,
    `quarter`     int         null,
    `condition`   varchar(30) null,
    primary key (id_career, id_subject),
    CONSTRAINT fk_id_career foreign key (id_career) references career(id_career),
    CONSTRAINT fk_id_subject foreign key (id_subject) references subject(id_subject)
)