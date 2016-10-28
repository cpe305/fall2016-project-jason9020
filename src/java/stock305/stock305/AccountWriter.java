import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class AccountWriter {
   AccountReader accountReader;
   
   public AccountWriter(AccountReader ar) {
      this.accountReader = ar;
   }
   
   public void writeAccount(File accountInfo, Account account) {
      try {
         FileWriter fWriter;
         BufferedWriter bWriter;
         PrintWriter out;
         
         //file reading
         if (!accountInfo.exists()) {
            accountInfo.createNewFile();
            fWriter = new FileWriter(accountInfo.getAbsoluteFile());
            bWriter = new BufferedWriter(fWriter);
         }
         else {
            fWriter = new FileWriter(accountInfo.getAbsoluteFile(), true);
            bWriter = new BufferedWriter(fWriter);
         }
         
         //account writing
         if (accountReader.findAccount(account) == null) {
            out = new PrintWriter(bWriter);
            out.println(account.toString());
            System.out.println("Account registered successfully");
         }
         else {
            System.out.println("Account already registered");
         }
            
         bWriter.close();
      } 
      catch (IOException ioe) {
         System.out.println("Account registration failed");
         ioe.printStackTrace();
      }
      
   }
}
