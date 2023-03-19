package Serialization;

import java.io.Serializable;

public class User implements Serializable {
//Bu class in serialization edilebilsin dedik.Implemets ederek
    private long id;
    private String isim;
    private String tcNo;

    //constructor


    public User(long id, String isim, String tcNo) {
        this.id = id;
        this.isim = isim;
        this.tcNo = tcNo;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", isim='" + isim + '\'' +
                ", tcNo='" + tcNo ;
    }
}
