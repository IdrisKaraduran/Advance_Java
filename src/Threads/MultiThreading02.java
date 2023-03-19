package Threads;
//threadler aynı anda aynı kaynağa erişip değişiklik yapmak isterlerse ne olacak?
//multithreading programlamada birden fazla thread aynı kaynağa(critical section) aynı anda erişip değişiklik yapmaya çalışırsa
//istenmeyen sonuçlar olur. Bu durumda threadlere sırayla erişim verilir. Yani ortak kaynağı bir thread kullanırken diğer
//thread beklemelidir. Bu işlem syncronized keywordü ile gerçekleştirlir.
//synchronized ile metoda erişen threadleri sıraya koymuş oluruz.
//yani metodu aynı anda sadece bir thread kullanabilsin
//Bu methoda bir thread ulasirsa bu method'u kilitle,
//o thread'in islemi tamamlandiginda baska bir thread ulasabilsin,
// islemi tamamlanmadan baska bir thread ulasamasin!

public class MultiThreading02 {
    public static int counter = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"calist1");
                Counter.cont();
            }
        });
        thread1.setName("Tom");
        thread1.start();
//        try {
//            thread1.join();//Bu durumda synroniazed gibi sirayla yapar.
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//Tom un butun islemleri bitirmesi icin Jerry nin beklemesine gerek yok.Sadece
        //count methodunu sirayla kullanmalari yeterlidir.

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"Calisti 2");
                Counter.cont();
            }
        });
        thread2.setName("Jerry");
        thread2.start();
    }

}
class Counter{
    //counter degerini 1000 kez artir.
    public static synchronized void cont(){
        for(int i=1; i<=1000;i++){
            MultiThreading02.counter++;
            System.out.println(Thread.currentThread().getName()+ " "+ MultiThreading02.counter);
        }

    }

}