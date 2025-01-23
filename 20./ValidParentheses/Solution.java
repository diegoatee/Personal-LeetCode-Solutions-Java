/*
Idea:
Using a stack, iterate over the String. If the current character is a left parenthesis, push onto the stack. If it is a right parenthesis, then return false if the stack is empty or if the left parenthesis popped from the top of the stack does not match the right parenthesis. If it matches, simply continue until the end of the String.

If the stack is not empty by the end of the iteration, then there are left over left-parentheses, which should return false. Else, return true.

Time complexity: O(N), since we iterate over the entire length of the String
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        //A valid String must have an even number of parentheses
        if (s.length() % 2 != 0) {
            return false;
        }

        //Iterate through String s, pushing left parentheses onto the stack

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);

            //push left parentheses
            if (curChar == '(' || curChar == '{' || curChar == '[') {
                stack.push(curChar);
            }
            else {  //If curChar is a right parentheses
                char leftP;
                if (!stack.empty()) {
                    leftP = stack.pop();
                }
                else {
                    return false;
                }

                //Compare curChar (rightP) and see if it matches the leftP
                if (curChar == ')' && leftP != '(') {
                    return false;
                }
                else if (curChar == '}' && leftP != '{') {
                    return false;
                }
                else if (curChar == ']' && leftP != '[') {
                    return false;
                }
            }
        }

        //The stack must be empty
        if (!stack.empty()) {
            return false;
        }

        return true;
    }
}
