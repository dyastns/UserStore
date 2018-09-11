/*CREATE TABLE users (
  id integer PRIMARY KEY,
  firstName text NOT NULL,
  lastName text NOT NULL,
  salary real
);*/
/*
ALTER TABLE users
  ADD dateOfBirth text;
*/
select * from users;
SELECT id, firstName, lastName, salary, dateOfBirth FROM users;
/*
INSERT INTO users (id, firstName, lastName, salary)
  VALUES (1, "John", "Silver", 4000);
INSERT INTO users (id, firstName, lastName, salary)
  VALUES (2, "Billy", "Bones", 3500);
INSERT INTO users (id, firstName, lastName, salary)
VALUES (3, "Jim", "Hawkins", 700);
INSERT INTO users (id, firstName, lastName, salary)
VALUES (4, "David", "Livesey", 3000.9);
INSERT INTO users (id, firstName, lastName)
VALUES (5, "Alexander", "Smollett");
INSERT INTO users (id, firstName, lastName, salary)
VALUES (6, "John", "Trelawney", 6300.5);*/
/*
UPDATE users SET dateOfBirth = "1710-12-07" WHERE id = 1;
UPDATE users SET dateOfBirth = "1720-05-24" WHERE id = 4;
UPDATE users SET dateOfBirth = "1721-07-14" WHERE id = 5;
UPDATE users SET dateOfBirth = "1719-11-08" WHERE id = 6;
*/