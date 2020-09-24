import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.Stack;


public class Main {




    public static int  processExpr (String expr){

        Stack<Tree> stack = new Stack<>();
        Tree binaryTree = new Tree();

        int result = 0;


        String whole_expression [] = expr.split(" ");

        for (int i = 0; i < whole_expression.length; i++ ) {




            if(whole_expression[i].isEmpty()){
                //do nothing and dismiss value
            }

            //store values into the stack
            else{

                //check if the string contains an operator
                if(whole_expression[i].equals( "+") || whole_expression[i].equals( "-") || whole_expression[i].equals( "/") || whole_expression[i].equals( "*" )){

                    //if and else(if) statements to find out which operator is and carry out the math operation


                    if(whole_expression[i].equals("+")){

                        //get the last two values inserted at the top of the stack
                        Tree right_value = stack.pop();
                        Tree left_value = stack.pop();

                        Tree newOperator = new Tree("+");
                        newOperator.insertNodeToTreeL(left_value);
                        newOperator.insertNodeToTreeR(right_value);


                        //using the values retrieved from the stack, divide and push the result into the stack
                        stack.push(newOperator);


                    }

                    else if(whole_expression[i].equals("-")){

                        Tree right_value = stack.pop();
                        Tree left_value = stack.pop();

                        Tree newOperator = new Tree("-");
                        newOperator.insertNodeToTreeL(left_value);
                        newOperator.insertNodeToTreeR(right_value);


                        //using the values retrieved from the stack, divide and push the result into the stack
                        stack.push(newOperator);



                    }

                    else if(whole_expression[i].equals("/")){

                        Tree right_value = stack.pop();
                        Tree left_value = stack.pop();

                        Tree newOperator = new Tree("/");
                        newOperator.insertNodeToTreeL(left_value);
                        newOperator.insertNodeToTreeR(right_value);


                        //using the values retrieved from the stack, divide and push the result into the stack
                        stack.push(newOperator);

                    }

                    else{

                        //get the last two values inserted at the top of the stack
                        Tree right_value = stack.pop();
                        Tree left_value = stack.pop();

                        Tree newOperator = new Tree("*");
                        newOperator.insertNodeToTreeL(left_value);
                        newOperator.insertNodeToTreeR(right_value);


                        //using the values retrieved from the stack, do the multiplication operation and push the result into the stack
                        stack.push(newOperator);

                    }



                }

                //the value in the string is a number
                else{

                    //convert the number that is in string format into a double variable
                    String new_Value = whole_expression[i];

                    //push this double at the top of the stack
                    Tree node = new Tree(new_Value);
                    stack.push(node);
                }



            }



        }

        //get the result of the whole expression, which is the last value in the stack
        Tree expressionInTree= stack.pop();

        System.out.print("Printing expression in preOrder:  ");
        binaryTree.preOrder(expressionInTree.root);
        System.out.println(" ");

        System.out.print("Printing expression in PostOrder:  ");
        binaryTree.postOrder(expressionInTree.root);
        System.out.println(" ");

        System.out.print("Printing expression in Order:  ");
        binaryTree.inOrder(expressionInTree.root);
        //System.out.println(binaryTree.evalExpr(expressionInTree.root));










        //return result to main class


        return result;

    }

    public static void main(String[] args) throws FileNotFoundException {

        File exprToRead = new File("src/exprs.txt");

        Scanner reader = new Scanner(exprToRead);


        while(reader.hasNextLine()){

            String express = reader.nextLine();

            System.out.println("PostFix expression: " + express);

            processExpr(express);

            System.out.println("\n");



            //System.out.println(processExpr(express));


        }

    }
}
