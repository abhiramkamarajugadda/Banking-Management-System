# 🏦 Banking Management System

A console-based **Banking Management System** developed using **Java,
JDBC, and MySQL**.

## Features

-   Create New Account
-   View All Accounts
-   Search Account
-   Deposit Money
-   Withdraw Money
-   Transfer Money
-   Balance Enquiry
-   Delete Account
-   Transaction Management using commit() and rollback()

## Technologies Used

-   Java
-   JDBC
-   MySQL
-   Eclipse IDE
-   MySQL Connector/J

## Project Structure

``` text
BankingManagementSystem
├── BankingProject.java
├── AccountDAO.java
├── ConnectionManager.java
└── README.md
```

## Database

Database: `jdbcbank`

  Column      Type
  ----------- -----------------------------------
  accountno   INT (Primary Key, Auto Increment)
  name        VARCHAR(100)
  email       VARCHAR(100)
  password    VARCHAR(100)
  balance     DOUBLE

  : `account`

## JDBC Concepts

-   PreparedStatement
-   ResultSet
-   CRUD Operations
-   Transactions
-   Exception Handling

## How to Run

1.  Create the `jdbcbank` database.
2.  Create the `account` table.
3.  Update database credentials in `ConnectionManager.java`.
4.  Add MySQL Connector/J.
5.  Run `BankingProject.java`.

## Author

**Haaseth Abhiram**
