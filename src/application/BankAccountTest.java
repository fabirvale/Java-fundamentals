package application;

import java.util.Locale;
import java.util.Scanner;

import exercise.poo.BankAccount;

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

		BankAccount bankAccount = new BankAccount(name, numberAccount, initialBalance);

		System.out.println();
		System.out.println("====================");
		System.out.println("=====Operations=====");
		System.out.println("====================");

		System.out.print("Deposit amount:");
		double deposit = sc.nextDouble();
		if (deposit <= 0) {
			  System.out.println("Invalid deposit.");
        }
		else {
		  bankAccount.deposit(deposit);
		} 

		System.out.print("Withdraw amount:");
		double withdraw = sc.nextDouble();

		if (bankAccount.getBalance() < withdraw) {
			System.out.println();
			System.out.println("Insufficient balance.\n");
			System.out.println("-----------------------");
			System.out.println("Current balance: $" + String.format("%.2f", bankAccount.getBalance()));

		} else {
			bankAccount.withdraw(withdraw);
			System.out.println();
			System.out.println("========================");
			System.out.println("=====Account Report=====");
			System.out.println("========================");

			System.out.println(bankAccount.toString() 
					           + "\n Deposit: $" + String.format("%.2f", deposit)
					           + "\n WithDraw: $" + String.format("%.2f", withdraw));
	
			System.out.println();
			System.out.println("-----------------------");
			System.out.println("Current balance: $" + String.format("%.2f", bankAccount.getBalance()));
		}
		sc.close();
	}

}
