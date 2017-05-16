package eu.sig.training.ch04;

public abstract class GeneralAccount {
	
	private int transferLimit = 100;
	private Money balance = new Money();

	public int checkAccountNumber(String counterAccount, int sum) {
		for (int i = 0; i < counterAccount.length(); i++) {
            char character = counterAccount.charAt(i);
            int characterValue = Character.getNumericValue(character);
            sum = sum + (9 - i) * characterValue;
        }
		return sum;
	}
	
	public  Transfer validateTransfer(Transfer result) throws BusinessException
	{
		//no default check
		return result;
	}
    
    public Money addInterest(float interestRate) {
        Money interest = balance.multiply(interestRate);
        if (interest.greaterThan(0)) {
            balance.add(interest);
        } else {
            balance.substract(interest);
        }
        return interest;
    }
    
    public Transfer makeTransfer(String counterAccount, Money amount) 
            throws BusinessException {
            // 1. Assuming result is 9-digit bank account number, validate 11-test:
            int sum = 0; // <1>
            sum = checkAccountNumber(counterAccount, sum);
            if (sum % 11 == 0) {
                // 2. Look up counter account and make transfer object:
                CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
                Transfer result = new Transfer(this, acct, amount); // <2>
                // 3. Check whether withdrawal is to registered counter account:
                return validateTransfer(result);
            } else {
                throw new BusinessException("Invalid account number!!");
            }
        }
    

}
