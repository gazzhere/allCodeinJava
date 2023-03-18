package trees;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BTree {
    static class Node{
        int data;
        Node right;
        Node left;
       public Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }
    static class BinaryTree{
        static int index=-1;
        public static Node buildTree(int node[]){
            index++;
            if(node[index]==-1){
                return null;
            }
            Node newNode= new Node(node[index]);
            newNode.left=buildTree(node);
            newNode.right=buildTree(node);
            return newNode;
        }
        public static void preOrder(Node root){
          if(root==null){
            return;
          } 
          System.out.print(root.data+" ");
          preOrder(root.left);
          preOrder(root.right);
        }
        public static void inOrder(Node root){
            if(root==null){
              return;
            } 
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
          }
          public static void postOrder(Node root){
            if(root==null){
              return;
            } 
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
          }
          public static void LevelOrder(Node root){
           if(root==null){
            return;
           }
           Queue<Node> q=new LinkedList<>();
           q.offer(root);
           q.add(null);
           while(!q.isEmpty()){
            Node currNode=q.remove();
            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.offer(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null){
                    q.offer(currNode.left);
                }
                if(currNode.right!=null){
                    q.offer(currNode.right);
                }
            }
           }
          }
          public static int height(Node root){
            if(root==null){
                return 0;
            }
            int left=height(root.left);
            int right=height(root.right);
            return Math.max(left, right)+1;

          }
          public static int count(Node root){
            if(root==null){
                return 0;
            }
            int left=count(root.left);
            int right=count(root.right);
            return (left+right)+1;

          }
          public static int sumofNodes(Node root){
            if(root==null){
                return 0;
            }
            int left=sumofNodes(root.left);
            int right=sumofNodes(root.right);
            int treeSum=left+right+root.data;
            return treeSum;

          }
          static class info{
            int dia;
            int height;
            info(int dia,int height){
                this.dia=dia;
                this.height=height;
            }
          }

          public static info diameter(Node root){
            if(root==null){
                return new info(0, 0);
            }
            info leftinfo=diameter(root.left);
            info rightinfo=diameter(root.right);
            int dia=Math.max(Math.max(leftinfo.dia, rightinfo.dia),leftinfo.height+rightinfo.height+1);
            int ht=Math.max(leftinfo.height, rightinfo.height)+1;
            return new info(dia, ht);
          }

        public static boolean isIdentical(Node node ,Node subRoot){
          if(node==null && subRoot==null ){
            return false;
          }else if(node==null || subRoot==null|| node.data!=subRoot.data){
            return false;
          }
          if(!isIdentical(node.left, subRoot.left)){
            return false;
          }
          if(!isIdentical(node.right, subRoot.right)){
            return false;
          }
          return true;
        }
        public static boolean isSubtree(Node root,Node subRoot){
          if(root==null){
            return false;
          }
          if(root.data==subRoot.data){
            if(isIdentical(root,subRoot)){
              return true;
            }
          }
          return isSubtree(root.left, subRoot)||  isSubtree(root.right, subRoot);
        }



        static class inform{
          Node node;
          int hd;
          public inform(Node node,int hd){
            this.node=node;
            this.hd=hd;
          }
        }
       public static void topView(Node root){
        Queue<inform> q=new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();
        int min=0,max=0;
        q.add(new inform(root,0));
        q.add(null);
        while(!q.isEmpty()){
          inform curr=q.remove();
          if(curr==null){
            if(q.isEmpty()){
              break;
            }else{
              q.add(null);
            }
          }else{
            if(!map.containsKey(curr.hd)){
              map.put(curr.hd, curr.node);
            }
            if(curr.node.left!=null){
              q.add(new inform(curr.node.left, curr.hd-1));
              min=Math.min(min, curr.hd-1);
            }
            if(curr.node.right!=null){
              q.add(new inform(curr.node.right, curr.hd+1));
              max=Math.max(min, curr.hd+1);
            }
          }
          
        }
        for(int i=min;i<=max;i++){
          System.out.print(map.get(i).data+" ");
        }
        System.out.println();
       }
       public static void klevel(Node root,int level,int k){
        if(root==null){
          return;
        }
        if(level==k){
          System.out.print(root.data+" ");
          return;
        }
        klevel(root.left, level+1, k);
        klevel(root.right, level+1, k);

       }
    
      
    }
  
   

    public static void main(String[] args) {
        int node[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        // Node subroot=new Node(2);
        // subroot.left=new Node(4);
        // subroot.right=new Node(5);
        BinaryTree tree=new BinaryTree();
        Node root=tree.buildTree(node); 
        System.out.println();
        tree.LevelOrder(root);
        System.out.println();
       System.out.println( tree.height(root));
       System.out.println();
       System.out.println( tree.count(root));
       System.out.println();
       System.out.println( tree.sumofNodes(root));
       System.out.println();
       System.out.println( tree.diameter(root).dia); 
      // Node root=new Node(1);
      // root.left=new Node(2);
      // root.right=new Node(3);
      // root.left.left=new Node(4);
      // root.left.right=new Node(5);
      // root.right.left=new Node(6);
      // root.right.right=new Node(7);



       System.out.println();
       tree.topView(root);
       System.out.println();
       tree.klevel(root, 1, 3);
  



    }
    
}
