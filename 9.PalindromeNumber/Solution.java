/*
Idea:
Build a "reverse" integer from input x by utilizing the division (/)
and the modulo (%) operator.

If the reverse is equal to x, then return true.
Time complexity: O(N)
*/

class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        int curDigit;
        int reversed = 0;

        if (x < 0) { //Due to the preceding "-" symbol
            return false;
        }

        while (temp != 0) {
            curDigit = temp % 10;   //Get rightmost digit
            temp = temp / 10;       //Shift right

            reversed = reversed * 10;   //Shift left
            reversed = reversed + curDigit; //Add digit
        }

        if (reversed == x) {
            return true;
        }
        else {
            return false;
        }
    }
}
