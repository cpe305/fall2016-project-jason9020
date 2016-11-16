import java.io.IOException;

import junit.framework.TestCase;
import yahoofinance.Stock;

public class TestStockClass extends TestCase {

	public void testStockSymbol() {
		Stock aapl = new Stock("AAPL");
		assertEquals(aapl.getSymbol(), "AAPL");
	}
	
	public void testStockName() throws IOException {
		Stock aapl = new Stock("AAPL");
        aapl.setName("Apple Inc");
        assertEquals(aapl.getName(), "Apple Inc");
	}
}
