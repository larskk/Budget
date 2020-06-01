/******************************************************
* Create the database named budget and its tables *
******************************************************/
DROP DATABASE IF EXISTS budget;
CREATE DATABASE budget;
USE budget;

CREATE TABLE expense (
  expenseID INT AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  frequency VARCHAR(50),
  amount DOUBLE,
  PRIMARY KEY(expenseID));
