/*
Raniery Mendes
CSC201 Fall 2020
Programming Assignment 2
September 28, 2020
 */


//NodeTree class is the class responsible for creating the nodes that will be in the tree
 class NodeTree {


    //data =  operand or operator
    String data;

    //pointers to  left and right nodes
    NodeTree left;
    NodeTree right;



    NodeTree(String oper){

        this.data = oper;
        right =null;
        left=null;

    }


}


//Tree class is responsible for building the expression tree. It implements the NodeTree class to accomplish this goal

public class Tree {

    //Node that will be the root that points to others nodes in the tree
    NodeTree root;


    //constructors that works for both when binary tree is created with and without data being passed as parameter

    Tree() {
        root = null;

    }

    Tree(String info) {

        root = new NodeTree(info);
    }


    //method to insert nodetree into the left side of the tree
    public void insertNodeToTreeL(Tree node) {

        if (node == null) {
            //do nothing
            return;
        }



        if (this.root.left == null) {
            this.root.left = node.root;
        }


    }

    //method to insert nodetree into the right side of the tree
    public void insertNodeToTreeR(Tree node) {

        if (node == null) {
            //do nothing
            return;
        }


        if (this.root.right == null) {
            this.root.right = node.root;
        }


    }


    //method to traversal the tree in preOrder printing the values stored in the tree
    public void preOrder(NodeTree node) {

        if (node != null) {

            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }


    //method to traversal the tree in in order, printing the values stored in the tree
    //this method insert parentheses to make clear the order operations must be evaluated
    public void inOrder(NodeTree node) {


        if (node != null) {

            //if node is an operator prints a paranthese before the operation it encloses
            if((node.data.equals("+") || node.data.equals("/") || node.data.equals("*")  || node.data.equals("-") )){

                System.out.print("( ");
            }

            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);


            //if node is an operator prints a paranthese after the operation to enclose it
            if((node.data.equals("+") || node.data.equals("/") || node.data.equals("*")  || node.data.equals("-") )){
                System.out.print(") ");
            }
        }
    }


    //method to traversal the tree in postOrder, printing the values stored in the tree
    public void postOrder(NodeTree node) {

        if (node != null) {
            postOrder( node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");

        }
    }



    //recursive function to traverse (postOrder) the tree and evaluate (sub)trees
    public double eval(NodeTree node)

    {

        // empty tree

        if (node == null)

            return 0;


        // if both left and right nodes are null ==> node stores a number (a result that comes out of a tree)

        if (node.left == null && node.right == null)

            //base case, there is no more math to be done,  return the result of the expression
            return Double.parseDouble(node.data);



        // double that stores the result obtained through traversal and evaluate left subtree using recursive call of eval method
        double l_val = eval(node.left);

        //double that stores the result obtained through traversal and evaluate right subtree using recursive call of eval method
        double r_val = eval(node.right);


        // Verify the proper operator and carry out the mathematical operation

        if (node.data.equals("+"))

            return l_val + r_val;


        if (node.data.equals("-"))

            return l_val - r_val;


        if (node.data.equals("*"))

            return l_val * r_val;

        // "/" operator
        else {

            return l_val / r_val;
        }
    }

    }

