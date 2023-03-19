package Generic.methods;

import java.util.Arrays;

public class GenericMethod {
    public static void main(String[] args) {
        Integer[] intArr={1,23,4,65,9};
        Double[]  doubleArr={0.5,2.3,45.9,11.75};
        String[]  strArr={"Java","harika","bir","programlama","dili:)"};

        printArr(intArr);
        printArr(doubleArr);
        printArr(strArr);

        //generic ile yazdirma
        printAllArr(intArr);
        printAllArr(doubleArr);
        printAllArr(strArr);
        System.out.println("*************");
        int n =getFirst(intArr);
        System.out.println(n);
        double d = getFirst(doubleArr);
        System.out.println(d);
        String s = getFirst(strArr);
        System.out.println(s);
        System.out.println("Birden Fazla generic tip Kullanan");
        int num = 55;
        String t = "Ali";
        printArrAndObject(intArr,t);
        printArrAndObject(strArr,t);


    }
    //Arrayi yazdirmak icin method olusturuyoruz

    public static void printArr(Integer[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }
    public static void printArr(Double[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }
    public static void printArr(String[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }
    //generic metod
     public static <T> void printAllArr(T[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }
    //sonuc donduren method
    public static <T> T getFirst(T[] arr){
        T first = arr[0];
        return  first;
    }
    //Eger metodun iki farkli parametresi
    //Birden generic tip parametremesi alan method
    public static <T,S> void printArrAndObject(T arr[],S object){
       // arr[0] = object;//CTE object T data type inda olmalidir.

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
        System.out.println(object);
    }
    public static <S,U> S methodIsmi(U object){
        S s = null;
        return s;
    }





























}
