package GoodsStocks;
import Utility.*;

public class GoodsStocks {
	public int stockNum;
	public String goodsCode;
	
	public GoodsStocks(int stocknum,String goodscode){
		this.stockNum = stocknum;
		this.goodsCode = goodscode;
	}
	
	public int addStock(int money) {
		return (stockNum += money);
	}
	public int subStock(int money) {
		if(stockNum>=money)
			return(stockNum -= money);
		else {
			Utility.println("잔액이 부족합니다.");
			Utility.print("부족한 금액  : ");
			return(stockNum -= money);
		}
	}

}
