class Solution {
    public int findComplement(int num) {
        //We can get the complement of a number by XORing it with a mask that consists of all 1's

        //0 XOR 1 is 1, and 1 XOR 1 is 0.

        int numBits = Integer.toBinaryString(num).length();

        int mask = (1 << numBits) - 1;

        return num ^ mask;

    }
}
