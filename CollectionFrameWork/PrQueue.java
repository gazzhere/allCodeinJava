package CollectionFrameWork;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.offer(48);
        pq.offer(78);
        pq.offer(1);
        pq.offer(56);
        pq.offer(90);
        pq.offer(8);

        // List<Integer> lst=new ArrayList<>();
        // int index=0;
        // while(!pq.isEmpty()){
        //     if(index==2)break;
        //     lst.add(pq.poll());
        //     index++;
        // }
        // System.out.println(lst);
        System.out.println(pq);
    }
}
