package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Thread ler gercekten maliyetli yapilardir.
CPU memory de kaynak ayrilir.
Bu sebeple aktif olan thread sayisini sinirlandirmak isteyebilir.

Threadler gerçekten maliyetli yapılardır.
CPU, memoryde kaynak ayrılır.
Bu sebeple aktif olan thread sayısını sınırlandırmak isteyebiliriz.

 */
public class ThreadPool {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(3);
        //Thread leri hazirlama

        ThreadCreator threadCreator1 = new ThreadCreator("B");
        ThreadCreator threadCreator2 = new ThreadCreator("C");
        ThreadCreator threadCreator3 = new ThreadCreator("D");
        ThreadCreator threadCreator4 = new ThreadCreator("E");
        ThreadCreator threadCreator5 = new ThreadCreator("F");
        ThreadCreator threadCreator6 = new ThreadCreator("H");
        //Thread leri baslatmak icin
//        threadCreator1.start();
//        threadCreator2.start();
//        threadCreator3.start();
//        threadCreator4.start();
//        threadCreator5.start();
//        threadCreator6.start();

        service.execute(threadCreator1);
        service.execute(threadCreator2);
        service.execute(threadCreator3);
        service.execute(threadCreator4);
        service.execute(threadCreator5);
        service.execute(threadCreator6);

        service.shutdown();//Havuzdaki thread ler is icin hazir halde beklemeye
        //devam eder.Bu sebeple kaatiyoruz





    }

}

class ThreadCreator extends Thread{

    private String name;

    public ThreadCreator(String name) {
        this.name =name;
    }

    @Override
    public void run() {
        String threadName=Thread.currentThread().getName();
        System.out.println(threadName+" başladı");
        System.out.println(threadName+" "+ name+ " işini yapıyor.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadName+ " işini bitirdi." );
    }
}

















