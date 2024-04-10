from collections import deque
from typing import Optional, List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        returnList = []

        if root is None:
            return returnList
        
        q = deque()
        q.append(root)

        while q:
            visited = []

            size = len(q)

            for _ in range(size):
                temp = q.popleft()
                visited.append(temp.val)
                if temp.left is not None:
                    q.append(temp.left)
                if temp.right is not None:
                    q.append(temp.right)

            returnList.append(visited)

        return returnList
    

solution = Solution()

root = TreeNode(4)
root.left = TreeNode(3)
root.right = TreeNode(8)
root.left.left = TreeNode(1)
root.right.left = TreeNode(5)
root.right.right = TreeNode(9)

result = solution.levelOrder(root)

for level in result:
    print(level, end=" ")
