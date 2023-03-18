package Trie;

public class longestword {
    
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
    public static String ans="";
    public static void longestWord(Node root,StringBuilder temp){
       if(root==null){
        return;
       } 
       for(int i=25;i>=0;i--){
        if(root.children[i]!=null && root.children[i].eow==true){
            char ch=(char)(i+'a');
            temp.append(ch);
            if(temp.length()>ans.length()){
                ans=temp.toString();
            }
            longestWord(root.children[i], temp);
            temp.deleteCharAt(temp.length()-1);
        }
       }
    }
    public static void main(String[] args) {
        String[] word={"a","banana","app","appl","ap","apply","apple"}; 
        for(int i=0;i<word.length;i++){
         insert(word[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
    
}
