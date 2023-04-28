create table users_roles
(
    user_id bigint primary key,
    role_id bigint not null unique,
    constraint foreign key users_roles_user_id_foreign_key (user_id) references users (id),
    constraint foreign key users_roles_role_id_foreign_key (role_id) references roles (id)
)