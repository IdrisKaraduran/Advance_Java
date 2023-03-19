package Bounding;

import java.util.ArrayList;
import java.util.List;

public class GenericLowerBoundWildcard {
    public static void main(String[] args) {
        System.out.println("***************Wildcard ile alt sinir***************");
        List<Integer> integerList = new ArrayList<>();
        addElemans(integerList);
        System.out.println(integerList);

        List<Number> numberList = new ArrayList<>();
        addElemans(numberList);
        System.out.println(numberList);

        List<Double> doubleList = new ArrayList<>();
        //addElemans(doubleList);//doubleList i kabul etmez cunku integer ve ustu kabul eder.
        System.out.println(doubleList);
        List<String> strList = new ArrayList<>();

        System.out.println("***************Wildcard ile ust sinir***************");
        multiplyByTwo(integerList);
        multiplyByTwo(doubleList);
        multiplyByTwo(numberList);

        System.out.println("*****************WildCard veya Object Class i************");
        printElement(strList);

        List<Object> objectList = new ArrayList<>();
        printElementIsObject(objectList);
        //printElementIsObject(strList);//Kabul etmez.Cunku object butun class larin atasidir
        //dogrudur ama List<Object> yapisi List<String> in parent i degildir.
        //Siralamaya bak.Hoca soyleyemedi.







    }
    //Integer data type nin super classlari(parentlari) ile olusturulan liste eleman ekleme
    //Integer ,Number,Object
    //wildcard : ? bilinmeyen data tipi
    public static void addElemans(List<? super Integer> list){
        for(int i=1; i<=10; i++){
            list.add(i);
        }
    }
    //UpperBound icinde wildcard kullanabilir miyiz.
    public static void multiplyByTwo(List<? extends Number> list){
        //list.add(1);//Listte degisiklige izin vermez.
        list.stream().map(t-> (t.doubleValue()*2)).forEach(t-> System.out.print(t+"*"));
    }
    //wildcard kisitlamasi
    //wildcard okunabilirligi artirir ancak bazi kisitlamalri var
    public static void printElement(List<?> listOfUnknown){
        //listOfUnknown.add("Java");//? isareti olan tur bilinmedigi icin izin vermiyor
        //add gibi eklemelere izin vermez.
        //Salt okunur degil ama oyle dusunulebilir.
        //Turle alakali olmayan islemlere izin veriyor. size  clear,remove gibi
        int a= listOfUnknown.size()+3;
        listOfUnknown.add(null);//bunu niye kabul etti.Null herhangi bir data type degil o yuzden
        for(Object w : listOfUnknown){
            System.out.println(w);
        }

    }
    public static void printElementIsObject(List<Object> listOfUnknown){
        listOfUnknown.add(2);
        listOfUnknown.add("A");//eklemelere izin verir.
        for(Object w : listOfUnknown){
            System.out.println(w);
        }
    }

    //? ile T ayni manada degildir.




}
