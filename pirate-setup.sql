-- FIRST ITERATION, before we included the role table and refactored the pirate table
DROP TABLE IF EXISTS pirate;
CREATE TABLE pirate (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	role VARCHAR(255) NOT NULL
);

INSERT INTO pirate 
(name, role)
VALUES
('YellowBeard', 'Landlubber'),
('BlackBeard', 'Cook'),
('BlueBeard', 'Captain');

-- SECOND ITERATION
/*
 * DDL below
 */

DROP TABLE IF EXISTS pirate;
DROP TABLE IF EXISTS role;
CREATE TABLE role (
	id SERIAL PRIMARY KEY,
	role VARCHAR(255) NOT NULL
);

INSERT INTO role 
(role)
VALUES
('Captain'),
('Landlubber'),
('Quartermaster'),
('Pen-Spinner');

DROP TABLE IF EXISTS pirate;
CREATE TABLE pirate (
	id SERIAL PRIMARY KEY,-- Serial is basically the same as an INT, but with auto incrementing abilities
	name VARCHAR(255) NOT NULL,
	role_id INTEGER REFERENCES role(id)
);

INSERT INTO pirate 
(name, role_id)
VALUES
('YellowBeard', 1),
('BlackBeard', 2),
('BlueBeard', 3),
('Bach', 1);

/*
 * 
 */
-- DQL Statements
SELECT *
FROM pirate;

SELECT *
FROM role;

-- These are what are known as SQL Joins
-- Joins are where you join tables together when they meet certain conditions on each row
SELECT *
FROM pirate p
INNER JOIN role r
ON p.role_id = r.id;
