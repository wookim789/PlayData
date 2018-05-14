package classtest;
import GoodsStocks.GoodsStocks;

public class CalssTest {

	public static void main(String[] args) {
		
		GoodsStocks obj = new GoodsStocks(10000,"5123");
				
		Utility.print("");
		Utility.println(obj.addStock(100000));
		Utility.println(obj.subStock(100000));
		Utility.println(obj.subStock(100000));
		
	}

}
