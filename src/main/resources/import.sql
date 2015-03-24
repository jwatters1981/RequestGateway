insert into users( user_id, USER_PASSWORD) values ('roy','spring');
insert into users( user_id, USER_PASSWORD) values ('craig','spring');
insert into users( user_id, USER_PASSWORD) values ('greg','spring');

insert into roles(id, name, user_id) values (1,'ROLE_ADMIN','roy');
insert into roles(id, name, user_id) values (2,'ROLE_USER','roy');
insert into roles(id, name, user_id) values (3,'ROLE_USER','craig');
insert into roles(id, name, user_id) values (4,'ROLE_USER','greg');
