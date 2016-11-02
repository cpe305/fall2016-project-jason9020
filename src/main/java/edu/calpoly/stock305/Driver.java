import java.io.File;
import java.util.ArrayList;

public class Driver {
   public static void main(String args[]) {
      Stock GOO = new Stock("GOO");
      Stock YAH = new Stock("YAH");
      ArrayList<Account> accounts = new ArrayList<Account>();
      File accountInfo = new File("accountInfo.txt");
      
      Account test = new Account("test", "test");
      test.addStock(GOO);
      
      Account test2 = new Account("test2", "test2");
      test2.addStock(GOO);
      test2.addStock(YAH);
      
      AccountReader ar = new AccountReader(accounts);
      accounts = ar.uploadAccounts(accountInfo);
      
      AccountWriter aw = new AccountWriter(ar);
      aw.writeAccount(accountInfo, test);
      aw.writeAccount(accountInfo, test2);
      
      for (int i = 0; i < accounts.size(); i++) {
         System.out.println(accounts.get(i).toString());
      }
   }
}
