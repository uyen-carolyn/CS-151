import java.util.Comparator;

/**
 * Comparator class for BankAccount
 */
public class CompareByBalance implements Comparator<BankAccount>
{
     public int compare(BankAccount a, BankAccount b)
     {
        if (a.getBalance() < b.getBalance()) {
        	return -1; 
        }
        else if (a.getBalance() > b.getBalance()) {
        	return 1; 
        }
        return 0; 
     }
}
