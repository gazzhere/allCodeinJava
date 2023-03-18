package bsTree;

import java.util.ArrayList;

public class BinarySeachTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data=data;
        }
    }
    public static Node insertData(Node root,int val){
        if(root==null){
            root=new Node (val);
            return root;
        }
        if(root.data>val){
           root.left= insertData(root.left, val);
        }else{
            root.right=insertData(root.right, val);
        }
        return root;
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data);
        inOrder(root.right);
    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data +" ");
        preOrder(root.left);
        preOrder (root.right);
    }
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }

    }
    public static Node inorderSuccessor(Node root){
      while(root.left!=null){
        root=root.left;
      }  
      return root;
    }
    public static Node delete(Node root,int val){
       if(root.data<val){
        root.right=delete(root.right, val);
       } 
       else if(root.data>val){
        root.left=delete(root.left, val);
       } else{
        if(root.left==null &&root.right==null){
            return null;
        }
        if(root.left==null){
            return root.right;
        }
        if(root.right==null){
            return root.left;
        }
       Node is= inorderSuccessor(root.right);
       root.data=is.data;
       root.right= delete(root.right, is.data);
       }
       return root;
    }
    public static void printInRnge(Node root,int  k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1&&root.data<=k2){
            printInRnge(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRnge(root.right, k1, k2);
        }else if(root.data<k1){
            printInRnge(root.left, k1, k2);
        }else{
            printInRnge(root.right, k1, k2);
        }
    }
    public static void PrintPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }
    public static void PrinttoLeave(Node root,ArrayList<Integer> path){
      if(root==null){
        return;
      }
        path.add(root.data);
        if(root.left==null && root.right==null){
            PrintPath(path);
        }
        PrinttoLeave(root.left, path);
        PrinttoLeave(root.right, path);
        path.remove(path.size()-1);
    }
    public static boolean isValidBst(Node root,Node min,Node max){
       if(root==null){
        return true;
       }
       if(min!=null &&root.data<=min.data){
        return false;
       }else if(max!=null && root.data>=max.data){
        return false;
       }
     return  isValidBst(root.left, min, root) &&
       isValidBst(root.right, root, max);
    }
    public static Node createBalancedBST(int arr[],int st,int end){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root=new Node(arr[mid]);
        root.left=createBalancedBST(arr, st, mid-1);
        root.right=createBalancedBST(arr, mid+1, end);
        return root;
    }

    public static void main(String[] args) {
        int values[]={3,5,6,8,10,11,12};
        // Node root=null;
    //     for(int i=0;i<values.length;i++){
    //         root=insertData(root, values[i]);
    //     }
    //     inOrder(root);
    //     System.out.println();
    //  System.out.println( search(root, 7));
    //    root=delete(root, 5);
    //    inOrder(root);
    //    System.out.println();
    //    printInRnge(root, 1, 7);
    //    System.out.println("hew haww dowm");
      
    //    PrinttoLeave(root, new ArrayList<>());
    //   if( isValidBst(root, null, null)){
    //     System.out.println("valid");
    //   }else{
    //     System.out.println("invalid");
    //   }
    Node root=createBalancedBST(values, 0, values.length-1);
    preOrder(root);

    }
}
