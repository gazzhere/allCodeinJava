package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dikshtra {
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
        graph[0].add(new Edges(0,1 , 2));
        graph[0].add(new Edges(0,2 , 4));
        graph[1].add(new Edges(1,3 , 7));
        graph[1].add(new Edges(1,2 , 1));
        graph[2].add(new Edges(2,4, 3));
        graph[3].add(new Edges(3,5 , 1));
        graph[4].add(new Edges(4,3 , 2));
        graph[4].add(new Edges(4,5 , 5));

    }
    static class Pair{
        int n;
        int path;
        public Pair(int n,int path){
            this.n=n;
            this.path=path;
        }
    }
    public static void Dikshtraimpel(ArrayList<Edges> graph[],int src){
        int dist[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(a.path-b.path));
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            if(!vis[curr.n]){
                vis[curr.n]=true;
                for(int i=0;i<graph[curr.n].size();i++){
                    Edges e=graph[curr.n].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                        pq.offer(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");

        }
        System.out.println();
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edges>[] graph = new ArrayList[V];
        createGraph(graph);
        int src=0;
        Dikshtraimpel(graph, src);

    }
}
