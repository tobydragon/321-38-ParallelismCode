import java.util.Random;


public class BankEmployee implements Runnable{
	private Random testAcctNumGen;
	
	private Bank myBank;
	private int empId;
	
	public BankEmployee(int empId, Bank bank){
		testAcctNumGen = new Random(System.currentTimeMillis() + (empId*1000));
		this.empId = empId;
		this.myBank = bank;
	}
	
	public void run() {
		for (int i=0; i< 10000; i++){
			fakeWork();
			// myBank.deposit(empId, 1, 1);
			myBank.deposit(empId, testAcctNumGen.nextInt(Bank.TOTAL_TEST_ACCOUNTS), 1);
		}
	}

	//wastes time to simluate the work
	private void fakeWork(){
		double x = 100000;
		for (int y=0; y<100000; y++){
			x/=2;
		}
	}

	public String toString(){
		return "Employee " + empId;
	}

}
