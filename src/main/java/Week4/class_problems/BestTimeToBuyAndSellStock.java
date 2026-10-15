package main.java.Week4.class_problems;

public class BestTimeToBuyAndSellStock {

    static int maxProfit(int[] prices) {
        int lowestPrice = Integer.MAX_VALUE;
        int bestProfit = 0;
        for (int price : prices) {
            if (price < lowestPrice) {
                lowestPrice = price;
            }
            bestProfit = Math.max(bestProfit, price - lowestPrice);
        }
        return bestProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
