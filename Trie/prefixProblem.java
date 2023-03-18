package Trie;

public class prefixProblem {
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
    public static Node root=new Node();
    public static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(curr.children[index]==null){
                curr.children[index]=new Node();
            }else{
                curr.children[index].freq++;
            }
            curr=curr.children[index];
        }
        curr.eow=true;
    }
    public static void  findprefix(Node root,String ans){
        if(root==null){
            return;
        }
        if(root.freq==1){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<root.children.length;i++){
            if(root.children[i]!=null){
                findprefix(root.children[i],ans+(char)(i+'a'));
            }
        }
    }

    public static void main(String[] args) {
       String[] word={"zebra","dog","dove","duck"}; 
       for(int i=0;i<word.length;i++){
        insert(word[i]);
       }
       String key="thegaesh";
    //    System.out.println(wordBreak(key));
    root.freq=-1;
     findprefix(root, "");
    }
}

