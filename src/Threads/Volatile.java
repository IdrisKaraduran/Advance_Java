package Threads;

public class Volatile {
/*
Birden fazla thread ayni degiskende
degisiklik yaparken CPU uzerinde farkli cekirdeklerde calisabilir.
Degiskenin bilgisi hiz kazanmak icin main memory yerine cekirdegin
cachinde tutulursa bir thread in yaptigi guncellemeden diger thread lerin
haberi olmayabilir.Degisken bilgisinin cach yerine main memory ye
yazilip oradan cagrilmasini saglamak icin Volatile keyword kullanilir.
Dolayisiyla heer thread in guncellemleri gormesi garanti altina alinir.
 */

    public volatile  static int flag =0;
    //Degisken bilgidsinin main memory de tutulmasini sagliyor.

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(flag==0){//flag degeri 1.cachde tutulursa
                    System.out.println("Thread1 calisiyor.");
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                flag =1;//flag degeri 2.cachde tutulursa
                System.out.println("Flag degisken degeri 1 olarak degisti.");
            }
        });
        thread2.start();
        //Iki ayri cekirdegin cach inde flag degeri tutulursa threadler guncel
        //degerleri goremeyebilirler.

    }



}
