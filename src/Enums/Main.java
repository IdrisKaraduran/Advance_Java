package Enums;

public class Main {
    public static void main(String[] args) {
        useNonEnumVariable(1);
        useNonEnumVariable(2);
        useNonEnumVariable(3);
        useNonEnumVariable(4);
        useNonEnumVariable(5);
        useNonEnumVariable(100);//CTE yada baska uyari olmaliydi.

        useEnumType(TransactionTypeEnum.DEPOSIT);
        System.out.println("******");
        useEnumType(TransactionTypeEnum.WITHDRAW);
        useEnumType(TransactionTypeEnum.PAYMENT);
        useEnumType(TransactionTypeEnum.TRANSFER);
        useEnumType(TransactionTypeEnum.OTHER);
        //useEnumType(aaaaa);//enum type disinda baska deger giremiyorum cte veriyor.
        //Bus ecenekler disinda kullanamazsin

    }
    public static void useNonEnumVariable(int n){
        if(n == TransactionTypeConstant.DEPOSIT){
            System.out.println("Para yatiriliyor");
        }else if(n == TransactionTypeConstant.WITHDRAW){
            System.out.println("Para cekiliyor");
        }else if(n == TransactionTypeConstant.TRANSFER){
            System.out.println("Para transfer ediliyor");
        }else if(n == TransactionTypeConstant.PAYMENT){
            System.out.println("Para transfer ediliyor");
        }else if(n == TransactionTypeConstant.OTHER){
            System.out.println("Diger islemler");
        }
    }

    public static void useEnumType(TransactionTypeEnum transactionTypeEnum){
        //Ordinal kullanmanin bir riski var.Yeni bir sey gelirse sira degisir.
        //Sona eklenmeyip basa yada ortaya eklerse yanlislik cikar.
        //Guncelleme de sira egisebilir.
//        if(transactionTypeEnum.ordinal() == 1){
//            System.out.println("Para Yatirms Ordinalli");
//        }
 //       if(transactionTypeEnum.getCode()==10){
//            System.out.println("Para yatırılıyor...");
//        }
        if(transactionTypeEnum == TransactionTypeEnum.DEPOSIT){
            System.out.println("Para yatiriliyor");
        }else if(transactionTypeEnum == TransactionTypeEnum.WITHDRAW){
            System.out.println("Para cekiliyor");
        }else if(transactionTypeEnum == TransactionTypeEnum.TRANSFER){
            System.out.println("Para transfer ediliyor");
        }else if(transactionTypeEnum == TransactionTypeEnum.PAYMENT){
            System.out.println("POdeme gercejklesiyor");
        }else if(transactionTypeEnum == TransactionTypeEnum.OTHER){
            System.out.println("Diger islemler");
        }
        System.out.println("Ismi " +transactionTypeEnum.name());
        System.out.println(transactionTypeEnum.ordinal());
    }
}
