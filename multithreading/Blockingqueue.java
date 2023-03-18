package multithreading;

import java.util.LinkedList;
import java.util.Queue;


public class Blockingqueue {
  private  Queue<Integer> q;
    private int capacity;
    public Blockingqueue(int cap){
        q=new LinkedList<>();
        capacity=cap;
    }
    public Boolean add(int items){
      synchronized(q){
        while(q.size()==capacity)
         {
            try {
                q.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
         }
        q.add(items);
        q.notifyAll(); 
        return true;

        
      }
    }
    public int remove(){
        synchronized(q){
        while (q.size()==0)
            {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        int element=q.poll();
        q.notifyAll();
        return element;
        }
    }

    
}
