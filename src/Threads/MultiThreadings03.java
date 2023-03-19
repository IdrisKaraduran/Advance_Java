package Threads;

public class MultiThreadings03 {

    public static void main(String[] args) {
        Brackets brackets = new Brackets();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
               for (int i=1; i<=9; i++){
                   brackets.genereteBracket();
               }
            }
        });
        thread1.start();
        thread1.setName("Idris");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1; i<=9; i++){
                    brackets.genereteBracket();
                }
            }
        });
        thread2.start();
        thread2.setName("Esra");
//iki thread aynı anda methoda erişmeye çalıştığında methodun içindeki işlem
//tamamlanmadan diğer thread işleme başlayabiliyor bu sebeple sırayla erişmelerini istiyoruz
    }
}
class Brackets{
    //[[[[[]]]]] şeklini ekrana yazdıran bir metod
    public void genereteBracket(){
        for (int i=1; i<=10; i++){
            if(i<=5){
                System.out.print("[");
            }else {
                System.out.print("]");
            }
            System.out.print(Thread.currentThread().getName());
        }
        System.out.println();
    }
}
