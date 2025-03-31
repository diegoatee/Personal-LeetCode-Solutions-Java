class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;

        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i - 1]++;
                digits[i] = 0;
            }
        }

        if (digits[0] == 10) {
            digits[0] = 0;
            int[] extraDigit = new int[digits.length + 1];
            extraDigit[0] = 1;
            for (int i = 1; i < extraDigit.length; i++) {
                extraDigit[i] = digits[i - 1];
            }

            return extraDigit;
        }

        return digits;
    }
}
