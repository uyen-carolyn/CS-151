import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Testing program for Bank Account Class
 * Sort bank accounts by increasing balance
 * @author Uyen Nguyen
 *
 */
public class BankAccountTester
{
     public static void main(String[] args)
     {
        ArrayList<BankAccount> account = new ArrayList<>();
        account.add(new BankAccount("a", 1345.29));
        account.add(new BankAccount("b", 2499.31));
        account.add(new BankAccount("c", 2480.00));
        account.add(new BankAccount("d", 732.56));
        account.add(new BankAccount("e", 3345.44));
        account.add(new BankAccount("f", 800.25));
        Comparator<BankAccount>  comp = new CompareByBalance();
        Collections.sort(account, comp);
          
        for (BankAccount a : account)
          System.out.println(a.getName() + " " + a.getBalance());
     }
