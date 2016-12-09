package edu.calpoly.stock305;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;

public class AccountReader {
   ArrayList<Account> accounts;
   
   public AccountReader(ArrayList<Account> accounts) {
      this.accounts = accounts;
   }
   
   public Account findAccount(Account account) {
      for (Account acc : accounts) {
         if (acc.getUsername().equalsIgnoreCase(account.getUsername())) {
            return acc;
         }
      }
      return null;
   }
   
   /* Loops through text file and goes line by line
    * Splits line of text file into 
    *    token[0] = user name
    *    token[1] = password
    *    token[2...*] = stock names
    * Adds account to list of accounts and returns accounts
    */
   public ArrayList<Account> uploadAccounts(File accountInfo) {
      String line = null;
      Account readAccount;
      
      try {
    	  
         FileReader fReader = new FileReader(accountInfo);
         BufferedReader bReader = new BufferedReader(fReader);
         
         while ((line = bReader.readLine()) != null) {
            String delimiter = "[ ]+";
            String[] tokens = line.split(delimiter);
            
            if (tokens.length > 2) {
               readAccount = new Account(tokens[0], tokens[1]);
               
               if (tokens.length > 2) {
                  for (int i = 2; i < tokens.length; i++) {
                     readAccount.addStock(tokens[i]);
                  }
               }
               accounts.add(readAccount);
            }
            else {
               System.out.println("INVALID ACCOUNT");
            }
         }         
      }
      catch (FileNotFoundException e) {
         System.out.println("Account info file not found.");
      }
      catch (IOException e) {
         e.printStackTrace();
      }
      return accounts;
   }
}
