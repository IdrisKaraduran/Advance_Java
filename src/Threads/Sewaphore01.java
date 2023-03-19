package Threads;

import java.util.concurrent.Semaphore;

/*
Semaphore, birden fazla thread ortak bir kaynağa erişmeye çalıştığında
erişebilen thread sayısını sınırlandırmamıza yarar.
Synchronized keyword'u ile ortak kaynağa aynı anda sadece bir thread'in erişmesini
sağlarken semaphore ile n tane thread'e erişim izni verilebilir
 */
public class Sewaphore01 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);

        Car car1 = new Car("Audui",5000,semaphore);
        Car car2 = new Car("Honda",5000,semaphore);
        Car car3 = new Car("Volvo",5000,semaphore);
        Car car4 = new Car("Mercedes",5000,semaphore);
        Car car5 = new Car("Opel",5000,semaphore);
        Car car6 = new Car("Toyata",5000,semaphore);
        Car car7 = new Car("BMW",5000,semaphore);
        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
        car7.start();




    }


}
class Car extends Thread{
    private String carName;
    private int duracation;
    Semaphore semaphore;

    public Car(String carName, int duration, Semaphore semaphore) {
        this.carName = carName;
        this.duracation = duracation;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            System.out.println(carName + "Park etmek istiyor.");
            semaphore.acquire();//Erisim icin izin talep ediyor.

            System.out.println(carName+" park etti" );
            Thread.sleep(duracation);
            System.out.println(carName + " yerinden ayrildi.");
            semaphore.release();
            //Belirlenmis oldugumuz limit kadar threade acquare ve relase
            //metodlari arasindaki kodlara izin verir

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }






}
