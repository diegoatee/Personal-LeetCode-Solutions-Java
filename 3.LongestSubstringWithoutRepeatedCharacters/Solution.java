/*
Idea: Keep track of duplicates and indices using HashMap

Key variables/structures
    HashMap map: Keeps track of characters and their indices.
    int subStringLength: Holds our current substring length. Initially 0.
    int result: Holds maximum substring length. Initially 0.
    int substringStartIndex: Holds the index of the first element in our current substring.

How to check if a char is a duplicate? 
    First check if the map already contains that character.
        If yes, then also check if that character's map index is within the bounds of the current substring (map.get(ch) >= substringStartIndex)

What to do after that if a duplicate is found?
    We would have to update our substringLength variable, setting it equal to the (current index) - (map index) - 1.
    This way, the substringLength is now equal to the # of characters in between these duplicates.

    Also, since we now have a new substring, set the substringStartIndex = map.get(ch) + 1, which corresponds to the index of
    the character directly after our duplicate.

After this, for all characters (whether unique or duplicate)...
    Increment substringLength
    Update result, if substringLength > result
    add the character and its index to the map (for duplicates, this would simply replace the entry already in the map)


Time Complexity: O(N), we only iterate once over s
Space Complexity: O(N) because of our HashMap
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        // This map will be used to
        //1. Keep track of unique characters in s
        //2. Store indices of each character
        HashMap<Character, Integer> map = new HashMap<>();

        int result = 0;
        int curLength = 0;
        int substringStartIndex = 0;

        //Iterate over s
        for (int i = 0; i < s.length(); i++) {
            //Get the character
            char ch = s.charAt(i);

            //Check if it's in the map
            if (map.containsKey(ch) && map.get(ch) >= substringStartIndex) {
                int duplicateIndex = map.get(ch);

                //Update curLength to be equal to the # of unique characters in between these 2 duplicates
                curLength = i - duplicateIndex - 1;

                //Keep track of the starting index of this new substring
                substringStartIndex = duplicateIndex + 1;
            }

            //Update the index of duplicate character (add to map)
            map.put(ch, i);

            //Increment curLength
            curLength++;

            //If curLength is greater than result, update result
            if (curLength > result) {
                result = curLength;
            }
        }

        return result;
    }
}
