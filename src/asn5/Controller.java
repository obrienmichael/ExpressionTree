package asn5;

import java.util.Scanner;

/**
 *Tried best as possible to create a more flexable program that
 *took in user input as opposed to hard coding.
 *For some reason it is only recognizing the user's first operator and
 *two succeeding numbers, anything beyond that is not read properly
 */


/**
 * Controller contains main method for expression tree
 * Requires input to be in prefix notation
 * Requires input to have white space inbetween chars
 * outputs evaluated result, expression in prefix, postfix, & infix
 */
public class Controller
{

    public static void main(String[] args)
    {
        ExpressionTree et = new ExpressionTree();

        System.out.println("Expression Tree Test");

        System.out.println("\nEnter equation in prefix form");

        et.buildTree(new Scanner(System.in));

        System.out.println("\n\nSpongebob (Evaluate): "+ et.evaluate());

        System.out.print("\n\nPatrick (PreFix): ");
        et.preOrder();

        System.out.print("\n\nSquidward (PostFix): ");
        et.postOrder();

        System.out.print("\n\nMr. Krabs (InFix): ");
        et.inOrder();
        System.out.println(" ");
    }

}