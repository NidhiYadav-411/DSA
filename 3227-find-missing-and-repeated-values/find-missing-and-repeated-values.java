import java.util.Arrays;

class Solution {

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;

        boolean[] seen = new boolean[size + 1];
        int a = -1; // repeated
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                sum += val;

                if (seen[val]) {
                    a = val;
                }
                seen[val] = true;
            }
        }

        int totsum = (size * (size + 1)) / 2;
        int b = totsum - (sum - a); // missing

        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2}, {2, 4}};
        int[] ans = findMissingAndRepeatedValues(grid);
        System.out.println(Arrays.toString(ans));//n Java, an array is an object, not a printable value.This converts the array into a readable String:
    }
}
