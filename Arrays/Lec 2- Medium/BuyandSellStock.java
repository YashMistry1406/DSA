import java.util.*;

/**
 * BuyandSellStock
 */
class BuyandSellStock
{
    public int maxProfit(int[] arr)
    {

        int mini = Integer.MAX_VALUE;

        int maxProfit = 0;

        for (int price : arr)
        {
            if (price < mini)
            {
                mini = price;
            } else
            {
                maxProfit = Math.max(maxProfit, price - mini);
            }
        }

        return maxProfit;

    }
}
