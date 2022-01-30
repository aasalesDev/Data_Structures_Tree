package datastructurestrees;

import datastructurestrees.model.Object;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n\n========================================");

        BinaryTree<Object> binaryTree = new BinaryTree<>();
        binaryTree.insert(new Object(13));
        binaryTree.insert(new Object(10));
        binaryTree.insert(new Object(25));
        binaryTree.insert(new Object(2));
        binaryTree.insert(new Object(12));
        binaryTree.insert(new Object(20));
        binaryTree.insert(new Object(31));
        binaryTree.insert(new Object(29));
        binaryTree.insert(new Object(32));

        binaryTree.printPreOrder();
        binaryTree.printInOrder();
        binaryTree.printPostOrder();
        System.out.println("\n\n========================================");
    }
}
