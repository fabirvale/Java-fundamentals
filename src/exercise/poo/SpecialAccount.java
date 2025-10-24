package exercise.poo;

public class SpecialAccount extends BankAccount {
	private Double extraLimit;

	public SpecialAccount(String name, Integer numberAccount, Double initialBalance, Double extraLimit) {
		super(name, numberAccount, initialBalance);
		this.extraLimit = extraLimit;
	}

	public Double getExtraLimit() {
		return extraLimit;
	}

	public void setExtraLimit(Double extraLimit) {
		this.extraLimit = extraLimit;
	}
	
    @Override
    public Double withdraw(Double withdraw) {	
    	  
    	if (withdraw <= balance) {
		  return balance -= withdraw;	
    	}  
    	else if (withdraw <= (balance + extraLimit)){
    		Double oper = (balance + extraLimit) - withdraw;
    		balance = 0.0;
    		return extraLimit -= oper;
    	}
    	else {
    		return 0.0;
    	}
  	}
    
    @Override
    public String getAccountReport(double lastDeposit, double lastWithdraw) {
		return super.getAccountReport(lastDeposit, lastWithdraw)
			   +	" \n Current Limit: $ " + String.format("%.2f", extraLimit);
	}

}
