CREATE TABLE subject
(
    id_subject      bigint      not null auto_increment,
    name            varchar(30) not null,
    is_active       bit             not null,
    deleted_at      datetime(6)     null,
    updated_at      datetime(6)     null,
    created_at      datetime(6)     not null,
    primary key (id_subject)
)