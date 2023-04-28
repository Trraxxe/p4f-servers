create sequence users_sequence start with 1 increment 1;

create table users
(
    id       bigint primary key,
    username varchar(30)  not null,
    password varchar(200) not null,
    index users_username_index (username),
    constraint unique users_username_unique_index (username),
    constraint users_username_minimal_length check ( length(username) >= 4 ),
    constraint users_password_minimal_length check ( length(username) >= 8 )
);