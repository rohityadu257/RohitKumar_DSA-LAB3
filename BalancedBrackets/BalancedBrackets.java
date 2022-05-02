package practice;

import java.util.Stack;

public class BalancedBrackets {
	 
    //  check if Brackets are Balanced
    static boolean areBracketsBalanced(String expr)
    {
       
        Stack <Character> stack = new Stack<>();
 
        for (int i = 0; i < expr.length(); i++)
        {
            char b = expr.charAt(i);
 
            if (b == '(' || b == '[' || b == '{')
            {
                // Push the element in the stack
                stack.push(b);
                continue;
            }
 
            if (stack.isEmpty())
                return false;
            
            
            char Bracket;
            switch (b) {
            case ')':
            	Bracket = stack.pop();
                if (Bracket == '{' || Bracket == '[')
                    return false;
                break;
 
            case '}':
            	Bracket = stack.pop();
                if (Bracket == '(' || Bracket == '[')
                    return false;
                break;
 
            case ']':
            	Bracket = stack.pop();
                if (Bracket == '(' || Bracket == '{')
                    return false;
                break;
            }
        }
 
        return (stack.isEmpty());
    }
 
    public static void main(String[] args)
    {
        String expr = "([[{}]])";
 
        // Function
        if (areBracketsBalanced(expr))
            System.out.println("The Brackets inserted are Balanced ");
        else
            System.out.println("The Brackets inserted are Not Balanced ");
    }
}