/*
Raniery Mendes
CSC201 Fall 2020
Programming Assignment 2
September 28, 2020
 */

//This program performs the evaluation of postfix expressions through binary trees, that is, it works with expression trees

//Input is read from text file called "exprs.txt"


import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.Stack;


public class Main {



    public static void  processExpr (String expr){

        //Stack that will store the binary trees
        Stack<Tree> stack = new Stack<>();

        //instance of binary tree that will be used to call the methods from Tree class
        Tree binaryTree = new Tree();


        //gets the expression which is passed as parameter (string)  and remove the blank spaces, storing it into an array
        String whole_expression [] = expr.split(" ");


        //iterate through the entire mathematical expression to build the binary tree that represent this postfix expression
        for (int i = 0; i < whole_expression.length; i++ ) {


            if(whole_expression[i].isEmpty()){
                //do nothing and dismiss value
            }

            //create tree and store it into the stack of trees
            else{

                //check if the string contains an operator
                if(whole_expression[i].equals( "+") || whole_expression[i].equals( "-") || whole_expression[i].equals( "/") || whole_expression[i].equals( "*" )){

                    //if and else(if) statements to find out if the element from whole_expression array is an operator


                    // creates a new tree that has as parent the addition operator
                    if(whole_expression[i].equals("+")){

                        //get the last two trees inserted at the top of the stack
                        Tree right_value = stack.pop();
                        Tree left_value = stack.pop();

                        //creates a new binary tree that will assigned as parent to the binary trees just popped
                        Tree newOperator = new Tree("+");
                        newOperator.insertNodeToTreeL(left_value);
                        newOperator.insertNodeToTreeR(right_value);


                        //push the new tree into the stack
                        stack.push(newOperator);

                    }


                    // creates a new tree that has as parent the subtraction operator
                    else if(whole_expression[i].equals("-")){

                        //get the last two trees inserted at the top of the stack
                        Tree right_value = stack.pop();
                        Tree left_value = stack.pop();

                        //create a new tree that will point two the right and left trees just popped
                        Tree newOperator = new Tree("-");
                        newOperator.insertNodeToTreeL(left_value);
                        newOperator.insertNodeToTreeR(right_value);


                        //push the new tree into the stack
                        stack.push(newOperator);



                    }

                    // creates a new tree that has as parent the division operator
                    else if(whole_expression[i].equals("/")){

                        //get the last two trees inserted at the top of the stack
                        Tree right_value = stack.pop();
                        Tree left_value = stack.pop();

                        //create a new tree that will point two the right and left trees just popped
                        Tree newOperator = new Tree("/");
                        newOperator.insertNodeToTreeL(left_value);
                        newOperator.insertNodeToTreeR(right_value);


                        //push the new tree into the stack
                        stack.push(newOperator);

                    }

                    else{

                        //get the last two trees inserted at the top of the stack
                        Tree right_value = stack.pop();
                        Tree left_value = stack.pop();

                        //create a new tree that will point two the right and left trees just popped
                        Tree newOperator = new Tree("*");
                        newOperator.insertNodeToTreeL(left_value);
                        newOperator.insertNodeToTreeR(right_value);


                        //push the new tree into the stack
                        stack.push(newOperator);

                    }



                }

                //the value in the string is a number(operand) so create a new tree, storing the value into it

                else{

                    //create a tree and store the value
                    Tree operand = new Tree(whole_expression[i]);
                    stack.push(operand);
                }



            }



        }

        //Tree instance that get the result of the whole expression, which is the last value stored in the stack
        //It will be passed as parameter in method calls made by the binaryTree instance of Tree class
        Tree expressionInTree= stack.pop();

        //print the expression tree through preOrder
        System.out.print("Printing expression using preOrder traversal:  ");
        binaryTree.preOrder(expressionInTree.root);
        System.out.println(" ");

        //print the expression tree through inOrder
        System.out.print("Printing expression using PostOrder traversal:  ");
        binaryTree.postOrder(expressionInTree.root);
        System.out.println(" ");

        //print the expression tree through postOrder
        System.out.print("Printing expression using inOrder traversal:  ");
        binaryTree.inOrder(expressionInTree.root);
        System.out.print("= ");
        //print the result of the expression with 2 decimal places
        System.out.println(( String.format("%.2f", binaryTree.eval(expressionInTree.root))));


    }

    public static void main(String[] args) throws FileNotFoundException {

        //open the file that contains the postfix expressions
        File exprToRead = new File("src/exprs.txt");

        //scanner to read file that contains expressions
        Scanner reader = new Scanner(exprToRead);


        //read the whole text file while there are expression in it
        while(reader.hasNextLine()){

            String express = reader.nextLine();


            //show to to the user the postfix expression that the program will work on
            System.out.println("PostFix expression: " + express + "\n");


            //call the processExpr to build Tree and carry out actions required (transverse and evaluate)
            processExpr(express);

            System.out.println("\n");




        }

    }
}
