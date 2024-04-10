package HW.HW9;


public class LCA {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return null;
        }
        
        if( root == p || root == q){
            return root;

        }

        TreeNode leftTest = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTest = lowestCommonAncestor(root.right, p, q);

        if(!(rightTest == null) && !(leftTest == null)){
            return root;
        }

        else{

            if(rightTest == null){
                return leftTest;
            }
            return rightTest;
        }
    

    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        
        root.right.left = new TreeNode(5);
     
        root.right.right = new TreeNode(9);

        
        LCA test = new LCA();

        TreeNode result = test.lowestCommonAncestor(root, root.left, root.left.left);

        System.out.println(result.val);
        
    }

    

}
