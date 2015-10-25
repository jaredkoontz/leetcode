package bestTimeToBuyAndSellStock;

//todo
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int n = prices.length, ans, p = 0;
        if (n < 2)
            return 0;
        int[] l = new int[n];
        for (int i = 1; i < n; i++)
            if (prices[i]-prices[i-1]+l[i-1] > 0)
                l[i] = prices[i]-prices[i-1]+l[i-1];
        for (int i = 1; i < n; i++)
            if (l[i] < l[i-1])
                l[i] = l[i-1];
        ans = l[n-1];
        for (int i = n-2; i >= 0; i--) {
            if (-prices[i]+prices[i+1]+p > 0)
                p = -prices[i]+prices[i+1]+p;
            else
                p = 0;
            if (i > 0 && p+l[i-1] > ans)
                ans = p+l[i-1];
        }
        return ans;
    }
}
