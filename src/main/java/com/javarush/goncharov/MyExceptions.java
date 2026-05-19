package com.javarush.goncharov;

public class MyExceptions extends RuntimeException {
    public MyExceptions() {

    }
    public MyExceptions(Throwable cause) {
        super(cause);
    }
    public MyExceptions(String message) {
        super(message);
    }
    public MyExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
