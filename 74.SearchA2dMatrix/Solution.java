class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Perform binary search on row to get the correct row, then perform a 2nd binary search along that row to search for the target

        int low = 0;
        int high = matrix.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (matrix[mid][0] < target) {
                low = mid + 1;
            }
            else if (matrix[mid][0] > target) {
                high = mid - 1;
            }
            else {
                return true;
            }
        }

        if (high < 0) {
            return false;
        }

        int row = high; //'high' will be the row that may contain target, and no other row

        //Now search for the target with a 2nd binary search over this row
        low = 0;
        high =  matrix[0].length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (matrix[row][mid] < target) {
                low = mid + 1;
            }
            else if (matrix[row][mid] > target) {
                high = mid - 1;
            }
            else {
                return true;
            }
        }

        return false;
    }
}
