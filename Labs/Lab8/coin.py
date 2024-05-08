from typing import List

class coin:
    def coinChange(self, coins: List[int], amount: int) -> int:
        memo = [-1] * (amount + 1)
        return self.coinChangeHelper(coins, amount, memo)
    
    def coinChangeHelper(self, coins: List[int], amount: int, memo: List[int]) -> int:
        if amount == 0:

            return 0
        
        if memo[amount] != -1:
            return memo[amount]
        


        minCoins = float('inf')
        
        for coin in coins:
            if amount >= coin:
                remaining = amount - coin
                
                needed = self.coinChangeHelper(coins, remaining, memo)

                if needed != -1:
                    
                    minCoins = min(minCoins, needed + 1)
        
        if minCoins == float('inf'):
           
            memo[amount] = -1
        
        
        else:
            memo[amount] = minCoins
        return memo[amount]

coin = coin()
coins = [2, 5]
amount = 3
print(coin.coinChange(coins, amount))
