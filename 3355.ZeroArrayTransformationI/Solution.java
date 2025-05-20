class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        //Using a difference array to keep track of the # of queries that affect each element in nums
        int[] differenceArr = new int[nums.length + 1]; //Initially all zeros

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            /*
            1. For each query...
                1a) Decrement differenceArr[l]
                1b) Increment differenceArr[r + 1]
            2. Effectively, this means that for a difference array that looks like
                [-1, 0, 0, 1], there is 1 query that covers the first 3 elements. 
            3. To determine the total number of queries covering a specific element in nums, keep a running sum.
            4. The number of possible decrements for nums[i] equals to the negative value of the running sum from 0 through i in the difference array.
            */

            //Update the difference array
            differenceArr[l]--;
            differenceArr[r + 1]++;
        }

        int cumulativeSum = 0;
        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += differenceArr[i];

            if (nums[i] > (-1 * cumulativeSum)) { //If not enough queries cover this element
                return false;
            }
        }

        return true;
    }
}
