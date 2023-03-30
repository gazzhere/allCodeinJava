package CollectionFrameWork;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrQueue {
    public static void main(String[] args) {
        List<StudentsMarks> stmarks=new ArrayList<>();
        stmarks.add(new StudentsMarks(48,4));
        stmarks.add(new StudentsMarks(47,7));
        stmarks.add(new StudentsMarks(5,80));
        stmarks.add(new StudentsMarks(44,43)); 
        stmarks.add(new StudentsMarks(48,45));
        PriorityQueue<StudentsMarks> spq=new PriorityQueue<>((a,b)->{
            System.out.println("comperator is called");
          return  b.getPhysics()-a.getPhysics();
        });
        for(StudentsMarks x:stmarks){
            spq.add(x);
        }
        List<StudentsMarks> top=new ArrayList<>();
        while(!spq.isEmpty()){ 
            top.add(spq.poll());
        }
        
        System.out.println(top);
       
        
       
    } 
}
