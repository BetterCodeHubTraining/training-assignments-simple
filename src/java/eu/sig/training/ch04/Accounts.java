package eu.sig.training.ch04;

public class Accounts {
	private Money balance = new Money();
    @SuppressWarnings("unused")
    public static CheckingAccount findAcctByNumber(String number) {
        return new CheckingAccount();
    }

    // tag::isValid[]
    public static boolean isValid(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum = sum + (9 - i) * Character.getNumericValue(number.charAt(i));
        }
        return sum % 11 == 0;
    }
    // end::isValid[]
    public int checkAccountNumber(String counterAccount, int sum) {
		for (int i = 0; i < counterAccount.length(); i++) {
            char character = counterAccount.charAt(i);
            int characterValue = Character.getNumericValue(character);
            sum = sum + (9 - i) * characterValue;
        }
		return sum;
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
}