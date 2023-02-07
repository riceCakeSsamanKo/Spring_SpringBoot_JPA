package jpabook.jpashop.exception;

public class NotEnoughStockExceoption extends RuntimeException{

    public NotEnoughStockExceoption() {
        super();
    }

    public NotEnoughStockExceoption(String message) {
        super(message);
    }

    public NotEnoughStockExceoption(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughStockExceoption(Throwable cause) {
        super(cause);
    }
}
