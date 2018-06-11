package notation;

import java.util.Scanner;

/**
 * Class name-Demo
 * 
 * @version 1.0
 * @author Jaya Bapna
 */
public class Demo {
	public static void main(String args[]) {
		InfixToPostfix infixToPostfixInstance = new InfixToPostfix();
		System.out.println("Enter string in infix notation");
		Scanner scan = new Scanner(System.in);
		String infixNotation = scan.next();
		infixToPostfixInstance.takeInput(infixNotation);
	}
}
