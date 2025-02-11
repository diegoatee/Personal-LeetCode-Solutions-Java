/*
Idea: 2-pointer solution

Key note: The overall height of a container is determined by the minimum height of both sides. Therefore, we want to traverse the array in a way such that we maximize the minimum height.

1. Initialize left and right pointers that contain the indices of the left and right of the array.

2. Calculate the area of the container bounded by the left and right pointers. If the area is greater than the current maximum, then update the current maximum

3. if minimum height is height[left], then increment left. Else, decrement right.

4. If left is >= right, then return the current maximum. Else, go back to step 2.
*/

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        int curMax;


        while (left < right) {
            if (height[left] < height[right]) {
                curMax = (right - left) * height[left];
                left++;
            }
            else {
                curMax = (right - left) * height[right];
                right--;
            }

            if (curMax > max) {
                max = curMax;
            }
        }

        return max;
    }
}
