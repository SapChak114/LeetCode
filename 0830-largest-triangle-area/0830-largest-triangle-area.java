class Solution {
    public double largestTriangleArea(int[][] points) {
        double max = 0.0d;

        for (int i = 0; i<points.length; i++) {
            for (int j = i + 1; j<points.length; j++) {
                for (int k = j + 1; k<points.length; k++) {
                    double area = getArea(points[i], points[j], points[k]);

                    if (area > max) {
                        max = area;
                    }
                }
            }
        }

        return max;
    }

    double getArea(int[] a, int[] b, int[] c) {
        return Math.abs((a[0] * (b[1] - c[1])) + (b[0] * (c[1] - a[1])) + (c[0] * (a[1] - b[1]))) / 2.0;
    }
}