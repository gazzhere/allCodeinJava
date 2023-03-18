package HMap;
import java.util.*;
public class practiceQuestion {

    public static void main(String[] args) {
        int a[]={1,3,2,5,1,1,1,1,1,1,1};
        HashMap<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<a.length;i++){
            // if(m.containsKey(a[i])){
            //   m.put(a[i],m.get(a[i])+1 );
            // }else{
            //     m.put(a[i], 1);
            // }
            // optimization
            m.put(a[i], m.getOrDefault(a[i], 0)+1);
        }
        // Set<Integer> keyset=m.keySet();
       for(Integer key:m.keySet()){
        if(m.get(key)>a.length/3){
            System.out.println(key);
        }
       }
    }
}
