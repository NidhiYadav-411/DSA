import java.util.*;

class Solution {

    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                add(set, grid[r][c]); // size 0 rhombus

                for (int k = 1; r + 2 * k < m && c - k >= 0 && c + k < n; k++) {

                    int sum = 0;

                    for (int i = 0; i < k; i++) sum += grid[r+i][c+i];
                    for (int i = 0; i < k; i++) sum += grid[r+k+i][c+k-i];
                    for (int i = 0; i < k; i++) sum += grid[r+2*k-i][c-i];
                    for (int i = 0; i < k; i++) sum += grid[r+k-i][c-k+i];

                    add(set, sum);
                }
            }
        }

        int[] res = new int[set.size()];
        int i = set.size() - 1;

        for (int val : set) {
            res[i--] = val;
        }

        return res;
    }

    private void add(TreeSet<Integer> set, int val) {
        set.add(val);
        if (set.size() > 3) {
            set.pollFirst(); // remove smallest
        }
    }
}