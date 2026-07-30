package com.Banking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {

    Connection connection = null;

    // Create Account
    public void createAccount(String name, String email, String password, double balance) {

        connection = ConnectionManager.getConnection();

        String query = "insert into account(name,email,password,balance) values(?,?,?,?)";

        try {

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setDouble(4, balance);

            int count = statement.executeUpdate();

            if (count != 0) {

                connection.commit();
                System.out.println("Account Created Successfully");

            } else {

                connection.rollback();
                System.out.println("Error in Creating Account");

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    // View All Accounts
    public void viewAllAccounts() {

        connection = ConnectionManager.getConnection();

        try {

            connection.setAutoCommit(true);

            String query = "select * from account";

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet set = statement.executeQuery();

            while (set.next()) {

                System.out.println(
                        set.getInt(1) + " "
                                + set.getString(2) + " "
                                + set.getString(3) + " "
                                + set.getString(4) + " "
                                + set.getDouble(5));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    // Search Account
    public void searchAccount(int accountno) {

        connection = ConnectionManager.getConnection();

        try {

            connection.setAutoCommit(true);

            String query = "select * from account where accountno=?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, accountno);

            ResultSet set = statement.executeQuery();

            if (set.next()) {

                System.out.println(
                        set.getInt(1) + " "
                                + set.getString(2) + " "
                                + set.getString(3) + " "
                                + set.getString(4) + " "
                                + set.getDouble(5));

            } else {

                System.out.println("Account Not Found");

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    // Deposit
    public void deposit(int accountno, double amount) {

        connection = ConnectionManager.getConnection();

        String query = "update account set balance=balance+? where accountno=?";

        try {

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setDouble(1, amount);
            statement.setInt(2, accountno);

            int count = statement.executeUpdate();

            if (count != 0) {

                connection.commit();

                System.out.println("Amount Deposited Successfully");

            } else {

                connection.rollback();

                System.out.println("Account Not Found");

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    // Withdraw
    public void withdraw(int accountno, double amount) {

        connection = ConnectionManager.getConnection();

        try {

            String query = "select balance from account where accountno=?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, accountno);

            ResultSet set = statement.executeQuery();

            if (set.next()) {

                double balance = set.getDouble(1);

                if (balance >= amount) {

                    String update = "update account set balance=balance-? where accountno=?";

                    PreparedStatement ps = connection.prepareStatement(update);

                    ps.setDouble(1, amount);
                    ps.setInt(2, accountno);

                    int count = ps.executeUpdate();

                    if (count != 0) {

                        connection.commit();

                        System.out.println("Amount Withdrawn Successfully");

                    } else {

                        connection.rollback();

                        System.out.println("Withdraw Failed");

                    }

                } else {

                    System.out.println("Insufficient Balance");

                }

            } else {

                System.out.println("Account Not Found");

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    // Transfer Money
    public void transferMoney(int sender, int receiver, double amount) {

        connection = ConnectionManager.getConnection();

        try {

            String query = "select balance from account where accountno=?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, sender);

            ResultSet set = statement.executeQuery();

            if (set.next()) {

                double balance = set.getDouble(1);

                if (balance >= amount) {

                    String withdraw = "update account set balance=balance-? where accountno=?";

                    PreparedStatement ps1 = connection.prepareStatement(withdraw);

                    ps1.setDouble(1, amount);
                    ps1.setInt(2, sender);

                    int count1 = ps1.executeUpdate();

                    String deposit = "update account set balance=balance+? where accountno=?";

                    PreparedStatement ps2 = connection.prepareStatement(deposit);

                    ps2.setDouble(1, amount);
                    ps2.setInt(2, receiver);

                    int count2 = ps2.executeUpdate();

                    if (count1 != 0 && count2 != 0) {

                        connection.commit();

                        System.out.println("Money Transferred Successfully");

                    } else {

                        connection.rollback();

                        System.out.println("Transaction Failed");

                    }

                } else {

                    System.out.println("Insufficient Balance");

                }

            } else {

                System.out.println("Sender Account Not Found");

            }

        } catch (SQLException e) {

            try {

                connection.rollback();

            } catch (SQLException e1) {

                e1.printStackTrace();

            }

            e.printStackTrace();

        }

    }

    // Balance Enquiry
    public void balanceEnquiry(int accountno) {

        connection = ConnectionManager.getConnection();

        try {

            connection.setAutoCommit(true);

            String query = "select balance from account where accountno=?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, accountno);

            ResultSet set = statement.executeQuery();

            if (set.next()) {

                System.out.println("Current Balance : ₹" + set.getDouble(1));

            } else {

                System.out.println("Account Not Found");

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    // Delete Account
    public void deleteAccount(int accountno) {

        connection = ConnectionManager.getConnection();

        String query = "delete from account where accountno=?";

        try {

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, accountno);

            int count = statement.executeUpdate();

            if (count != 0) {

                connection.commit();

                System.out.println("Account Deleted Successfully");

            } else {

                connection.rollback();

                System.out.println("Account Not Found");

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}
