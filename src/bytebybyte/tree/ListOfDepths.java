package bytebybyte.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListOfDepths {

    private static ArrayList<LinkedList<Node>> createLevelLinkedList(Node root){
        ArrayList<LinkedList<Node>> arrayList = new ArrayList<>();
        LinkedList<Node> currentLinkedList = new LinkedList<>();
        if (root != null) currentLinkedList.add(root);
        while (!currentLinkedList.isEmpty()){
            arrayList.add(currentLinkedList);
            LinkedList<Node> parentLinkedList = currentLinkedList;
            currentLinkedList = new LinkedList<Node>();
            for(Node parent: parentLinkedList){
                if (parent.left != null) currentLinkedList.add(parent.left);
                if (parent.right != null) currentLinkedList.add(parent.right);
            }
        }
        return arrayList;
    }


    private static ArrayList<LinkedList<Node>> createLevelLinkedListDFS(Node root){
        ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
        createLevelLinkedListDFS(root, lists, 0);
        return lists;
    }
    private static void createLevelLinkedListDFS(Node root, ArrayList<LinkedList<Node>> lists, int level){
        if (root == null) return;
        LinkedList<Node> list = null;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedListDFS(root.left, lists, level + 1);
        createLevelLinkedListDFS(root.right, lists, level + 1);
    }

    private static void printResult(ArrayList<LinkedList<Node>> result){
        int depth = 0;
        for(LinkedList<Node> entry : result) {
            Iterator<Node> i = entry.listIterator();
            System.out.print("Link list at depth " + depth + ":");
            while(i.hasNext()){
                System.out.print(" " + ((Node)i.next()).data);
            }
            System.out.println();
            depth++;
        }
    }
}
