/*
Idea:
1. Iterate over nums, adding each element into a HashSet.
2. For each new number, check if it is already in the set.
3. If yes, then return true.
4. If the condition is never satisfied, then return false.

Time complexity: O(N)
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);
        }

        return false;
    }
}
