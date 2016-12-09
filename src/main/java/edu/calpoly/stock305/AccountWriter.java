package edu.calpoly.stock305;

import java.io.*;
import java.util.ArrayList;
			
public class AccountWriter {
   AccountReader accountReader;
   ArrayList<Account> accounts;
   
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
         this.accountReader.uploadAccounts(accountInfo);
         
         //if the account doesn't exist, write it
         if (accountReader.findAccount(account) == null) {
            out = new PrintWriter(bWriter);
            out.println(account.toString());
            System.out.println("Account registered successfully");
         }
         //if it does it might have been updated... delete the old account data and write it again
         else {
        	 //creates a temp file, copies old data except old line
        	 //and renames it to the existing data file
        	 //then updates the data
        	 
        	 File tempFile = new File("myTempFile.txt");

        	 BufferedReader reader = new BufferedReader(new FileReader(accountInfo));
        	 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        	 String lineToRemove = account.toString();
        	 String currentLine;

        	 while((currentLine = reader.readLine()) != null) {
        	     // trim newline when comparing with lineToRemove
        	     String trimmedLine = currentLine.trim();
        	     if(trimmedLine.equals(lineToRemove)) continue;
        	     writer.write(currentLine + System.getProperty("line.separator"));
        	 }
        	 writer.close(); 
        	 reader.close(); 
        	 boolean successful = tempFile.renameTo(accountInfo);
        	 
        	 if (successful) {
                 System.out.println("Account already registered... data updated");
        	 }
        	 else {
                 System.out.println("Account already registered... data failed to update");
        	 }
         }
            
         bWriter.close();
      } 
      catch (IOException ioe) {
         System.out.println("Account registration failed");
         ioe.printStackTrace();
      }
      
   }
}
