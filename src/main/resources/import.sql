--INSERTAMOS LOS USUARIOS
--insert into api.users (id, username, password, enabled) VALUES(1, 'admin', '$2a$04$R8iRKCx3CSudfFItwsz1mehpgTi8lIrK1RAPxIGTOR3n/uVdpaAEO', 1);
insert into quirobel.users (id, username, password, enabled) VALUES(2, 'jcguerrero21', '$2a$04$R8iRKCx3CSudfFItwsz1mehpgTi8lIrK1RAPxIGTOR3n/uVdpaAEO', 1);

--INSERTAMOS LO ROLES
--insert into quirobel.authorities (user_id, authority) VALUES(1, 'ROLE_USER');
insert into quirobel.authorities (user_id, authority) VALUES(2, 'ROLE_USER');
insert into quirobel.authorities (user_id, authority) VALUES(2, 'ROLE_ADMIN');