package CollectionFrameWork;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class pracQueue {
    public static void main(String[] args) {
        Queue<Integer> o=new LinkedList<>();
        o.offer(1);
        o.offer(2);
        o.offer(3);
        o.offer(4);
        System.out.println(o.poll());

        System.out.println(o);
        System.out.println(o.peek());
        Deque<Integer> dq=new ArrayDeque<>();
        dq.offerFirst(1);
        dq.offer(2);
        System.out.println(dq);
    } 
}
