CREATE DATABASE DB1;
CREATE DATABASE DB2;
CREATE DATABASE DB3;

CREATE TABLE DB1.TB1
(
  id INT AUTO_INCREMENT PRIMARY KEY,
  f1 INT NULL,
  f2 INT NULL,
  f3 INT NULL
);

CREATE TABLE DB2.TB2
(
  id INT AUTO_INCREMENT PRIMARY KEY,
  f1 INT NULL,
  f2 INT NULL,
  f3 INT NULL
);

CREATE TABLE DB3.TB3
(
  id INT AUTO_INCREMENT PRIMARY KEY,
  f1 INT NULL,
  f2 INT NULL,
  f3 INT NULL
);


INSERT INTO `DB1`.`TB1` (`f1`, `f2`, `f3`)
(1, 1, 1),
(12, 12, 12),
(13, 13, 13);
VALUES (111, 111, 111);
INSERT INTO `DB2`.`TB2` (`f1`, `f2`, `f3`)
(2, 2, 2),
(22, 22, 22),
(23, 23, 23);
INSERT INTO `DB3`.`TB3` (`f1`, `f2`, `f3`)
(3, 3, 3),
(32, 32, 32),
(33, 33, 33);