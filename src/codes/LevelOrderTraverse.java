package codes;

import java.util.*;
import java.lang.*;
import java.io.*;

public class LevelOrderTraverse {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static void printLevelOrder(Node root){

        if( root == null) return;

        Queue<Node>  queue = new LinkedList<Node>();

        queue.add(root);

        while (true){

            int nodeCount = queue.size();

            if (nodeCount == 0) break;

            while (nodeCount > 0 ) {

                Node node = queue.peek();

                System.out.print(node.data + "");

                queue.remove();

                if (node.left != null) queue.add(node.left);

                if (node.right != null) queue.add(node.right);

                nodeCount--;
            }
            System.out.println();
        }
    }

    static void topView(Node root){

        class QueueObject {
            private Node node;
            private int horizontalDistance;
            private QueueObject(Node node, int horizontalDistance){
                this.node = node;
                this.horizontalDistance = horizontalDistance;
            }
        }

        Queue<QueueObject> queue = new LinkedList<QueueObject>();
        Map<Integer,Node> topViewMap = new TreeMap<Integer, Node>();

        if (root == null) return;
        else queue.add(new QueueObject(root,0));


        while (!queue.isEmpty()){

            QueueObject tempNode = queue.poll();

            if(!topViewMap.containsKey(tempNode.horizontalDistance)){
                topViewMap.put(tempNode.horizontalDistance,tempNode.node);
            }

            if (tempNode.node.left != null){
                queue.add(new QueueObject(tempNode.node.left, tempNode.horizontalDistance -1));
            }

            if (tempNode.node.right != null){
                queue.add(new QueueObject(tempNode.node.right, tempNode.horizontalDistance +1));
            }
        }

        for (Map.Entry<Integer,Node> entry : topViewMap.entrySet()){
            System.out.print(entry.getValue().data + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        printLevelOrder(root);
    }
}
