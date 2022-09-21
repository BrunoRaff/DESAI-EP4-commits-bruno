CREATE TABLE USER (
	id int,
	name varchar(50),
	lastname varchar(50),
	username varchar(50),
	password varchar(50),
	tipDoc char(5),
	nroDoc varchar(20),
	enable int
)

ALTER TABLE USER ADD PRIMARY KEY (id)
ALTER TABLE USER MODIFY COLUMN id int AUTO_INCREMENT NOT NULL


INSERT INTO USER (name, lastname, username, password, tipDoc, nroDoc, enable) VALUES
('Maria', 'Santillan', 'marias', 'gg123', 'DNI', '70321432', 1)
('Salomon', 'Frohlich Gavrilas', 'safg', 'gg123', 'DNI', '71232112', 1)

UPDATE USER SET name='Mariana' WHERE username='marias'
DELETE FROM USER WHERE username='marias'

SELECT * FROM user