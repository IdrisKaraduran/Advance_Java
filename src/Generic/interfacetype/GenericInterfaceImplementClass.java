package Generic.interfacetype;
//eger bir generic type daki nir interface i implement ederse bu
//class in da generic olmasi gerekir.Ikisi de ayni olmali T gibi
public class GenericInterfaceImplementClass<T> implements GenericInterface<T>{


    @Override
    public void printValues(T type) {

    }

    @Override
    public T generic() {

        return null;
    }
}
