
public class Account {
	private float balance;
	
	public Account(float balance){
		this.balance = balance;
	}
	
	public void deposit (float amount ) {
		balance = balance + amount;
	}
	
	public float checkBalance(){
		return balance;
	}

}