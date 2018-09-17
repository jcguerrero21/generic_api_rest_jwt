--INSERTAMOS LOS USUARIOS
insert into quirobel.usuarios (id, username, password, activo) VALUES(1, 'admin', '$2a$04$wHXyyLYl52Rs.Tv0pb69WeeQ1FtwpuuBMfJ8uSYXN8CaJ63POBl5a', 1);
insert into quirobel.usuarios (id, username, password, activo) VALUES(2, 'jcguerrero21', '$2a$04$wHXyyLYl52Rs.Tv0pb69WeeQ1FtwpuuBMfJ8uSYXN8CaJ63POBl5a', 1);

--INSERTAMOS LO ROLES
insert into quirobel.authorities (usuario_id, authority) VALUES(1, 'ROLE_USER');
insert into quirobel.authorities (usuario_id, authority) VALUES(2, 'ROLE_USER');
insert into quirobel.authorities (usuario_id, authority) VALUES(2, 'ROLE_ADMIN');