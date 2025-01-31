/*
Idea: HashSet implementation to check for duplicates concurrently.

1. For each, row, column, and 3x3 box in the board, create a HashSet that will store the characters of that specific row, column, or box.

2. Iterate over the board row-by-row, character by character, checking first if a nonempty character is present in their respective sets.
    2a) If a character is already in a set, then the board is invalid.
    3a) If the character is in a valid position, add it to their respective row, column, and box set.

3. If the entire board is checked, then the board is considered valid.

Time complexity: O(1) since the board size is a constant, but it could be considered O(N^2) given a variable input for the board side length
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[][] boxes = new HashSet[3][3];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            for (int j = 0; j < 3; j++) {
                boxes[i / 3][j] = new HashSet<>();
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];

                if (ch == '.') {
                    continue;
                }

                if (rows[i].contains(ch) || cols[j].contains(ch) || boxes[i / 3][j / 3].contains(ch)) {
                    return false;
                }

                rows[i].add(ch);
                cols[j].add(ch);
                boxes[i / 3][j / 3].add(ch);
            }
        }

        return true;
    }
}
