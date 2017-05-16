package eu.sig.training.ch04;

// tag::SavingsAccount[]
public class SavingsAccount extends GeneralAccount{
    private static final float INTEREST_PERCENTAGE = 0.04f;
    
    private CheckingAccount registeredCounterAccount;

    @Override
	public Transfer validateTransfer(Transfer result) throws BusinessException {
		if (result.getCounterAccount().equals(this.registeredCounterAccount)) 
		{
		    return result;
		} else {
		    throw new BusinessException("Counter-account not registered!");
		}
	}

    
}
// end::SavingsAccount[]
