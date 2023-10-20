public class Day4BuyAndSellStock {
    public static void main(String[] args){
        int[] prices = {7,1,3,4,9,0,10};
        System.out.print("Maximum Profit: "+ maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];//lets declare the first value as mininum price
        int maxProfit = 0; 

        for(int i=1; i<prices.length;i++){
            //we only update the minPrice if we found any value less than minPrice
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else{
                //and the value is greater we compare it with the previous maxProfit before updating
                maxProfit = Math.max(maxProfit, prices[i]-minPrice);
            }
        }
        return maxProfit;
    }
}
