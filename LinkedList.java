

public class LinkedList <T>{
    public class Node  {
      T data;
      Node next;
      public Node (T  data){
        this.data=data;
        this.next=null;
      } 
    }
    public  Node head;
    public  Node tail;
    public static int size;
    public void addFirst( T data){
       Node newNode =new Node (data);
       size++;
       if(head==null){
        head=tail=newNode;
        return ;
       }
       newNode.next=head;
       head=newNode;
    }
    public void addLast(T data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public void prnit(){
        if(head==null){
            System.out.println("Linked List is Empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println();
    }
    public void addBetween(int index,T data){
        if(index==0){
            addFirst(data);
            return;
        }
        Node newNode=new Node (data);
        size++;
        Node temp=head;
        int i=0;
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public T  deleteFirst(){
        if(size==0){
            System.out.println("Liked list is empty");
            return null;
        }else if(size==1){
            T val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        T val=head.data;
         head=head.next;
         size--;
         return val;
    }
    public T removelast(){
        if(size==0){
            System.out.println("LinkedList is empty");
            return null;

        }else if(size==1){
            T val=head.data;
           head=tail=null;
           size=0;
           return val;
        }
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        T val=prev.next.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }
     private T helper(Node head, T key){
        if(head==null){
            System.out.println("not found");
            return null;
        }
        if(head.data==key){
            System.out.println("key exist");
            return key ;
        }
        T index=helper(head.next,key);
        if(index!=null){
             return null;
        }
        return index;
     }
    public T recuSearch( T key){
      return helper(head,key);
    }
    public void  reverseLinkedList(){
       Node prev=null;
       Node curr=tail=head;
       Node next;
       while(curr!=null){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
       }
       head=prev;
    }
    public void deletenthLinkedList(int n){
        // calculate size
        int size=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        if(n==size){
            // remove first operation
            head=head.next;
        }
        int i=1;
        int iToFind=size-n;
        Node prev=head;
        while(i<iToFind){
            prev=prev.next;
            i++;

        }
        prev.next=prev.next.next;
        return;
    }

    // function to find middle node

    public Node findMiddle(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean checkPalindrom(){
        if(head==null || head.next==null){
            return true;
        }
        // find mid
          Node middleNode=findMiddle(head);
          Node prev=null;
          Node curr=middleNode;
          Node next;
          while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
          }
        //   right half head
          Node right=prev;
          Node left=head;
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;

        // revserse 2 nd half
    }



    public static void main(String[] args) {
       LinkedList<Integer> ll=new LinkedList<>();
       ll.addFirst(1);
       ll.addFirst(1);
       ll.addFirst(1);
       ll.addFirst(9);
       ll.addFirst(0);
       ll.addFirst(1);
       ll.addFirst(1);
       ll.prnit();
      System.out.println(ll.checkPalindrom());

       

       
    }
}
