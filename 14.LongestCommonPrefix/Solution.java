/*
Idea:
First, sort the array of strings alphabetically. This allows us to only have to compare the first and last Strings in the sorted array because these two strings differ the most by characters.

Then, iterate over both strings to count the number of matching characters starting from the left. As soon as the two characters differ, or when we hit the end of either String, then we return the substring of either string from the beginning up to the length of the common prefix.

Time complexity: O(NlogN) because of the use of Arrays.sort() method
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        //First, sort the array alphabetically so we can compare the first and last string
        Arrays.sort(strs);
        String s1 = strs[0];
        int i = 0, subLength = 0;
        String s2 = strs[strs.length - 1];

        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) == s2.charAt(i)) {
                subLength++;
                i++;
            }
            else {
                break;
            }
        }

        return s1.substring(0, subLength);
    }
}
