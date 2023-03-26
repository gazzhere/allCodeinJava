package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class graphImple {
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

    static void createGraph(ArrayList<Edges>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edges(2, 3, 3));
        graph[3].add(new Edges(3, 1, 1));
        graph[4].add(new Edges(4, 0, 0));
        graph[4].add(new Edges(4, 1, 1));
        graph[5].add(new Edges(5, 0, 0));

        graph[5].add(new Edges(5, 2, 1));
        // graph[2].add(new Edges(2, 1, 1));

        // graph[3].add(new Edges(2, 0, 1));
        // graph[3].add(new Edges(2, 4, 1));

        // graph[4].add(new Edges(4, 3, 1));
        // graph[4].add(new Edges(4, 3, 1));
        // graph[4].add(new Edges(4, 5, 1));

        // graph[5].add(new Edges(5, 3, 1));
        // graph[5].add(new Edges(5, 4, 1));
        // graph[4].add(new Edges(5, 6, 1));
        // graph[5].add(new Edges(5, 5, 1));

    }

    public static void bfs(ArrayList<Edges>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];
        q.offer(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.println(curr);
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edges e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }

    public static void dfs(ArrayList<Edges>[] graph, int curr, boolean[] vis) {

        System.out.println(curr);
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edges e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }

    }

    public static boolean detectCycleUtil(ArrayList<Edges>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycle(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycle(ArrayList<Edges>[] graph, boolean[] vis, int curr, int parent) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edges e = graph[curr].get(i);
            if (!vis[e.dest] && detectCycle(graph, vis, e.dest, curr)) {
                return true;
            } else if (vis[e.dest] && e.dest != parent) {
                return true;
            }
        }
        return false;
    }
    public static boolean iscycleUtil(ArrayList<Edges>[] graph,int curr,boolean vis[],boolean stack[]){
        vis[curr]=true;
        stack[curr]=true;
          for(int i=0;i<graph[curr].size();i++){
            Edges e=graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest] && iscycleUtil(graph, e.dest, vis, stack)){
                return true;
            }
          }
          stack[curr]=false;
          return false;
    }
    public static boolean isCycle(ArrayList<Edges>[] graph){
        boolean vis[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];
         for(int i=0;i<graph.length;i++){
             if(!vis[i]){
                if(iscycleUtil(graph,i,vis,stack)){
                    return true;
                }
             }
         }
         return false;
    }
    public static void topologicalSort(ArrayList<Edges>[]graph){
        boolean vis[]=new boolean[graph.length];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topoSortUtil(graph,i,vis, s);
            }
        }
        while(!s.empty()){
            System.out.println(s.pop()+" ");
        }
    }
    public static void topoSortUtil(ArrayList<Edges>[] graph,int curr,boolean vis[],Stack<Integer>s){
        vis[curr]=true;
         for(int i=0;i<graph[curr].size();i++){
            Edges e=graph[curr].get(i);
            if(!vis[e.dest]){
                topoSortUtil(graph, e.dest, vis, s);
            }
         }
         s.push(curr);
    }


    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edges>[] graph = new ArrayList[V];

        createGraph(graph);
        // dfs(graph,0,new boolean[V]);
        // System.out.println(isCycle (graph));
        topologicalSort(graph);

    }
}
