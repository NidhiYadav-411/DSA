import java.util.*;

class Solution {

    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;
            parent[pa] = pb;
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {
        int left = 0, right = 200000, ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (can(mid, n, edges, k)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean can(int target, int n, int[][] edges, int k) {
        DSU dsu = new DSU(n);
        int upgrades = 0;
        int used = 0;

        List<int[]> needUpgrade = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 1) {
                if (s < target) return false;
                if (!dsu.union(u, v)) return false;
                used++;
            }
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];
            if (must == 1) continue;

            if (s >= target) {
                if (dsu.union(u, v)) used++;
            } else if (s * 2 >= target) {
                needUpgrade.add(e);
            }
        }

        for (int[] e : needUpgrade) {
            if (used == n - 1) break;

            int u = e[0], v = e[1];
            if (dsu.union(u, v)) {
                upgrades++;
                used++;
                if (upgrades > k) return false;
            }
        }

        return used == n - 1;
    }
}