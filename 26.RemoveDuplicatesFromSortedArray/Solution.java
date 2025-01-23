/*
Idea:
Keep a variable "index" to represent the array position where the next distinct number should go. Initially equal to 1.

Keep a variable "prevIndex" to represent the last found distinct number in nums. Initially equal to 0.

At the start of our iteration over nums, k should be equal to 1.

For each element, check if the nums[prevIndex] is not equal to the current element. If that is true, then we can increment k, change nums[index] to nums[i], increment index, and set prevIndex to i. Don't do anything if a duplicate is encountered.

Time complexity: O(N)

*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int k = 1;
        int prevIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[prevIndex]) {
                nums[index] = nums[i];
                k++;
                index++;
                prevIndex = i;
            }
        }

        return k;
    }
}
