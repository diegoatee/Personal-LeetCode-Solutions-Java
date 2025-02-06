/*
Idea: 2-pointer system, ignoring whitespace

1. We start with two integers (left & right) that represent the indices of string s from the left and right.

2. Once we have the corresponding characters from both index variables, we need to ensure two things.
    2.1) The characters should be alphanumeric.
    2.2) The characters must be either both uppercase, or both lowercase (In this case, I will be comparing lowercase characters)

3. If the left index corresponds to a non-alphanumeric character, then increment it, making sure that the index does not exceed the right index. Similarly, if the right index corresponds to a non-alphanumeric character, then decrement it, making sure that the left index is still less than the right index.

4. Compare both lowercase alphanumeric characters
    4.1) If they do not match, return false
    4.2) Else, then increment left & decrement right to compare the next pair of characters until the loop condition breaks (when left > right)

5. Return true at the loop's end, since no mismatch was found

Time Complexity: O(N), as we only iterate half of the String's length times
*/

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char l;
        char r;

        while (left < right) {
            //Convert left & right characters to lowercase
            l = s.charAt(left);
            r = s.charAt(right);
            if (l >= 'A' && l <= 'Z') {
                l = Character.toLowerCase(l);
            }
            if (r >= 'A' && r <= 'Z') {
                r = Character.toLowerCase(r);
            }

            //Increment the left pointer while the character is not alphanumeric
            while (!((l >= 'a' && l <= 'z') || (l >= '0' && l <= '9')) && (left < right)) {
                left = left + 1;
                l = s.charAt(left);

                if (l >= 'A' && l <= 'Z') {
                    l = Character.toLowerCase(l);
                }
            }

            //Decrement the right pointer while the character is not alphanumeric
            while (!((r >= 'a' && r <= 'z') || (r >= '0' && r <= '9')) && (left < right)) {
                right = right - 1;
                r = s.charAt(right);

                if (r >= 'A' && r <= 'Z') {
                    r = Character.toLowerCase(r);
                }
            }
            
            
            if (l != r) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
