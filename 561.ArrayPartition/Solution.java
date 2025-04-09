class Solution {
    public int arrayPairSum(int[] nums) {
        //Sort the array, then iterate over every other value starting from the first (O(NlogN))
        Arrays.sort(nums);
        int res = 0;

        for (int i = 0; i < nums.length; i = i + 2) {
            res += nums[i];
        }

        return res;
    }
}
