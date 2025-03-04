/*
Idea: Sliding Window (2-pointers)

Here, a window represents a "left" index of String s, and a "right" index of String s.

Start with a "window" that represents the first character of S. (left == right == 0). For each iteration, we will increment the right pointer.

Get the frequency of the character that appears the most within that window (maxCharFrequency).

If there are enough "k-operations" such that we can fill our window with nothing but the same character (if k >= right - left + 1 - maxCharFrequency), then we can use the size of the window as a valid length we can return. If this length is greater than our current max (initially 0), then update the current maximum length.

Else, then we cannot find a higher size for our k with our current left pointer. Therefore, decrement the frequency of the left pointer character, then increment the left pointer to try and find a larger window size for the new left pointer.

Time Complexity: O(N)
*/

class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] frequency = new int[26];
        int maxCharFreq = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            //Add the new right character to frequency map
            char ch = s.charAt(right);
            frequency[ch - 'A']++;

            //Update the frequency of the most-frequent character in the window, if necessary
            maxCharFreq = Math.max(maxCharFreq, frequency[ch - 'A']);

            //If k < the number of non-max frequency characters (i.e, if we can not completely fill the window with the same character)
            if (k < right - left + 1 - maxCharFreq) {
                //At this point, we can't continue with our current "left" pointer (not possible to find a better output now that we don't have enough k operations)

                //Therefore, we want to increment the left pointer (effectively looking at a new window)

                //Proof for why we don't need to update max now that we have a new window
                frequency[s.charAt(left) - 'A']--;
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
