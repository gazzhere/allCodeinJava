package CollectionFrameWork;


import java.util.ArrayList;
import java.util.List;

public class listprac {
    public static void main(String[] args) {
       List<Integer> list=new ArrayList<>();
       list.add(1);
       list.add(2);
       list.add(3);
       System.out.println(list);
       Integer []arr=list.toArray(new Integer[0]);
        for(int x:arr){
            System.out.print(x+"->");
        }
    }
}
