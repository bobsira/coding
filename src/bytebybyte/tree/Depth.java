package bytebybyte.tree;

public class Depth {
    private static int depth(Node root){
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left,right) + 1;
    }
}
