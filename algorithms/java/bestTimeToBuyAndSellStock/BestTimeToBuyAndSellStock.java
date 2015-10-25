package bestTimeToBuyAndSellStock;

//todo
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1){
            return 0;
        }
        int min=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            profit = Math.max(profit, prices[i]-min);
        }
        return profit;
    }

    public int maxKadanesProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
