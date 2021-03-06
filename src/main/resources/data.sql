DROP TABLE IF EXISTS tester;
DROP TABLE IF EXISTS bugs;

CREATE TABLE tester (
  id INT PRIMARY KEY,
  FIRST_NAME VARCHAR(250) NOT NULL,
  LAST_NAME VARCHAR(250) NOT NULL,
  COUNTRY VARCHAR(250) NOT NULL,
  LAST_LOGIN VARCHAR(250) NOT NULL
);

CREATE TABLE bugs (
  bugId INT PRIMARY KEY,
  deviceId INT,
  testerId INT
);
