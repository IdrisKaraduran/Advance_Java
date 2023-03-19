package Threads;
/*
Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.
*/
public class WaitNotify {

    public static int balance = 100;
    public static void main(String[] args) {

        WaitNotify obj = new WaitNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(1000);
            }
        });
        thread1.setName("Ogrenci");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(1000);
            }
        });
        thread2.setName("veli");
        thread2.start();


    }
    //para cekme islemi icin method olusturalim
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" para cekmek istiyor");

        if(balance <0 || balance < amount){
            System.out.println("Bakiye yetersiz..." + balance);
            System.out.println("Bakiyenin guncellemsi bekleniyor");
            try {
                wait();
    //Hangi thread aktif ise gecici olarak beklemeye alinir.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //bakiye yeterliyse
        if(balance>= amount){
            balance=balance-amount;
            System.out.println("Para cekme islemi gerceklesti.");
            System.out.println("Yeni bakiye : "+ balance);
        }else{
            System.out.println("Bakiye yetersiz : "+ balance);
        }

    }

    //paera yatirma methodu
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+ "para yatirmak istiyor");
        balance=balance+amount;
        System.out.println("Mevcut balance : "+ balance);
        notify();
        //Objeyi serbest birakmaz hala yapilacak isler varsa
        //isleri yapar ondan sonra serbest birakir.
        System.out.println();
    }
}
