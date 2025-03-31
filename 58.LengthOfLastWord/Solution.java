class Solution {
    public int lengthOfLastWord(String s) {
        int curLength = 0;
        int i = s.length() - 1;
        while (s.charAt(i) == ' ') {
            i--;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            curLength++;
            i--;
        }

        return curLength;
    }
}
