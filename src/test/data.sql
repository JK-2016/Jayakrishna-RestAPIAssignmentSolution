-- Insert data into EMPLOYEE Table
INSERT INTO EMPLOYEE VALUES (1, 'Raman Hari','IT');
INSERT INTO EMPLOYEE VALUES (2, 'Sahil Shah','HR');
INSERT INTO EMPLOYEE VALUES (3, 'Akshay Shaligram','OPs');
INSERT INTO EMPLOYEE VALUES (4, 'Akshata Joshi','IT');
INSERT INTO EMPLOYEE VALUES (5, 'Suchita Roy','HR');

INSERT INTO ROLES VALUES(1,'ADMIN');
INSERT INTO ROLES VALUES(2,'USER');

INSERT INTO USERS VALUES(1,'admin','admin');
INSERT INTO USERS VALUES(2,'user',user);

INSERT INTO users_roles VALUES(1,1);
INSERT INTO users_roles VALUES(2,2);

select * FROM users;
select * from users_roles;
select * from roles;

--delete from users_roles;
