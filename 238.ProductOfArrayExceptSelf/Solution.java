/*
Idea: Prefix and Postfix arrays
1. Let the "prefix" value of nums[i]
 be equal to the product of all of the integers prior to nums[i]. (assume the prefix for the 1st element is 1).
 Iterate over nums to fill the result array with the prefixes of nums[i].

 2. Let the "postfix" value of nums[i] be equal to the product of all the integers that are after nums[i]. (assume the postfix for the last element is also 1). 
 Iterate from the right of nums, multiplying the result[i] by the postfix of nums[i], then updating the postfix for the next integer in nums

 Time complexity: O(N)
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        int prefix = 1;
        int postfix = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix = prefix * nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * postfix;
            postfix = postfix * nums[i];
        }

        return result;
    }
}
