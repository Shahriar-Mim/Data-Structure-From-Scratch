package stack;

import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args) {
        String expression = "([{}])";
        // Function call
        if ( isBalanced(expression) )
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }

    /**
     * Returns True if the parenthesis in provided expression is balanced.
     * We will only push() left brackets in the stack. Whenever we see right bracket
     * we wil do pop() operation and try to match the group (), {} , []
     * any other characters than brackets will not be added in the stack or for any
     * push or pop operations.
     * @param expression
     * @return An Empty stack after successful pop operations means
     *         our expression has balanced parenthesis
     */
    static boolean isBalanced(String expression){ // 3 cases in any expression
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<expression.length(); i++){
            // CASE I: Left Brackets 
            // if there is left brackets we will add in the stack
            char c = expression.charAt(i);
            if(c =='(' || c =='{' || c =='[' ){
                // we will only add the left brackets in the stack
                stack.push(c);
                continue;
            }
            // CASE II :what if an expression do not have any left brackets at first
            // so the stack will be empty 
            if(stack.isEmpty()){
                return false; 
            }
            // CASE III: Have to check for Right Brackets only in expression,
            // we will only pop() then
            char popped;
            if(c==')'){
                // only pop() because we have found a right bracket in expression
                popped = stack.pop();
                // we will only check with brackets, if brackets group doesnt match
                // we will return false. Any other in between characters than brackets will
                // just go for the iteration in for loop.
                if(popped == '{' || popped == '['){
                    return false;
                }
            }
            else if(c=='}'){
                // only pop() because we have found a right bracket in expression
                popped = stack.pop();
                // we will only check with brackets, if brackets group doesnt match
                // we will return false. Any other in between characters than brackets will
                // just go for the iteration in for loop.
                if(popped == '(' || popped == '['){
                    return false;
                }
            }
           else if(c==']'){
                // only pop() because we have found a right bracket in expression
                popped = stack.pop();
                // we will only check with brackets, if brackets group doesnt match
                // we will return false. Any other in between characters than brackets will
                // just go for the iteration in for loop.
                if(popped == '{' || popped == '('){
                    return false;
                }
            }
        }
        // out of the loop stack is empty. that means we have balanced parenthesis.
        // empty string will be valid
        if(stack.empty()){
            return true;
        }
        return false;
    }
}
