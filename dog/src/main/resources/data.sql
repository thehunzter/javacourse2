CREATE TABLE IF NOT EXISTS dog (
  id LONG PRIMARY KEY auto_increment,
  name VARCHAR(50),
  breed VARCHAR(50),
  origin VARCHAR(50)
);


INSERT INTO dog ( name, breed, origin) VALUES ( 'Fluffy', 'Pomeranian', 'Mountain View, CA');
INSERT INTO dog ( name, breed, origin) VALUES ( 'Spot', 'Pit Bull', 'Austin, TX');
INSERT INTO dog (name, breed, origin) VALUES ( 'Ginger', 'Cocker Spaniel', 'Kansas City, KS');
INSERT INTO dog (name, breed, origin) VALUES ('Lady', 'Direwolf', 'The North');
INSERT INTO dog ( name, breed, origin) VALUES ( 'Sasha', 'Husky', 'Buffalo, NY');