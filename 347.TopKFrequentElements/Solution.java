/*
Idea: HashMap + PriorityQueue solution

1. Map all integers of nums with their frequencies.

2. Create a maxheap that stores the keys of the map, utilizing a custom comparator that sorts the queue by largest value to smallest value.

3. In a loop that iterates k times, poll from the queue and add it to our result array

4. Return the result array

Time Complexity: O(NlogN)
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        for (int i = 0; i < nums.length; i++) {
            int freq = map.getOrDefault(nums[i], 0);
            map.put(nums[i], freq + 1);
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (int key : map.keySet()) {
            maxHeap.add(key);
        }

        for (int i = 0; i < k; i++) {
            int cur = maxHeap.poll();
            result[i] = cur;
        }

        return result;

    }
}
