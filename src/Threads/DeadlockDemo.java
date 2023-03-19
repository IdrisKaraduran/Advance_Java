package Threads;
/*
Olumcul kilitlenme:Iki veya daha fazla islemlerini tamamlamak icin birbirinin
kilitlemis oldugu kaynaklara erismek istemesi gibi dururmlarda olusur. Bu da projenin calismasini
engeller.Genellikle icice synronazi blok kullanildiginda yasanir.
 */
public class DeadlockDemo {
    public static void main(String[] args) {
        String obje1 = "Kahve";
        String obje2 = "Seker";
        Thread thread1= new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obje1){
                    System.out.println(Thread.currentThread().getName()+ " "+ obje1+ " i kullaniyor");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+ obje2+ "i istiyor");
                    synchronized (obje2){
                        System.out.println(Thread.currentThread().getName()+ " kahvesini istiyor");
                    }
                }
                System.out.println(Thread.currentThread().getName()+ " kahvesini iciyor");
            }
        });
        thread1.setName("Slwester");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obje2){
                    System.out.println(Thread.currentThread().getName()+ obje2 + " kullaniyor");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+ obje1+ " i istiyor");
                    synchronized (obje1){
                        System.out.println(Thread.currentThread().getName()+ obje1+ " kullaniyor");

                    }
                }
                System.out.println(Thread.currentThread().getName()+" kahvesini iciyor");

            }
        });
        thread2.setName("Twity");
        thread2.start();

    }

}
