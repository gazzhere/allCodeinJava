package Trie;

public class startsWith {
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        int freq;
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            freq=1;
        }
    }
    public static void main(String[] args) {
        
    }
    
}
