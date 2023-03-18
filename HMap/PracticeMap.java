package HMap;

import java.util.*;;

public class PracticeMap {
  public static void main(String[] args) {
      HashMap<String ,Integer> map=new HashMap<>();
      map.put("ganesh",100);
      map.put("chandler",120);
    //   below line will throw null ointer exception
      System.out.println(map.get("meow"));
    //   below statement will not throw null pointer exception
    System.out.println(map.getOrDefault("gesh", 0));
    System.out.println(map.getOrDefault("chandler", 120));
    // this below line will check vaue is present or not
    System.out.println(map.containsKey("ganesh"));
    Map<Integer,List<Integer>> adj=new HashMap<>();
    // traditional way of putting value into graph
    if(adj.get(1)==null){
        adj.put(1, new ArrayList<>());
    }
    // advance way of putting value into graph 
    adj.computeIfAbsent(1, f->new ArrayList<>()).add(2);
    // first way to iterate over map
    Set<Map.Entry<String,Integer>> entrySet=map.entrySet();
    for(Map.Entry<String,Integer> entry:entrySet){
        System.out.println(entry.getKey()+" "+entry.getValue());
    }
    System.out.println("nextline");
    // second way to iterate over map
    Set<String>keySet=map.keySet();
    for(String key:keySet){
      System.out.println(key+","+map.get(key));
    }
    // implementation of tree map
    NavigableMap<String,Integer> tmap=new TreeMap<>();
    tmap.put("ganesh",100);
    tmap.put("chandler",120);
    System.out.println(tmap);
    Set<Map.Entry<String,Integer>> TreeSet=tmap.entrySet();
    for(Map.Entry<String,Integer> entry:TreeSet){
        System.out.println(entry.getKey()+" "+entry.getValue());
    }
    Set<String> treeSet=tmap.keySet();
    for(String key:treeSet){
      System.out.println(key+","+map.get(key));
    }
     
  }  
}
