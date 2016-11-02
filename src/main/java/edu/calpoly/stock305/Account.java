import java.util.ArrayList;

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
   
   public void addStock(Stock stock) {
      portfolio.add(stock);
   }
   
   public void addStock(String stockName) {
      Stock stock = new Stock(stockName);
      portfolio.add(stock);
   }
   
   public String toString() {
      String stocks = "";
      for (int i = 0; i < portfolio.size(); i++) {
         stocks += portfolio.get(i).getName() + " ";
      }
         
      return getUsername() + " " + getPassword() + " " + stocks;
   }
}
