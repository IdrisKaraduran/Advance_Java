package Threads;
   //metod icerinde istenmeyen sonuca sebep olmayan kodlar da var
public class SynchronizedKeyword {
       public static void main(String[] args) {
          long start = System.currentTimeMillis();

           Brackets1 brackets1 = new Brackets1();
           Thread thread1 = new Thread(new Runnable() {
               @Override
               public void run() {
                   for(int i=1; i<=9; i++){
                       brackets1.genereteBracket();
                   }
               }
           });

           thread1.start();
           Thread thread2 = new Thread(new Runnable() {
               @Override
               public void run() {
                   for(int i=1; i<=9; i++){
                       brackets1.genereteBracket();
                   }
               }
           });
           thread2.start();
           try {
               thread1.join();
               thread2.join();
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }

           long finish = System.currentTimeMillis();
           System.out.println("Fark : " +(finish-start));
       }



}
class Brackets1{
    //[[[[[]]]]] şeklini ekrana yazdıran bir metod
    public void genereteBracket(){
        synchronized (this) {
            for (int i = 1; i <= 10; i++) {
                if (i <= 5) {
                    System.out.print("[");
                } else {
                    System.out.print("]");
                }
            }
            System.out.println();
        }
        //Bütün metodu kilitlemek yerine,metot icerisinde kilitlemek
        // istedigimiz yeri bir scope araligina alip  synchronized (this) keyword unu kullaniyoruz
        //asenkron calismasinda problem olmayan kodllar
        for(int i=1; i<=5;i++){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
