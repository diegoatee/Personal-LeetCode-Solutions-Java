/*
Idea: HashMap implementation

1. Create a HashMap where the keys are the word anagrams sorted alphabetically, and the values are lists of strings that map to the same anagram.

2. Do this by iterating over strs. For each word, sort it (keep a copy of the original word too). Put the sorted anagram into the map alongside an empty ArrayList if the anagram is not already in the map.

3. Add the word into the specified anagram.

4. After iterating over strs, return a list of the maps values.

Time Complexity: O(N * klogk), where N = number of words, and k = length of longest word
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] charWord = word.toCharArray();
            Arrays.sort(charWord);
            String anagram = new String(charWord);

            map.putIfAbsent(anagram, new ArrayList<>());

            map.get(anagram).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
