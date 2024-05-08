package Lab8;

import java.util.Arrays;

public class coin {


    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];


        for (int i = 0; i < memo.length; i++) {

            memo[i] = -1;


        }

        return coinChangeHelper(coins, amount, memo);
    }

    private int coinChangeHelper(int[] coins, int amount, int[] memo){
        int minCoins = Integer.MAX_VALUE;
        
        if(amount == 0){
            return 0;
        }


        if (memo[amount] != -1){

            return memo[amount];
        }
        
        for (int coin : coins) {
            if (amount >= coin) {
                int remaining = amount - coin;
                int needed = coinChangeHelper(coins, remaining, memo);

                if (needed != -1) {


                    minCoins = Math.min(minCoins, needed + 1);
                }
            }
        }
        if(minCoins == Integer.MAX_VALUE){
            memo[amount] = -1;
        }
        else {
            memo[amount] = minCoins;
        }



        return memo[amount];

    }

    public static void main(String[] args) {


        coin solution = new coin();
        int[] coins = {2, 5};
        
        int amount = 6;
        System.out.println(solution.coinChange(coins, amount));
    }
}
