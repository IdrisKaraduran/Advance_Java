package Generic.clases;

public class Runner {
    public static void main(String[] args) {
        NonGenericClass nonGenericClass1 = new NonGenericClass();
        NonGenericClass nonGenericClass2 = new NonGenericClass();

        nonGenericClass1.setObject("Idris Karaduran");
        nonGenericClass2.setObject(123);


        String str = (String) nonGenericClass1.getObject();
        //Cast Problemi var
        System.out.println(str);

        //String str2 = (String) nonGenericClass2.getObject();
        //System.out.println(str2);

        Integer bumber = (Integer) nonGenericClass2.getObject();
        System.out.println(bumber);


    }
}
