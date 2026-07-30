package com.Banking;
import java.util.Scanner;

public class BankingProject {

	public static void main(String[] args) {

		Scanner obj = new Scanner(System.in);

		int choice = 0;

		AccountDAO dao = new AccountDAO();

		while (true) {

			System.out.println("****************************************************");
			System.out.println("****************************************************");
			System.out.println("*********** Banking Management System **************");
			System.out.println("*********** 1.Create Account           *************");
			System.out.println("*********** 2.View All Accounts        *************");
			System.out.println("*********** 3.Search Account           *************");
			System.out.println("*********** 4.Deposit Money            *************");
			System.out.println("*********** 5.Withdraw Money           *************");
			System.out.println("*********** 6.Transfer Money           *************");
			System.out.println("*********** 7.Balance Enquiry          *************");
			System.out.println("*********** 8.Delete Account           *************");
			System.out.println("*********** 9.Exit                     *************");
			System.out.println("****************************************************");
			System.out.println("****************************************************");

			System.out.print("Enter Your Choice : ");

			choice = obj.nextInt();

			switch (choice) {

			case 1:

				System.out.print("Enter Name : ");
				String name = obj.next();

				System.out.print("Enter Email : ");
				String email = obj.next();

				System.out.print("Enter Password : ");
				String password = obj.next();

				System.out.print("Enter Initial Balance : ");
				double balance = obj.nextDouble();

				dao.createAccount(name, email, password, balance);

				break;

			case 2:

				dao.viewAllAccounts();

				break;

			case 3:

				System.out.print("Enter Account Number : ");
				int accountno = obj.nextInt();

				dao.searchAccount(accountno);

				break;

			case 4:

				System.out.print("Enter Account Number : ");
				accountno = obj.nextInt();

				System.out.print("Enter Deposit Amount : ");
				double amount = obj.nextDouble();

				dao.deposit(accountno, amount);

				break;

			case 5:

				System.out.print("Enter Account Number : ");
				accountno = obj.nextInt();

				System.out.print("Enter Withdraw Amount : ");
				amount = obj.nextDouble();

				dao.withdraw(accountno, amount);

				break;

			case 6:

				System.out.print("Enter Sender Account Number : ");
				int sender = obj.nextInt();

				System.out.print("Enter Receiver Account Number : ");
				int receiver = obj.nextInt();

				System.out.print("Enter Transfer Amount : ");
				amount = obj.nextDouble();

				dao.transferMoney(sender, receiver, amount);

				break;

			case 7:

				System.out.print("Enter Account Number : ");
				accountno = obj.nextInt();

				dao.balanceEnquiry(accountno);

				break;

			case 8:

				System.out.print("Enter Account Number : ");
				accountno = obj.nextInt();

				dao.deleteAccount(accountno);

				break;

			case 9:

				System.out.println("Thank You...");
				obj.close();
				System.exit(0);

				break;

			default:

				System.out.println("Invalid Choice...");

			}

		}

	}

}
