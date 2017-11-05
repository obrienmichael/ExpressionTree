
/**
 * Class ExpressionTree creates TreeNode objects, constructs expression tree,
 * evaluates expresssion tree, orders based on prefix, postfix, and infix
 */

package asn5;

import java.util.Scanner;

public class ExpressionTree
{
    /**
     * private class to create the nodes for the expression tree
     *
     */
    private class TreeNode
    {
        private boolean leaf;
        private char op;
        private double value;
        private TreeNode left;
        private TreeNode right;

        //constructor
        private TreeNode (boolean leaf, char op, double value)
        {
            this.leaf = leaf;
            this.op = op;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        // For leaf nodes, show the value; for internal, the operator.
        public String toString()
        {
            if (leaf)
            {
                return Double.toString(value);
            }
            else
            {
                return Character.toString(op);
            }
        }
    }

    TreeNode root = null;

    //method to more easily call tree building method
    public void buildTree (Scanner expression)
    {
        root = build(expression);
    }
    /**
     * takes in user input to build the
     * corresponding binary expression tree.
     * @param  input  The scanner with the expression
     * @return reference to the corresponding binary tree node
     */
    private TreeNode build (Scanner input)
    {
        boolean  leaf;
        String   token;
        double   value;
        TreeNode node;


        leaf = input.hasNextDouble();

        if ( leaf )
        {
            value = input.nextDouble();
            node = new TreeNode (leaf, '\0', value);
        }
        else
        {
            token = input.next();
            node  = new TreeNode (leaf, token.charAt(0), 0.0);
            node.left  = build (input);
            node.right = build (input);
        }
        return node;
    }


    // method to show the expression tree as a postfix expression
    public void postOrder ()
    {
        postOrder ( root );
        System.out.println();
    }

    //Postfix expression by post order traversal
    private void postOrder ( TreeNode node )
    {
        if ( node != null )
        {
            postOrder ( node.left );
            postOrder ( node.right );
            System.out.print ( node + " " );
        }
    }

    //method to show the expression tree as a prefix expression
    public void preOrder ()
    {
        preOrder (root);
        System.out.println();
    }

    //Prefix expression by pre-order traversal
    private void preOrder (TreeNode node)
    {
        while ( node != null )
        {
            System.out.print (node + " ");
            preOrder (node.left);
            node = node.right;
        }
    }


    //method to show the expression tree as a infix expression.
    public void inOrder ()
    {
        inOrder (root);
        System.out.println();
    }

    // infix requires proper parentheses, plus the node
    // in the in-order position.
    private void inOrder (TreeNode node)
    {
        if (node != null)
        {
            if (!node.leaf)
                System.out.print ("( ");        // Pre-order

            inOrder (node.left);
            System.out.print ( node + " " );   // In-order

            inOrder (node.right);
            if (!node.leaf)                 // Post-order
                System.out.print (") ");
        }
    }

    /**
     * Evaluates expression and return  value.
     * @return  the value of the expression tree.
     */
    public double evaluate()
    {  return root == null ? 0.0 : evaluate ( root ) ;  }


    private double evaluate ( TreeNode node )
    {
        double result = 0;

        if ( node.leaf )
        {
            result = node.value;
        }
        else
        {

            double left;
            double right;
            char operator = node.op;

            // Capture the values of the left and right subexpressions
            left  = evaluate (node.left);
            right = evaluate (node.right);

            switch (operator)
            {
                case '-':  result = left - right;  break;
                case '*':  result = left * right;  break;
                case '/':  result = left / right;  break;
                case '+':  result = left + right;  break;
            }
        }
        return result;
    }

}


