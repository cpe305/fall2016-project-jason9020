package edu.calpoly.stock305;



import java.io.IOException;
import java.util.ArrayList;

import yahoofinance.Stock;
import yahoofinance.quotes.stock.StockQuotesData;
import yahoofinance.quotes.stock.StockQuotesRequest;

public class Account {
   private String username;
   private String password;
   private ArrayList<Stock> portfolio;
   
   public Account() {
      portfolio = new ArrayList<Stock>();
   }
   
   public Account(String username, String password) {
      this.username = username;
      this.password = password;
      portfolio = new ArrayList<Stock>();
   }
   
   public Account(String username, String password, ArrayList<Stock> portfolio) {
      this.username = username;
      this.password = password;
      portfolio = new ArrayList<Stock>();
      for (int i = 0; i < portfolio.size(); i++) {
         this.portfolio.add(portfolio.get(i));
      }
   }
   
   public String getPassword() {
      return password;
   }
 
   public String getUsername() {
      return username;
   }
   
   public void setPassword(String password) {
      this.password = password;
   }
   
   public void setUsername(String username) {
      this.username = username;
   }
   
   //add a stock to the portfolio given a Stock object as input 
   public void addStock(Stock stock) {	
	  System.out.println("Stock " + stock.getSymbol() + " added to " + getUsername() + "'s portfolio");
      portfolio.add(stock);
   }
   
   //add a stock and update its' information 
   public void addStock(String stockSymbol)  {
	  Stock stock = new Stock(stockSymbol);
	  
      portfolio.add(stock);
	  System.out.println("Stock " + stock.getSymbol() + " added to " + getUsername() + "'s portfolio");      
   }
   
   public String toString() {
	  String stocks = ""; 
	   
      for (int i = 0; i < portfolio.size(); i++) {
         stocks += portfolio.get(i).getSymbol() + " ";
      }
         
      return getUsername() + " " + getPassword() + " " + stocks;
   }
}
