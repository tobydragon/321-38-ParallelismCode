import java.util.ArrayList;
import java.util.List;


public class Bank {

	public static final int TOTAL_TEST_ACCOUNTS = 10;
	
	private List<Account> accounts;
	
	public Bank(){
		accounts = new ArrayList<Account>(TOTAL_TEST_ACCOUNTS);
		
		for (int i=0; i< TOTAL_TEST_ACCOUNTS; i++){
			accounts.add(new Account (0));
		}
	}
	
	public void deposit(int empId, int acctNumber, float amount){
		accounts.get(acctNumber).deposit(amount);
	}
	
	public float checkBalance(int acctNumber){
		return accounts.get(acctNumber).checkBalance();
	}
}
