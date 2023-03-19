package Serialization;

import java.io.*;

public class Serialization_Dieserialization {

    public static void main(String[] args) {
       //OObjectOutputStream Java objelerini kodlar ve karsilik gelen akislari olusturur
        //Bu isleme serialization denir.
        writeObject();
        readObject();

    }
    //User aldigim objeleri jvm disinda bir dosyaya yazdirma
    public static void  writeObject(){
        System.out.println("User objeleri olusturuluyor.");
        User u1 = new User(1,"Ferit","123456789");
        User u2 = new User(2,"Necmi","123456789");
        User u3 = new User(3,"Saban","123456789");
        User u4 = new User(4,"Mahmut","123456789");
        //Olusturdugumuz objeleri serialization yapabilmek icin User class a
        //implements Seriable yapmamaiz gerekir
        //Objelerin yazilacagi dosyayi olusturmak icin
        try {
            FileOutputStream fos = new  FileOutputStream("idris.txt");
            //Objeleri yazmak icin
            ObjectOutputStream output = new ObjectOutputStream(fos);
            //OOS objelerin akisa yazdirabilmesi icin Objelerin classi
            //Seriable interface ini implement etmesi gerekir
// OOS'in objeleri akışa yazdırabilmek için objelerin classı Serializable interface'ini
// implement etmiş olmalı.Çünkü objelerin serileştirilmesi gerekir.
            output.writeObject(u1);
            output.writeObject(u2);
            output.writeObject(u3);
            output.writeObject(u4);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //read object objeleri okuma
    //DieSerialiazation
    public static void readObject(){
        //Okumak istedigimiz dosyayi oncelikle belirtmemiz gerekiyor.
        try {
            FileInputStream fis = new FileInputStream("idris.txt");
            //Bu dosya icindeki objeleri okumak icin
            ObjectInputStream input = new ObjectInputStream(fis);

            User user1 = (User)input.readObject();
            User user2 = (User)input.readObject();
            User user3 = (User)input.readObject();
            User user4 = (User)input.readObject();
            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user3);
            System.out.println(user4);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }




}
