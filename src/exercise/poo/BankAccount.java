package exercise.poo;

public class BankAccount {
	private String name;
	private Integer numberAccount;
	private Double initialBalance;
	protected Double balance;
	
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

	public String getAccountReport(double lastDeposit, double lastWithdraw) {
	    return " Account holder: " + name
	            + "\n Number account: " + numberAccount
	            + "\n Initial balance: $" + String.format("%.2f", initialBalance)
	            + "\n Last Deposit: $" + String.format("%.2f", lastDeposit)
	            + "\n Last Withdraw: $" + String.format("%.2f", lastWithdraw)
	            + "\n--------------------------\n Current balance: $" + String.format("%.2f", balance);
	}
}
