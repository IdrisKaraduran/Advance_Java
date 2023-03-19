package Threads;

import java.util.concurrent.CountDownLatch;

/*
Birden fazla thread le calisirken bazi threadlere oncelik vermek isteyebiliriz
Bazi threadlerin once calismasini main ve diger thread lerin beklemesini
isteyebikliriz.Ve beklemesini istedigimizde countdownlatch in
metodlari ile oncelik verdigimiz thread ler icin bir sayac olusturulur.
bu sayac her thread isini tamamladiginda bir azaltiir. 0 oldugunda
 */
public class CountDownLatch01 {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(4);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread1 calisiyor...");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread2 calisiyor...");
            }
        });

        WorkerThread worker1 = new WorkerThread("worker1",5000,latch);
        WorkerThread worker2 = new WorkerThread("worker2",7000,latch);
        WorkerThread worker3 = new WorkerThread("worker3",9000,latch);
        WorkerThread worker4 = new WorkerThread("worker4",6000,latch);

        thread1.start();
        thread2.start();
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();
        System.out.println("Burada thread1 calisiyor.await ile workerlara oncelik verilir");

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName()+ " calisiyor.");


    }
}
class WorkerThread extends Thread{
    private int duration;
   private  CountDownLatch latch;

   public WorkerThread(String name,int duration,CountDownLatch latch){
       super(name);
       this.duration = duration;
       this.latch =latch;
   }
   public void run(){

       try {
           System.out.println(Thread.currentThread().getName() + " basladi");
           Thread.sleep(duration);
           System.out.println(Thread.currentThread().getName() + " bitirdi");
           latch.countDown();
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }

   }



}
