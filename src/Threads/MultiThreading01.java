package Threads;

public class MultiThreading01 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        CounterWithOutMultiThread counter1 = new CounterWithOutMultiThread("Idris");
        CounterWithOutMultiThread counter2 = new CounterWithOutMultiThread("Esra");
        counter1.countMe();
        System.out.println("********************************************");
        counter2.countMe();
        long finish = System.currentTimeMillis();

        System.out.println("Gecen Sure : "+ (finish-start));
        long start1 = System.currentTimeMillis();
        CounterWithMultiThread counter3 = new CounterWithMultiThread("Ilker");
        CounterWithMultiThread counter4 = new CounterWithMultiThread("Sefa");
        counter3.start();
        counter3.setName("Ilker");
//        try {
//            counter3.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }Sirayla saydirabiliriz.
        System.out.println("*******************************");
        counter4.start();
        counter4.setName("Sefa");


        try {
            counter3.join();//main thread de counter3 un isi bitene kadar bekle
            counter4.join();//main thread de counter3 un isi bitene kadar bekle
            //sonra tekrar main thread a katil.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long finish1 = System.currentTimeMillis();

        System.out.println("Thread de gecen sure : "+(finish1-start1));
    }
}
class CounterWithOutMultiThread{
    public String name;
    public CounterWithOutMultiThread(String name) {
        this.name = name;
    }
    //thread kullanmadan 1 den 10 a kadar yazdiran method
    public void countMe(){
        for(int i=1; i<=10; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i = "+ i+" "+name);
        }
    }
}
class CounterWithMultiThread extends Thread{
    public String name;
    public CounterWithMultiThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(" Thread :Run icindeki: "+Thread.currentThread().getName());
        countMe();
    }
    public void countMe(){
        for(int i=1; i<=10; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i = "+ i+" "+name);
        }
    }
}


















