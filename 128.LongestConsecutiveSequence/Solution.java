/*
Idea: HashSet implementation

1. Iterate over nums and put each element into a HashSet.

2. Next, we want to iterate over the set.

3. For each element...
    3.1) Check if the set includes the integer just prior to the current element.
        3.1.1) If the just-prior integer exists, then continue to the next integer in the set (we want to find an integer that can "start" a consecutive sequence)

    3.2) If we have an element that starts a consecutive sequence, then, in a loop, determine how long the sequence is, and if it surpasses the current maximum length, then replace the current maximum.

Time complexity: O(N)

N (for iterating over nums) + N(For iterating over the set in the event that the entire array is consecutive)
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        int result = 1;
        int curLength = 1;

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }

            curLength = 1;
            int temp = num;
            while (set.contains(temp + 1)) {
                curLength += 1;
                temp += 1;
            }

            if (curLength > result) {
                result = curLength;
            }
        }

        return result;
    }
}
