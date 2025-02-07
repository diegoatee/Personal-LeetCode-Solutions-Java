/*
Idea: 2-pointer system

1. Have a left pointer store the leftmost index of numbers, and a right pointer store the rightmost index of numbers.

2. If numbers[left] + numbers[right] equals target, simply add both left and right to the result array and return it.
    2.1) If numbers[left] + numbers[right] is larger than target, reduce the sum by decrementing the right pointer
    2.2) If numbers[left] + numbers[right] is smaller than the target, increase the sum by incrementing the left pointer

Eventually, the solution must be found before the left and right pointers intersect, as the problem states that all test cases have a unique guaranteed solution.

Time Complexity: O(N)
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int result[] = new int[2];
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum > target) {
                right--;
            }
            else if (sum < target) {
                left++;
            }
            else {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
        }
        
        return result;
    }
}
