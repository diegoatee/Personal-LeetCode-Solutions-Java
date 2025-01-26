/*
Idea: Check subsequent substrings
1. in a for loop, iterate over each substring of size "needle" of the "haystack" string.
    1a) To do this, you need 2 index variables, one for the left bound and the other for the right bound of the substring
2. If a substring ever happens to equal the needle, then return the left bound of that substring.
3. Return -1 once the for loop ends since no match was found

Time complexity: O(n * m) where n = length of haystack and m = length of needle (because for every iteration over haystack, we need to check each character of needle with the substring)

Note: we could have easily used haystack.indexOf(needle), but for the purposes of envisioning the algorithmic process, this code fosters more understanding with the same time complexity.
*/

class Solution {
    public int strStr(String haystack, String needle) {
        int left = 0;
        int right = needle.length();

        for(; right <= haystack.length(); left++, right++) {
            if (haystack.substring(left, right).equals(needle)) {
                return left;
            }
        }

        return -1;
    }
}
