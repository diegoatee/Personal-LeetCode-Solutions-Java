/*
Idea:
If the two strings are not the same length, then simply return false.

Else, then create an array of character frequencies of s, which would be filled after iterating over s.

Then iterate over t, subtracting its characters from the array.

If the array is only fileld with 0's by the end of both iterations, then return true. Else return false.
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];

        if (s.length() != t.length()) {
            return false;
        }

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            freq[ch - 'a']--;
        }

        for (int i : freq) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
