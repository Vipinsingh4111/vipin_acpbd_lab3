package com.greatlearning.iitr.dsa.labsession3;

import java.util.HashSet;

public class BinarySearchTree {
	Node root;

    public void insert(int key) {
        root = insertRec(root, key);
    }

    public Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    public void findPair(Node root, int sum, HashSet<Integer> set) {
        if (root == null)
            return;

        findPair(root.left, sum, set);

        if (set.contains(sum - root.key)) {
            System.out.println("Pair found: (" + (sum - root.key) + "," + root.key + ")");
        } else {
            set.add(root.key);
        }

        findPair(root.right, sum, set);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(40);
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(60);
        tree.insert(50);
        tree.insert(70);

        int sum = 130;
        HashSet<Integer> set = new HashSet<Integer>();
        tree.findPair(tree.root, sum, set);
    }
}

class Node {
    int key;
    Node left, right;

    public Node(int key) {
        this.key = key;
        left = right = null;
    }
}
