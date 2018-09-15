CREATE TABLE users (
  id integer PRIMARY KEY,
  firstName text NOT NULL,
  lastName text NOT NULL,
  salary real
);

ALTER TABLE users
  ADD dateOfBirth text NOT NULL;
