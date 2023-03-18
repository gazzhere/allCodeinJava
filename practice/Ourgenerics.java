package practice;

import java.util.Iterator;

public class Ourgenerics<T> implements Iterable<T> {
    private T[] items;
    private int size;
    public  Ourgenerics(){
        size=0;
        items=(T[])new Object[100];
    }
    public void add(T item){
        items[size++]=item;
    }
    public T getItemAtIndex(int index){
        return items[index];
    }
    @Override
    public Iterator<T> iterator() {
     return new ourGenericiterator(this);
    }
    private class ourGenericiterator implements Iterator<T>{
        private Ourgenerics<T> ll;
        private int index=0;
    
        public ourGenericiterator(Ourgenerics<T> ll){
            this.ll=ll;
        }
    
        @Override
        public boolean hasNext() {
            System.out.println("has next called");
            return index < ll.size;
        }
    
        @Override
        public T next() {
            System.out.println("next called");
           return ll.items[index++];
        }
    
    }

}

