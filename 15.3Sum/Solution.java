/*
Idea: 2-pointer solution.

1. This approach builds upon the TwoSum solution where the input array is already sorted.

2. First, sort the input array (O(nlogn))

3. Then iterate over the array with a variable i starting from the beginning of the array.

4. For each i, declare a variable j to be the index immediately after i. Also declare a variable k to be the index of the last element of the array. Here, j will represent the "left" pointer, and k the "right" pointer.

5. Our goal is to find j and k such that j + k = -i. Therefore, our target value should be -i.

6. If nums[j] + nums[k] = target, then add nums[i], nums[j], and nums[k] to a list and store the list within a HashSet to avoid deuplicates

   If nums[j] + nums[k] < target, increment the j (left) index to get closer to the target.
   If nums[j] + nums[k] > target, decrement the k (right) pointer to get closer to the target.

   Do this until j is not less than k to ensure all possible combinations are checked

7. Then, increment i, and reinitialize j and k. Return to step 6

Note: If nums[i] is ever greater than 0, then we can stop the algorithm early, because the nums[j] and nums[k] values will also be greater than 0. The sum of numbers > 0 can never equal 0.

Time complexity: O(N^2)
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            int target = -nums[i];
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[j] + nums[k];

                if (sum < target) {
                    j++;
                }
                else if (sum > target) {
                    k--;
                }
                else {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
            }
        }

        result.addAll(set);
        return result;
    }
}
