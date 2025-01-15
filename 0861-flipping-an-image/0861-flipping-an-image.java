class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int C = image[0].length;
        for (int[] img : image) {
            for (int i = 0; i<(C+1)/2; i++) {
                int temp = img[i] ^ 1;
                img[i] = img[C-i-1] ^ 1;
                img[C-i-1] = temp;
            }
        }

        return image;
    }
}