package exercise.poo;

public class BankAccount {
	private String name;
	private Integer numberAccount;
	private Double initialBalance;
	private Double balance;
	
	public BankAccount(String name, Integer numberAccount, Double initialBalance) {
		this.name = name;
		this.numberAccount = numberAccount;
		this.initialBalance = initialBalance;
		this.balance = initialBalance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(Integer numAccount) {
		this.numberAccount = numAccount;
	}

		
	public Double getInitialBalance() {
		return initialBalance;
	}

	
	public Double getBalance() {
		return balance;
	}


	public Double deposit(Double deposit) {
		   return balance += deposit;		
	}
    
	public Double withdraw(Double withdraw) {
		return balance -= withdraw;		
	}

	@Override
	public String toString() {
		return " Account holder: " + name 
				+ "\n Number account: " + numberAccount 
				+ "\n Initial balance: $" + String.format("%.2f",initialBalance);
	}


}
