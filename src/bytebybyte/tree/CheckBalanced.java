package bytebybyte.tree;

public class CheckBalanced {

    private static boolean isBalanceI(Node root){
        return checkHeight(root) != Integer.MIN_VALUE;
    }
    private static int checkHeight(Node root){
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiffeence = leftHeight - rightHeight;

        if (Math.abs(heightDiffeence) > 1)
            return Integer.MIN_VALUE;
        else
            return Math.max(leftHeight,rightHeight) + 1;
    }

    private static int height(Node root){
        if (root == null) return -1; //base case
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left,right) + 1;
    }
    private static boolean isBalanced(Node root){
        if (root == null) return true; //base case

        int left = height(root.left);
        int right = height(root.right);
        int heightDifference = left - right;

        if (Math.abs(heightDifference) > 1)
            return false;
        else
            return isBalanced(root.left) && isBalanced(root.right); //recurse
    }
}
