/*
Idea: Every time we encounter an instance of val, we will replace it with the rightmost non-val integer, then decrement the upper bound.
1. Here, k represents the number of occurrences of val.
2. Initialize the uper bound to be the rightmost element index
3. Iterate over each int in nums
4. For each int that is equal to val...
    4a) Increment k
    4b) in a loop, if the upperbound int is not val, replace the current int with the upperbound and break from the loop.
    4c) if the upperbound is val, then decrement the upperbound index and check if the next integer is not val

5. After all iterations, then simply return the length of nums - k to get the number of non-val integers.
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int upperBound = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                k++;
                
                while (upperBound > i) {
                    if (nums[upperBound] != val) {
                        nums[i] = nums[upperBound];
                        upperBound--;
                        break;
                    }
                    else {
                        upperBound--;
                    }
                }
            }
        }

        return (nums.length - k);
    }
}
