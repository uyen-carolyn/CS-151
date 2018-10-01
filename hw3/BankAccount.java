import java.util.*; 
/**
 * BankAccount class used by Comparator (see CompareByBalance)
 */
public class BankAccount{
	private String name; 
	private double balance; 
	
	public BankAccount(String name, double balance) {
		this.name = name; 
		this.balance = balance; 
	}
	
	public String getName() {
		return name; 
	}
	
	public double getBalance() {
		return balance; 
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBalance(double balance) {
		this.balance = balance; 
	}
}
