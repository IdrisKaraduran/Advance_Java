package Enums;

public enum TransactionTypeEnum {
    DEPOSIT(10),//0
    WITHDRAW(20),//1
    TRANSFER(30),
    PAYMENT(40),
    OTHER(50);

    private final int code;

    public int getCode() {
        return code;
    }

    private TransactionTypeEnum(int code){//Default olarak private dir
        this.code = code;
    }





}
