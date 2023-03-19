package Generic.clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Ayni class farkli data type lari ile  kullanabildim
public class GenericRunner {
    public static void main(String[] args) {
        //Genericler ile hangi data typeni kullanacagimiza biz karar veririz.
        GenericClass<String> obj1 = new GenericClass<String>();
        //Java 7 ile birlikte sag tarafta data type ini yazmaya gerek kalmadi.

        obj1.setType("Generic Class");


        GenericClass<String> obj2 = new GenericClass<>();
       // obj2.setType(65);//String gerekliyken int vermeye calistigimiz icin oldu.
        GenericClass<Integer> obj3 = new GenericClass<>();
        obj3.setType(65);
        int num = obj3.getType();//Casting e gerek kalmadi.


        List<String> list = new ArrayList<>();
        list.add("Idris");
        list.add("Esra");

        //list.add(123);//String dedigimiz icin baska data type i kabul etmiyor
       // list.get(2);
       // list.get(3);//Kabul etseydi ClassCastException dan kurtulduk.

        //Class generic olarak tanimlanmadiginda class icinde generic yapi kullanilmaz.

        Map<Integer,String> map1 = new HashMap<>();
        map1.put(1,"Java");


      //  *************************************************
        GenericClassTwoParam<String,Integer> myMap = new GenericClassTwoParam<>();
        myMap.setS("Generic");
        myMap.setU(99);
        System.out.println(myMap.getS());
        System.out.println(myMap.getU());


    }










}
