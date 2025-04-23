class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int row = 0;

        for (; row < image.length; row++) {
            int left = 0;
            int right = image[row].length - 1;

            while (left <= right) {
                //Swap the bits at left and right indices
                int temp = image[row][left];
                image[row][left] = image[row][right];
                image[row][right] = temp;

                //Invert the bits
                if (left == right) {
                    if (image[row][left] == 1) {
                        image[row][left] = 0;
                    }
                    else {
                        image[row][left] = 1;
                    }
                }
                else {
                    if (image[row][left] == 1) {
                        image[row][left] = 0;
                    }
                    else {
                        image[row][left] = 1;
                    }

                    if (image[row][right] == 1) {
                        image[row][right] = 0;
                    }
                    else {
                        image[row][right] = 1;
                    }
                }

                left++;
                right--;
            }
        }

        return image;
    }
}
