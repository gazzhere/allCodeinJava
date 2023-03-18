package multithreading;

public class ThreadTester {
    public static void main(String[] args) {
        System.out.println("mainthread is starting");

        // Thread thread1=new Thread1("thread1");

        // thread1.setDaemon(true);

        // thread1.start();

        // Thread thread2=new Thread( ()->{
        //     for(int i=0;i<5;i++){
        //         System.out.println(Thread.currentThread()+" "+i);
        //     }
        // },"thread2");
        // thread2.start();
    //     Stacks stack=new Stacks(5);
    //     new Thread(()->{
    //         int counter=0;
    //         while(++counter<10){
    //             System.out.println("pushed: "+stack.push(100));
    //         }
    //     },"pusher").start();
    //     new Thread(()->{
    //         int counter=0;
    //         while(++counter<10){
    //             System.out.println("popped : "+stack.pop());
    //         }
    //     },"popper").start();
    //     System.out.println("main thread is exiting");
    // }
    // dead lock below
    String lock1="ganesh";
    String lock2="gazz";
    Thread thread1=new Thread(()->{
        synchronized(lock1){
          try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
           
            e.printStackTrace();
        }
          synchronized(lock2){
            System.out.println("lock acquired");
          }
        }
    },"thread1");

    Thread thread2=new Thread(()->{
        synchronized(lock1){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
               
                e.printStackTrace();
            }
            synchronized(lock2){
              System.out.println("lock acquired");
            }
        }
    },"thread2");
    thread1.start();
    thread2.start();
    



    }
    
}
 