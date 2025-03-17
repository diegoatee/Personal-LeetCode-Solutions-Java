class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //Map the character frequencies of s1
        int[] freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            freq[ch - 'a']++;
        }

        //Use 2-pointer window to check for permutations of s1 in s2
        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            //"Use" the next character in s2
            char nextCh = s2.charAt(right);
            freq[nextCh - 'a']--;

            //Check if the permutation is invalid
            if (freq[nextCh - 'a'] < 0) {
                //Update pointers
                while (left <= right) {
                    //Stop when left goes one past the char that has negative frequency
                    int leftFreq = freq[s2.charAt(left) - 'a'];

                    if (leftFreq < 0) {
                        freq[s2.charAt(left) - 'a']++;
                        left++;
                        break;
                    }

                    freq[s2.charAt(left) - 'a']++;
                    left++;
                }
            }

            //Ensure that the window is always <= s1.length
            int length = right - left + 1;
            if (length < s1.length()) {
                right++;
            }
            else if (length == s1.length()) {
                //Check if the frequency array is all 0s
                boolean validWindow = true;
                for (int i = 0; i < freq.length; i++) {
                    if (freq[i] > 0) {
                        validWindow = false;
                    }
                }
                if (validWindow) {
                    return validWindow;
                }
                right++;
                freq[s2.charAt(left) - 'a']++;
                left++;
            }
        }

        return false;
    }
}
