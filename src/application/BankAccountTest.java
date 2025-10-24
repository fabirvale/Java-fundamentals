package application;

import java.util.Locale;
import java.util.Scanner;

import exercise.poo.BankAccount;
import exercise.poo.SpecialAccount;

public class BankAccountTest {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("======================");
		System.out.println("=====Account Bank=====");
		System.out.println("======================");

		System.out.print("Inform the name: ");
		String name = sc.nextLine();
		System.out.print("Inform the account number: ");
		int numberAccount = sc.nextInt();
		System.out.print("Inform the initial balance: ");
		double initialBalance = sc.nextDouble();
		System.out.print("Inform the credit limit (0 if normal account): ");
		double extraLimit = sc.nextDouble();
		
		 BankAccount account;

	     if (extraLimit > 0) {
	            account = new SpecialAccount(name, numberAccount, initialBalance, extraLimit);
	     } else {
	            account = new BankAccount(name, numberAccount, initialBalance);
	      }

		System.out.println();
		System.out.println("====================");
		System.out.println("=====Operations=====");
		System.out.println("====================");

		System.out.print("Deposit amount:");
		double lastDeposit = sc.nextDouble();
		
		if (lastDeposit <= 0) {
			  System.out.println("Invalid deposit.");
    }
		else {
		 account.deposit(lastDeposit);
		} 
		
		System.out.print("Withdraw amount:");
		double lastWithDraw = sc.nextDouble();
				
		if ((account.getBalance() + extraLimit) < lastWithDraw) {
			System.out.println();
			System.out.println("Insufficient balance.\n");
			System.out.println("-----------------------");
			System.out.println("Current balance: $" + String.format("%.2f", account.getBalance()));

		} else {
				account.withdraw(lastWithDraw);	
				System.out.println();
				System.out.println("========================");
				System.out.println("=====Account Report=====");
				System.out.println("========================");
				System.out.println(account.getAccountReport(lastDeposit, lastWithDraw));

			 }
		sc.close();
	}

}
