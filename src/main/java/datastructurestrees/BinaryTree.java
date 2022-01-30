package datastructurestrees;

public class BinaryTree<T extends Comparable<T>> {

    private BinaryNode<T> root;

    //Every time a Binary Tree is instantiated, its root will be se to null
    public BinaryTree(){
        this.root = null;
    }

    public void insert(T content){
        BinaryNode<T> newNode = new BinaryNode<T>(content);
        this.root = insert(root, newNode);
    }

    // This is a recursive method
    private BinaryNode<T> insert(BinaryNode<T> currentNode, BinaryNode<T> newNode){
        if (currentNode == null){
            return newNode;
        } else if (newNode.getContent().compareTo(currentNode.getContent()) < 0){
            currentNode.setLeftNode(insert(currentNode.getLeftNode(), newNode));
        } else {
            currentNode.setRightNode(insert(currentNode.getRightNode(), newNode));
        }
        return currentNode;
    }

    public void printInOrder(){
        System.out.println("\n\n==========In Order===============");
        printInOrder(this.root);
    }

    private void printInOrder(BinaryNode<T> currentNode){
        if (currentNode != null){
            printInOrder(currentNode.getLeftNode());
            System.out.print(currentNode.getContent() + ", ");
            printInOrder(currentNode.getRightNode());
        }
    }

    public void printPostOrder(){
        System.out.println("\n\n==========Post Order===============");
        printPostOrder(this.root);
    }

    private void printPostOrder(BinaryNode<T> currentNode){
        if (currentNode != null){
            printPostOrder(currentNode.getLeftNode());
            printPostOrder(currentNode.getRightNode());
            System.out.print(currentNode.getContent() + ", ");
        }
    }

    public void printPreOrder(){
        System.out.println("\n\n==========Pre Order===============");
        printPreOrder(this.root);
    }

    private void printPreOrder(BinaryNode<T> currentNode){
        if (currentNode != null){
            System.out.print(currentNode.getContent() + ", ");
            printPreOrder(currentNode.getLeftNode());
            printPreOrder(currentNode.getRightNode());
        }
    }

    public void remove(T content){
        try {
            BinaryNode<T> currentNode = this.root;
            BinaryNode<T> parentNode = null;
            BinaryNode<T> childNode = null;
            BinaryNode<T> temporaryNode = null;
            while (currentNode != null && currentNode.getContent().equals(content)){
                parentNode = currentNode;
                if(content.compareTo(currentNode.getContent()) < 0){
                    currentNode = currentNode.getLeftNode();
                }else{
                    currentNode = currentNode.getRightNode();
                }
            }
            if (currentNode == null){
                System.out.println("Content not found [...inside the try block]");
            }
            if (parentNode == null){
                if (currentNode.getRightNode() == null){
                    this.root = currentNode.getLeftNode();
                } else if (currentNode.getLeftNode() == null){
                    this.root = currentNode.getRightNode();
                } else {
                    for (temporaryNode = currentNode, childNode = currentNode.getLeftNode();
                         childNode.getRightNode() != null;
                        temporaryNode = childNode, childNode.getLeftNode()){
                            if (childNode != currentNode.getLeftNode()){
                                temporaryNode.setRightNode(childNode.getLeftNode());
                                childNode.setLeftNode(root.getLeftNode());
                            }
                        }
                    childNode.setRightNode(root.getRightNode());
                    root = childNode;
                }
            } else if (currentNode.getRightNode() == null) {
                if (parentNode.getLeftNode() == currentNode){
                    parentNode.setLeftNode(currentNode.getLeftNode());
                } else {
                    parentNode.setRightNode(currentNode.getLeftNode());
                }
            } else if (currentNode.getLeftNode() == null){
                if (parentNode.getLeftNode() == currentNode){
                    parentNode.setLeftNode(currentNode.getRightNode());
                } else {
                    parentNode.setRightNode(currentNode.getRightNode());
                }
            } else {
                for (temporaryNode = currentNode, childNode = currentNode.getLeftNode(); childNode.getRightNode() != null;
                temporaryNode = childNode, childNode.getRightNode()){
                    if (childNode != currentNode.getLeftNode()){
                        temporaryNode.setRightNode(childNode.getLeftNode());
                        childNode.setLeftNode(currentNode.getLeftNode());
                    }
                    childNode.setRightNode(childNode.getRightNode());
                    if (parentNode.getLeftNode() == currentNode){
                        parentNode.setLeftNode(childNode);
                    } else {
                        parentNode.setRightNode(childNode);
                    }
                }
            }
        } catch (NullPointerException e){
            System.out.println("Content not found [...inside the catch block]");
        }
    }
}
