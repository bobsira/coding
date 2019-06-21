package bytebybyte.tree;

public class MinimalBST {

    static Node createMinimalBST(int[] array){
        return createMinimalBST(array,0,array.length - 1);
    }

    static Node createMinimalBST(int[] array, int start, int end){
        if (end <  start) return null;
        int middle = (start + end) / 2;
        Node root = new Node(array[middle]);
        root.left = createMinimalBST(array,start,middle -1);
        root.right = createMinimalBST(array,middle + 1, end);
        return root;
    }
}
