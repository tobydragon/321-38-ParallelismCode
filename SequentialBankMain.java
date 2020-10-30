import java.util.ArrayList;
import java.util.List;


public class SequentialBankMain {
	public static final int TOTAL_TEST_EMPLOYEES = 10;
	
	public static void main(String[] args){
		Bank bank = new Bank();
		List<BankEmployee> employees = new ArrayList<>(TOTAL_TEST_EMPLOYEES);
		for (int i=0; i< TOTAL_TEST_EMPLOYEES; i++){
			employees.add(new BankEmployee(i, bank));
		}
		
		long startTime = System.nanoTime();
		for (BankEmployee bankEmployee: employees){
			bankEmployee.run();
			System.out.println(bankEmployee + " finished.");
		}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime)/1000000;
		
		System.out.println("Finished in "+duration +", Final account balances:");
		int total = 0;
		for (int i=0; i<Bank.TOTAL_TEST_ACCOUNTS; i++){
			total += bank.checkBalance(i);
			System.out.println("\t"+i+": "+ bank.checkBalance(i));
		}
		System.out.println("Total for all accounts:"+total);
	}

}
