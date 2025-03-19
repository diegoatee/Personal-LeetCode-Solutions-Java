class Solution {
    public String minWindow(String s, String t) {
        //Map the character frequencies of t
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            int freq = map.getOrDefault(ch, 0);

            map.put(ch, freq + 1);
        }

        //Begin the sliding window problem
        int minLength = 0;
        int[] minWindowPointers = new int[2];
        boolean validWindow = false;
        int left = s.length();
        int right = s.length();
        int counter = s.length();

        //Set left and right to the first character in s that is in t
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                left = i;
                right = i;
                counter = i;
                break;
            }
        }
        //System.out.println("Starting pointers: Left == Right == " + left);

        while (counter < s.length()) {
            //Get next character
            char nextCh = s.charAt(counter);

            if (!map.containsKey(nextCh)) { //Irrelevant character
                counter++;
                continue;
            }
            else {
                right = counter;
                map.put(nextCh, map.get(nextCh) - 1);

                if (map.get(nextCh) < 0) { //Encountered a duplicate
                    //2 options: 
                    //1. If the encountered character is equal to the left char, move left to the next char in the map.
                    //2. Else, then don't move left.
                    if (s.charAt(left) == nextCh) {
                        map.put(nextCh, 0);
                        do {
                            left++;
                            if (left >= s.length()) {
                                break;
                            }
                            char ch = s.charAt(left);
                            if (map.containsKey(ch)) {
                                if (map.get(ch) < 0) {
                                    map.put(ch, map.get(ch) + 1);
                                }
                                else {
                                    break;
                                }
                            }
                        } while (left <= right);
                    }
                }
            }

            validWindow = true;
            for (Integer freq : map.values()) {
                if (freq > 0) {
                    validWindow = false;
                }
            }

            if (validWindow) {
                //System.out.println("Found Valid window at L = " + left + ", R = " + right);
                int curLength = right - left + 1;
                if (minLength == 0 || curLength < minLength) {
                    minLength = curLength;
                    minWindowPointers[0] = left;
                    minWindowPointers[1] = right;
                    //System.out.println("Current minimum length: " + minLength);
                }
                //Set left to be equal to the next char in the map that has no duplicates
                map.put(s.charAt(left), 1);
                do {
                    left++;
                    if (left >= s.length()) {
                        break;
                    }
                    char ch = s.charAt(left);
                    if (map.containsKey(ch)) {
                        if (map.get(ch) < 0) { //Has duplicates in the window
                            map.put(ch, map.get(ch) + 1);
                        }
                        else {
                            break;
                        }
                    }
                } while (left <= right);
                //System.out.println("Now left = " + left + ", right = " + right);
            }

            counter++;
        }

        if (minLength == 0) {
            return "";
        }
        else if (minWindowPointers[1] == s.length() - 1) {
            return s.substring(minWindowPointers[0]);
        }

        return s.substring(minWindowPointers[0], minWindowPointers[1] + 1);
    }
}
