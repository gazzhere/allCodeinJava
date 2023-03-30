package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    public static class Edges {
        int src;
        int dest;
        int wt;

        Edges(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static class Pair {
        int v;
        int cost;

        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static void createGraph(ArrayList<Edges>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edges(0, 1, 10));
        graph[0].add(new Edges(0, 2, 15));
        graph[0].add(new Edges(0, 3, 30));

        graph[1].add(new Edges(1, 0, 10));
        graph[1].add(new Edges(1, 3, 40));

        graph[2].add(new Edges(2, 0, 15));
        graph[2].add(new Edges(2, 3, 50));


        graph[3].add(new Edges(3, 1, 40));
        graph[3].add(new Edges(3, 2, 50));

    }

    public static void getMst(ArrayList<Edges>[] graph) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.cost - b.cost));
        pq.offer(new Pair(0, 0));
        int finalcost = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalcost += curr.cost;
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edges e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        System.out.println("final cost" + finalcost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edges>[] graph = new ArrayList[V];
        createGraph(graph);
        getMst(graph);

    }
}
