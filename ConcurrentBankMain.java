import java.util.ArrayList;
import java.util.List;


public class ConcurrentBankMain {
	public static final int TOTAL_TEST_EMPLOYEES = 10;
	
	public static void main(String[] args){
		Bank bank = new Bank();
		List<Thread> empThreads = new ArrayList<Thread>(TOTAL_TEST_EMPLOYEES);
		for (int i=0; i< TOTAL_TEST_EMPLOYEES; i++){
			Thread empThread = new Thread(new BankEmployee(i, bank), "Thread "+i);
			empThreads.add(empThread);
			empThread.start();
		}
		
		long startTime = System.nanoTime();
		for (Thread empThread : empThreads){
			try {
				empThread.join();
				System.out.println(empThread.getName() + " finished.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
