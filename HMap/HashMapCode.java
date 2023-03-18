package HMap;

import java.util.*;

public class HashMapCode {
    static class HashMap<K,V>{
        private class Node{
            K key;
            V value;
            public Node(K key,V value){
                
                this.key=key;
                this.value=value;
            }
        }
        private int n;
        private int N;
        private LinkedList<Node> buckets[];
        public HashMap(){
            this.N=4;
            this.buckets=new LinkedList[4];
            for(int i=0;i<4;i++){
                this.buckets[i]=new LinkedList<>();
            }
        }
        private int hashFunction(K key){
            int hc=key.hashCode();
            return Math.abs(hc)%buckets.length;
            
        }
        private int searchInLL(K key,int bi){
               LinkedList<Node> ll=buckets[bi];
               int di=0;
               for(int i=0;i<ll.size();i++){
                   Node node=ll.get(i);
                   if(node.key==key){
                    return di;
                   }
                   di++;
               }
               return -1;
        }
        private void rehash(){
            LinkedList<Node> oldbucket[]=buckets;
            buckets=new LinkedList[N*2];
            N=2*N;
            for(int i=0;i<buckets.length;i++){
                buckets[i]=new LinkedList<>();
            }
            for(int i=0;i<oldbucket.length;i++){
                LinkedList<Node> ll=oldbucket[i];
                for(int j=0;j<ll.size();j++){
                    Node node=ll.remove();
                    put(node.key, node.value);
                }
            }
        }
        public void put(K key,V value){
            int bucketindex=hashFunction(key);
            int dataindex=searchInLL(key, bucketindex);
            if(dataindex!=-1){
                Node node=buckets[bucketindex].get(dataindex);
                node.value=value;
            }else{
                buckets[bucketindex].add(new Node(key, value));
                n++;
            }
            double lambda=(double)n/N;
            if(lambda>2.0){
                rehash();
            }
        }
        public V get(K key){
            int bucketindex=hashFunction(key);
            int dataindex=searchInLL(key, bucketindex);
            if(dataindex!=-1){
                Node node=buckets[bucketindex].get(dataindex);
                 return node.value;
            }else{
               return null;
            }
        }
        public V remove(K key){
            int bucketindex=hashFunction(key);
            int dataindex=searchInLL(key, bucketindex);
            if(dataindex!=-1){
                Node node=buckets[bucketindex].remove(dataindex);
                n--;
                return node.value;
            }else{
               return null;
            }
        }
        public boolean ContainsKey(K key){
            int bucketindex=hashFunction(key);
            int dataindex=searchInLL(key, bucketindex);
            if(dataindex!=-1){
               return true;
            }else{
               return false;
            }
        }
        public ArrayList<K> keyset(){
            ArrayList<K> keys=new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll=buckets[i];
                for(Node node:ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n==0;
        }
    }
   
    public static void main(String[] args) {
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("ganesh", 20);
        hm.put("shu", 19);
        ArrayList<String> keys=hm.keyset();
        for(String key:keys){
            System.out.println(key);
        }
        System.out.println("meow");
        System.out.println(hm.get("shu"));
        System.out.println(hm.remove("shu"));
        System.out.println(hm.get("shu"));



    }
}
