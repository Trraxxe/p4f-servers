create sequence roles_sequence start with 1 increment by 1;

create table roles
(
    id   bigint primary key,
    name varchar(30) not null,
    index roles_name_index (name),
    constraint unique roles_name_unique_index (name)
)