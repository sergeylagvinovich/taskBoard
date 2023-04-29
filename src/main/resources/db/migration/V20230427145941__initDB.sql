insert into users(uuid, email, first_name, img, last_name)
    values ('a618182e-e4f4-11ed-b5ea-0242ac120001','sergeylagvinovich@gmail.com','Sergey','path','lagvinovich');


insert into groups (uuid, name)
    values ('a618182e-e4f4-11ed-b5ea-0242ac120001','test group 1');
insert into groups (uuid, name)
    values ('a618182e-e4f4-11ed-b5ea-0242ac120002','test group 2');
insert into groups (uuid, name)
    values ('a618182e-e4f4-11ed-b5ea-0242ac120003','test group 3');
insert into groups (uuid, name)
    values ('a618182e-e4f4-11ed-b5ea-0242ac120004','test group 4');

insert into group_users (role, group_uuid, user_uuid)
    values (0,'a618182e-e4f4-11ed-b5ea-0242ac120001','a618182e-e4f4-11ed-b5ea-0242ac120001');

insert into group_users (role, group_uuid, user_uuid)
    values (1,'a618182e-e4f4-11ed-b5ea-0242ac120002','a618182e-e4f4-11ed-b5ea-0242ac120001');

insert into group_users (role, group_uuid, user_uuid)
    values (2,'a618182e-e4f4-11ed-b5ea-0242ac120003','a618182e-e4f4-11ed-b5ea-0242ac120001');
