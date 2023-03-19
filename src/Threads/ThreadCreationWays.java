package Threads;

public class ThreadCreationWays {

    public static void main(String[] args) {
        //Ilk calisanthread maiin thread dir.
        System.out.println("Current Thread : "+ Thread.currentThread().getName());

        MyThread thread1 = new MyThread();
       // thread1.start();//Yeni olusturdugumuz thread calismaya basliyor.
        thread1.run();//Bunu tek cagirirsak thread olusmaz.Bu yuzden once start()
        //metodunu cagirmaliyim.
        // thread1.run();    // herhangi bir methodu çağırdıgımız
        // gıbı cagırdıgımızda thread oluşmaz, sadece method gibi çalışır
        //Hazir hale gelen thread yapisinin cagirilabilmesi icin, calisabilmesi icin start()'in cagirilmasi gerekir.
//start(), run() method'unu cagirir.
//Direk run() cagirilabilir, run() icindeki thread daki code lar calisir ancak thread olusmamis olur
//Direk run() cagirildiginda yine senkron sekilde calisir.
        //start metodu threar oluşturur, override edilen run metodunu çağırır ve içerisindeki işlemleri
        //gerçekleştirir.
        //doğrudan run metodu çağrıldığında içindeki işlemler yapılır ancak thread oluşmaz. Yani run metodu main
        //thread içinde çalışmış olur.

        myRunnable myRunnable1 = new myRunnable();
        Thread thread2 = new Thread(myRunnable1);
        thread2.start();

        //Annonymous class ile thread olyusrturma
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);//5 saniye uyutabiliyoruz.
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Current : "+Thread.currentThread().getName());
                System.out.println("Bu thread isimsiz class ile olusturuldu.");
            }
        });
        thread3.setName("Threadcik");
        thread3.start();

        //lambda expression kullanarak
        Thread thread4 = new Thread(()->{
            Thread.currentThread().setName("Harika");
            System.out.println("Current thread  " + Thread.currentThread().getName());
            System.out.println("Bu thread lambda ile olusturuldu.");
        }
        );
        thread4.start();

        Thread thread5 = new Thread(()->{
            Thread.currentThread().setName("Harika");
            System.out.println("Current thread  " + Thread.currentThread().getName());
            System.out.println("Bu thread lambdaa ile olusturuldu.");
        });
        thread5.start();

        System.out.println("main method un islemi bitti.");


    }

}
//1.Yol Thread Olusturmanin yolu Thread Class ina extends ederek
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("My Thread calisiyor...");
    }
}
//2.Yol
//Runnable Interface ine implements ederek.

class myRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("My Runnable ile olusturdugumuz thread calisiyor.");
    }



}































