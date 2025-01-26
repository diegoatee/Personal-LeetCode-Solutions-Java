/*
Idea: Simple binary search algorithm
1. Initialize left and right index integers
2. While left <= right, calculate the middle index.
3. If nums[middle] is the target, return middle. Else, shift left and right indices as necessary.
4. If the loop ends, then return left.

Why return left? 

Say the target is greater than the largest value in nums. Then "left" would equal nums.length, which is the index that the target should be inserted into were the array one int larger.

If target is less than the smallest value, left would be 0, right would be -1. We know -1 is not a valid index, so left is the correct choice.

What if target is in between 2 integers in nums?
Take [1, 3, 5, 10] with the target 7. The loop will end with left = 3, right = 2, ending after the right index has been decremented. Here, left is the index that should house 7.

Take [1, 3, 5, 10] with the target 2. The loop will end with left = 1, right = 0, ending after the left index has been incremented. Here, left is still the index that should house 2.

Therefore, in all test cases where that target is not in nums, the resulting left index would be the insertion index.

Time complexity: O(logN)
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle = -1;

        while (left <= right) {
            middle = left + (right - left) / 2;

            if (nums[middle] > target) {
                right = middle - 1;
            }
            else if (nums[middle] < target) {
                left = middle + 1;
            }
            else {
                return middle;
            }
        }

        return left;
    }
}
