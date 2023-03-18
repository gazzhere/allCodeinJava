package multithreading;

public class Stacks {
    private int arr[];
    private int statcktop;
    Object lock;
    public Stacks(int capacity){
        arr=new int[capacity];
        statcktop=-1;
        lock=new  Object();
    }
    public boolean isEmpty(){
        return statcktop<0;
    }
    public boolean isFull(){
        return statcktop>=arr.length-1;
    }
    public synchronized boolean push(int element){
       synchronized(this){
        if(isFull())return false;
        ++statcktop;
        try{Thread.sleep(1000);}catch(Exception e){}
        arr[statcktop]=element;
        return true;
       }
    }
    public synchronized int pop(){
        synchronized(this){
            if(isEmpty())return Integer.MIN_VALUE;
        int obj=arr[statcktop];
        arr[statcktop]=Integer.MIN_VALUE;
        try{Thread.sleep(1000);}catch (Exception e){}
        statcktop--;
        return obj;
        }
    }

}
