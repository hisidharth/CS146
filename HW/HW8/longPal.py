class longPal:
    def longestPalindrome(self, s: str) -> int:
        freq = {}
        
        for char in s:
            freq[char] = freq.get(char, 0) + 1
        
        len = 0
        oddF = False
        
        for freq in freq.values():
            if freq % 2 == 0:
                len += freq
            else:
                len += freq - 1
                oddF = True
        
        if oddF:
            len += 1
        
        return len


longPal = longPal()
s1 = "abccccdd"
s2 = "speediskey"
print(s1)
print(longPal.longestPalindrome(s1))
print(s2)
print(longPal.longestPalindrome(s2))
