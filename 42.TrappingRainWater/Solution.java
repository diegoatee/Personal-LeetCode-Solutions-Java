/*
Idea: Linear iteration over 1-width sized containers.

1. A container at location height[i] will contain water if it has a left boundary and a right boundary.

2. This is similar to the "Container with the most water" LeetCode problem. Here, the left boundary for height[i] is the maximum of all heights from i - 1 downwards. Similarly, the right boundary for height[i] is the maximum of all heights from i + 1 upwards.

Why are the boundaries not to the immediate right or immediate left of height[i] if each of our containers is of width 1?
Here is an example to explain: 

    Looking at height[5] in Example 1 in the description, that location has 2 blocks of water, even though the immediate left boundary and immediate right boundary are both of height 1. 

    Therefore, even though we are calculating the amount of water in a 1-width container at height[5], we have to consider the maximum height to the left of height[i] and the maximum height to the right of height[i]. These might not be adjacent boundaries.

    This will allow us to accurately calculate the amount of water at height[5]

3. If the minimum height of the left and right boundaries is bigger than the current height[i], then there will be water trapped at height[i].

4. The amount of water at height[i] is equal to the minimum(height[left], height[right]) - height[i]. 
(Only apply the area when minimum(height[left], height[right]) is greater than height[i], or else we could get 0 or negative water added)

We already have height[i], but how can we determine the left and right boundaries for each height[i]?

We can spend some space to store these boundaries!
Initially, store the "leftMax" heights in an array by iterating over the heights from the left.
Then, store the "rightMax" heights in an array by iterating over the heights from the right.

As a result, we can determine the left bound of height[i] to equal leftMax[i - 1], and the right bound of height[i] to equal rightMax[i + 1]. This is constant time! We just have to calculate the area of water for each height[i] now.

Time complexity: O(n)
Space complexity: O(n)
*/

class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];

        int sum = 0;

        for (int i = 1; i < height.length; i++) {
            if (height[i] > leftMax[i - 1]) {
                leftMax[i] = height[i];
            }
            else {
                leftMax[i] = leftMax[i - 1];
            }
        }

        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] > rightMax[i + 1]) {
                rightMax[i] = height[i];
            }
            else {
                rightMax[i] = rightMax[i + 1];
            }
        }

        for (int i = 1; i < height.length - 1; i++) {
            int minBound = Math.min(leftMax[i - 1], rightMax[i + 1]);

            if (minBound > height[i]) {
                sum = sum + minBound - height[i];
            }
        }

        return sum;
    }
}
