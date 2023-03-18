package practice;


import java.util.*;

public class Testfile {
    public static void main(String[] args) {
     PriorityQueue<Integer> pq=new PriorityQueue<>( (a,b)->b-a);
     pq.offer(100);
     pq.offer(70);
     pq.offer(87);
     pq.offer(9);
     List<Integer> list=new ArrayList<>();
     while(!pq.isEmpty()){
      list.add(pq.poll());
     }
     System.out.println(list);
    }
}
