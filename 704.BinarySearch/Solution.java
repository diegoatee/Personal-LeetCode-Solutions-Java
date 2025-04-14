class Solution {
    public int search(int[] nums, int target) {
        //Binary search algorithm
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2; // Helps avoid integer overflow
            int midNumber = nums[middle];

            if (midNumber < target) {
                left = middle + 1;
            }
            else if (midNumber > target) {
                right = middle - 1;
            }
            else {
                return middle;
            }
        }

        return -1;
    }
}
