//This can be further improved with a binary search implementation.

class Solution {
    public int mySqrt(int x) {
        int count = 0;

        for (long i = count; i <= x; i++) {
            long square = i * i;
            //System.out.println("Count: " + i);
            //System.out.println("Square: " + square);

            if (square > x) {
                return (int)(i - 1);
            }
            else if (square == x) {
                return (int)i;
            }
        }

        return -1;
    }
}
