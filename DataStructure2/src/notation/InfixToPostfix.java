package notation;

/*
 * Class name- InfixToPostfix
 */
public class InfixToPostfix {
	int top;								 			//Points to the top element in stack.
	char stack[] = new char[25];						//Stores the operator 
	/**
	 * Below functions takes input String
	 * @param infixNotation
	 */
	public void takeInput(String infixNotation) {
		char[] outputPostfix = new char[infixNotation.length()];   		//Stores the final output String.
		int i, j = 0;
		char ch;
		for( i = 0; i < infixNotation.length(); i++) {
			ch = infixNotation.charAt(i);
			if ( ch == '(' ) {
				push(ch);
			}
			else if (isAlpha(ch)) {
				outputPostfix[j] = ch;
				j++;
			}
			else if (isOperator(ch)) {
				if( stack[top] == 0 || ( precedence(ch) > precedence(stack[top]) ) || stack[top]=='(') { 
		               push(ch); 
		            } 
		         } 
		         else if(precedence(ch) >= precedence(stack[top])) { 
		            outputPostfix[j++]=pop();
		            push(ch);
		         } 
		         else if(ch=='(') { 
		            while((ch = pop())!='(') { 
		               outputPostfix[j++]=ch;
		        } 
			}
		}
		while( top != 0) { 
	         outputPostfix[j++] = pop();
	    } 
	    for(int k = 0; k < infixNotation.length(); k++) {
	    	System.out.println(k);
	         System.out.print(outputPostfix[k]);    
	      }
	}
	
	/**
	 * Below function checks precedence of operator
	 * @param ch
	 */
	int precedence(char ch) { 
	      switch(ch) { 
	         case '-':return 1;
	         case '+':return 1;
	         case '*':return 2;
	         case '/':return 2;
	      } 
	      return 0;
	} 
	
	/**
	 * Below function checks if the character is alphabet or number or not.
	 * @param ch
	 * @return true if character is alphabet or number otherwise returns false
	 */
	boolean isAlpha(char ch) {
		if ( (ch >= 'a' && ch <= 'z') || (ch >='A' && ch <='Z') || (ch >= '0' && ch <='9') ) {
			return true;
		}
		return false;
	}
	
	/**
	 * Below function checks if the character is an operator or not.
	 * @param ch
	 * @return true if operator otherwise false
	 */
	boolean isOperator(char ch) {
		if ( ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' ) {
			return true;
		}
		return false;
	}
	
	/**
	 * Below functions adds character to stack.
	 * @param ch
	 */
	public void push (char ch) {
		top++;
		stack[top] = ch;
	}
	
	/**
	 * Below function pops element from stack.
	 * @return popped character
	 */
	public char pop() {
		char ch;
		ch = stack[top];
		top--;
		return ch;
	}
}
