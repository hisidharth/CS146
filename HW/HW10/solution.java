package HW.HW10;
import java.util.*;

public class solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> returnList = new ArrayList<>();
        
        if (root == null)
            return returnList;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            ArrayList<Integer> visited = new ArrayList<>();

            int size = q.size();


            for (int i = 0; i < size; i++) {

                TreeNode temp = q.poll();

                visited.add(temp.val);

                if (temp.left != null)

                    q.add(temp.left);
                
                if (temp.right != null)

                    q.add(temp.right);
            }
            returnList.add(visited);


        }

        return returnList;


    }

    public static void main(String[] args) {
        
        solution solution = new solution();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);


        List<List<Integer>> result = solution.levelOrder(root);

        for (List<Integer> level : result) {
            System.out.print(level);
            System.out.print(" ");
        }
    
    }


}
