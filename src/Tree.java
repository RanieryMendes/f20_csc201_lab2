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
            inOrder(result.left);
            System.out.print(result.data + " ");
            inOrder(result.right);
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

    public void printExpressionHelper(NodeTree node) {
        if (node == null) {
            return;
        }

        System.out.print("( ");
        printExpressionHelper(node.left);

        // Why can we just put node here to print the item the node stores?
        System.out.print(node.data + " ");

        printExpressionHelper(node.right);
        System.out.print(") ");
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

    public void tryOrder(NodeTree p) {
        if (p != null) {
            if (p.left != null && p.right != null) {
                System.out.print("(");
            }

            inorder(p.left);
            System.out.print(p.data + " ");
            inorder(p.right);

            if (p.left != null && p.right != null) {
                System.out.print(")");
            }
        }


    }
}
//we need to pop two pointers