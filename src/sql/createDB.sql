/******************************************************
* Create the database named budget and its tables *
******************************************************/
DROP DATABASE IF EXISTS budget;
CREATE DATABASE budget;
USE budget;

CREATE TABLE expense
(
    expenseID INT AUTO_INCREMENT primary key,
    name      VARCHAR(50) NOT NULL
);
CREATE TABLE monthlyExpense
(
    expenseID INT not null,
    monthID   INT not null,
    primary key (expenseID, monthID),
    foreign key (expenseID) references expense (expenseID, name)
);
