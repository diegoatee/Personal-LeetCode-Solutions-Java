class Solution {
    public int[] twoSum(int[] nums, int target) {
        //HashMap implementation: Iterate over nums, adding elements into the map with their indices as their values.
        //If, while looking at an element, its complement is found in the map, then add both of their indices into the result array.
        //Time complexity: O(N)
        
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);

                return result;
            }

            map.put(nums[i], i);
        }

        return result;
    }
}
