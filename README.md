# Banking Management System (Java, JDBC, MySQL)

A menu-driven console banking application in Java that performs account CRUD and money movements on MySQL through JDBC, using manual commit and rollback for transaction safety.

## Features

- Create account, view all accounts, search account, balance enquiry and delete account
- Deposit and withdraw money
- Transfer money between two accounts as one transaction: debit and credit commit together or roll back together
- Insufficient-balance and account-not-found checks before withdrawals and transfers
- `PreparedStatement` for every query, `connection.setAutoCommit(false)` with explicit `commit()` and `rollback()`

## Tech Stack

Java, JDBC, MySQL, MySQL Connector/J.

## Project Structure

```text
com.Banking
  BankingProject.java      Console menu (options 1 to 9) and user input
  AccountDAO.java          JDBC operations and transaction handling
  ConnectionManager.java   MySQL connection
```

## Database

```sql
CREATE DATABASE jdbcbank;
USE jdbcbank;
CREATE TABLE account (
  accountno INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(100),
  password VARCHAR(100),
  balance DOUBLE
);
```

## How to Run

1. Clone: `git clone https://github.com/abhiramkamarajugadda/Banking-Management-System.git`
2. Create the database and table above.
3. Update the URL, username and password in `ConnectionManager.java`.
4. Place the files in a `com/Banking` folder, add MySQL Connector/J to the classpath, then compile and run:
   ```bash
   javac -cp mysql-connector-j.jar -d out com/Banking/*.java
   java -cp out:mysql-connector-j.jar com.Banking.BankingProject
   ```
   Or import the files into Eclipse or IntelliJ and run `BankingProject`.

## Author

**Abhiram Kamarajugadda**
GitHub: [abhiramkamarajugadda](https://github.com/abhiramkamarajugadda) | Portfolio: [abhiramkamarajugadda.github.io](https://abhiramkamarajugadda.github.io)
