package Generic.clases;
//Iki data tipini parametre olarak kullanmak istersek
public class GenericClassTwoParam<S,U> {

    private S s;
    private U u;

    public S getS() {
        return s;
    }

    public void setS(S s) {
        this.s = s;
    }

    public U getU() {
        return u;
    }

    public void setU(U u) {
        this.u = u;
    }
}
