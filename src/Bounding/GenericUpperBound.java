package Bounding;
//Parametre olarak aldigimiz data tipini sinirlandirabiliriz.
//Bu class da sadece Number in child lari kullanilsin istiyorum
public class GenericUpperBound<T extends Number> {
    //T:integer ,Double, Long, Float: class i ustten sinirlandirdik.

    private T[] numberArray;//field ozellik.

    public GenericUpperBound(T[] numberArray) {
        this.numberArray = numberArray;
    }

    //number array icindeki degerlerin ort.bul
    public double avgArray(){
        double sum = 0;
        for(T t: this.numberArray){
            sum+=t.doubleValue();
        }
        double ort = sum/numberArray.length;
        return ort;
    }

    //main metodu
    public static void main(String[] args) {
        Integer[] intArr ={2,3,5,7};
        Double[] doubleArr={3.2,5.3,8.7,9.0};
        String[] strArr={"Generic","Turleri","Ustten","Sinirlandirabiliriz"};


        GenericUpperBound<Integer> obj1 = new GenericUpperBound<>(intArr);
        System.out.println(obj1.avgArray());

        GenericUpperBound<Double> obj2 = new GenericUpperBound<>(doubleArr);
        System.out.println(obj2.avgArray());

        //GenericUpperBound<String> obj3 = new GenericUpperBound<String>();//CTE data type tipinni number ile sinirlandirdik.



    }
    //Jvm platformdaki bir objeyi jvm disina aktarip taninmasini byte lara
    //cevrilerek kaydeddilir. Buna serialization denir .Bunlarin tekrar
    //JVM icine alinmasina Die Serialization denir.




}

