class Solution {
    public int islandPerimeter(int[][] grid) {
        //This problem can be broken down into finding the "value" of each square in the grid

        //If a square is a block of land, it will have a perimeter of 4 if it is only surrounded by water
        //For each adjacent block of land, then that perimeter will decrease by 1.

        //Iterate over each square in the grid, find its overall value in constant time, and add to a running sum

        //Overall time: O(m * n) where m is the number of rows and n is the number of columns

        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //Only continue if the current square is land
                if (grid[i][j] == 0) {
                    continue;
                }
                int curValue = 4;

                //Check left
                int adjacentRow = i;
                int adjacentCol = j - 1;

                if (adjacentCol >= 0 && grid[adjacentRow][adjacentCol] == 1) {
                    curValue--;
                }

                //Check right
                adjacentCol = j + 1;

                if (adjacentCol <= grid[i].length - 1 && grid[adjacentRow][adjacentCol] == 1) {
                    curValue--;
                }

                //Check top
                adjacentRow = i - 1;
                adjacentCol = j;

                if (adjacentRow >= 0 && grid[adjacentRow][adjacentCol] == 1) {
                    curValue--;
                }

                //Check bottom
                adjacentRow = i + 1;

                if (adjacentRow <= grid.length - 1 && grid[adjacentRow][adjacentCol] == 1) {
                    curValue--;
                }

                perimeter += curValue;
            }
        }

        return perimeter;
    }
}
