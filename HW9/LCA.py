
class LCA:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return None
        if root == p or root == q:
            return root
        
        rightTest = self.lowestCommonAncestor(root.right, p, q)
        leftTest = self.lowestCommonAncestor(root.left, p, q)

        if rightTest and leftTest:
            return root
        else:
            return rightTest or leftTest

class TreeNode(object):

     def __init__(self, val=0, left=None, right=None):

         self.val = val

         self.left = left

         self.right = right

LCA = LCA()
root = TreeNode(4)
root.right = TreeNode(8)
root.left = TreeNode(3)
root.left.left = TreeNode(1)
root.right.left = TreeNode(5)
root.right.right = TreeNode(9)

result = LCA.lowestCommonAncestor(root, root.left, root.left.left)

print(result.val)