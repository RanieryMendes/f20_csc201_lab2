
public class Tree {

    NodeTree root;



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



        //recursive function to transverse (postOrder) the tree and evaluate (sub)trees
    public double eval(NodeTree result)

    {

        // empty tree

        if (result == null)

            return 0;


        // if both left and right nodes are null ==> node stores a number

        if (result.left == null && result.right == null)

            //base case return the result of the expression
            return Double.parseDouble(result.data);



        // transverse and evaluate left subtree using recursive call
        double l_val = eval(result.left);


        // transverse and evaluate right subtree using recursive call

        double r_val = eval(result.right);


        // Verify the proper operator and carry out mathematical operation


        if (result.data.equals("+"))

            return l_val + r_val;


        if (result.data.equals("-"))

            return l_val - r_val;


        if (result.data.equals("*"))

            return l_val * r_val;

        else {


            return l_val / r_val;
        }
    }

    }

