class Solution {
    public int hammingDistance(int x, int y) {
        //XOR x and y, then return the number of 1s

        int xorRes = x ^ y;
        int hammingDist = 0;
        
        while (xorRes != 0) {
            int count = (xorRes & 1);
            hammingDist += count;

            xorRes = (xorRes >>> 1);
        }
        
        return hammingDist;
    }
}
