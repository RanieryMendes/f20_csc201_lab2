import org.w3c.dom.Node;

import java.sql.SQLOutput;
import java.util.Stack;

public class Tree {

    NodeTree root;

    static String str;


    Tree() {
        root = null;

    }

    Tree(String info) {

        root = new NodeTree(info);
    }


    public void insertNodeToTreeL(Tree node) {

        if (node == null) {
            return;
        }


        if (this.root.left == null) {
            this.root.left = node.root;
        }


    }

    public void insertNodeToTreeR(Tree node) {

        if (node == null) {
            return;
        }


        if (this.root.right == null) {
            this.root.right = node.root;
        }


    }


    public void preOrder(NodeTree result) {

        if (result != null) {

            System.out.print(result.data + " ");
            preOrder(result.left);
            preOrder(result.right);
        }
    }


    public void inOrder(NodeTree result) {


        if (result != null) {

            //if node is an operator prints a paranthese before
            if((result.data.equals("+") || result.data.equals("/") || result.data.equals("*")  || result.data.equals("-") )){

                System.out.print("( ");
            }
            inOrder(result.left);
            System.out.print(result.data + " ");
            inOrder(result.right);
            if((result.data.equals("+") || result.data.equals("/") || result.data.equals("*")  || result.data.equals("-") )){
                System.out.print(") ");
            }
        }
    }

    public void postOrder(NodeTree result) {

        if (result != null) {
            postOrder(result.left);
            postOrder(result.right);
            System.out.print(result.data + " ");

        }
    }

    public double getResult(NodeTree result) {
        if (result != null) {

            inOrder(result.left);
            System.out.print(result.data + " ");
            inOrder(result.right);

        }

        double exprResult = 0;
        return exprResult;

    }



    public void inorder(NodeTree start) {
        if (!(start.left == null && start == null))
            System.out.print("(");
        if (start.left != null)
            inorder(start.left);
        System.out.print(start.data);
        if (start.right != null)
            inorder(start.right);
        if (!(start.left == null && start.right == null))
            System.out.print(")");
    }


    public double evalExpr (NodeTree node){

        NodeTree tmp;

        double value = Double.parseDouble(node.data);

        if(node != null) {

            double value2 = Double.parseDouble(node.data);
            return value2;


        }
        switch (node.data) {
            case "+":
                return evalExpr(node.left) +evalExpr(node.right);

            case "-":
                return evalExpr(node.left) + evalExpr(node.right);

            case "*":
                return evalExpr(node.left)  * evalExpr(node.right);

            case "/":
                return evalExpr(node.left) / evalExpr(node.right);

            // etc for the other operators
            }
            return value;

        }

    }

//we need to pop two pointers