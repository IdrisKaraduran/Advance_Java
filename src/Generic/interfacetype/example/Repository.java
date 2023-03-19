package Generic.interfacetype.example;
//generic data type olarak primitive data type kullanilmaz
//genericlerde sadece non primitive data type verebiliriz.

public interface Repository<T> {
    void save(T type);

    T kayit();
}
