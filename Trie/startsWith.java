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
    
        }

    }
    public static Node root=new Node();
    public static void insert(String word){
        Node curr=root;
        for(int level=0;level<word.length();level++){
            int index=word.charAt(level)-'a';
            if(curr.children[index]==null){
                curr.children[index]=new Node();
            }
            curr=curr.children[index];
        }
        curr.eow=true;
    }
    public static boolean search(String key){
        Node curr=root;
        for(int level=0;level<key.length();level++){
            int index=key.charAt(level)-'a';
            if(curr.children[index]==null){
               return false;
            }
            curr=curr.children[index];
        }
       return curr.eow==true;
    }
    public static boolean startsWith(String prefix){
        Node curr=root;
        for(int i=0;i<prefix.length();i++){
            int index=prefix.charAt(i)-'a';
            if(curr.children[index]==null){
                return false;
            }
            curr=curr.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        String[] word={"zebra","dog","dove","duck"}; 
        for(int i=0;i<word.length;i++){
         insert(word[i]);
        }
        String pref="zsseb";
        System.out.println(startsWith(pref));
    }
    
}
