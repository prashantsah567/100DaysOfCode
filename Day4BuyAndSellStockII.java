public class Day4BuyAndSellStockII {
    public static void main(String[] args){
        int[] prices = {7,1,3,4,9,0,10};
        System.out.print("Maximum Profit: "+ maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int totalProfit = 0;
        for(int i=1; i<prices.length; i++){
            //starting from 2nd day, check if current price is greater than previous one
            //and if that's the case then buy on day1 and sell on day2, repeat this unitil end
            //and store all the profit made on totalProfit variable
            if(prices[i]>prices[i-1])
                totalProfit += prices[i] - prices[i-1];
        }
        return totalProfit;
    }
}
