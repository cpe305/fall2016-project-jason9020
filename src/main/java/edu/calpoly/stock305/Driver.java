package edu.calpoly.stock305;

import java.io.*;
import java.util.ArrayList;

import yahoofinance.Stock;

public class Driver {
   public static void main(String args[]) {
      Stock GOO = new Stock("GOOG");
      
      ArrayList<Account> accounts = new ArrayList<Account>();
      File accountInfo = new File("accountInfo.txt");
      
      Account test = new Account("test_account", "password");
      test.addStock(GOO);
      
      Account test2 = new Account("test_account2", "abc123");
      test2.addStock(GOO);
      test2.addStock("AAPL");
      test2.addStock("SPY");
      
      //write the account info to the file
      AccountWriter aw = new AccountWriter(new AccountReader(accounts));
      
      aw.writeAccount(accountInfo, test);
      aw.writeAccount(accountInfo, test2);
      
      //now the accounts are read from the file that was written to
      AccountReader ar = new AccountReader(accounts);
      accounts = ar.uploadAccounts(accountInfo);
      
      for (int i = 0; i < accounts.size(); i++) {
         System.out.println(accounts.get(i).toString());
      }
      
      //System.out.println(test.toString());
      //System.out.println(test2.toString());

   }
}
