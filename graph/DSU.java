package graph;

import java.util.Arrays;

class DSU {
    int parent[];
    int height[];

    public DSU(int n) {
        height = new int[n];
        parent = new int[n];
        Arrays.fill(height, 1);
        Arrays.fill(parent, -1);
    }

    public int findRoot(int node) {
        if (parent[node] == -1)
            return node;
        return (parent[node] = findRoot(parent[node]));
    }

    public boolean union(int node1, int node2) {
        int ra = findRoot(node1);
        int rb = findRoot(node2);
        if (ra != rb) {
            if (height[ra] < height[rb])
                parent[ra] = rb;
            else if (height[rb] < height[ra])
                parent[rb] = ra;
            else {
                parent[rb] = ra;
                height[ra]++;
            }
            return true;
        }
        return false;
    }
}