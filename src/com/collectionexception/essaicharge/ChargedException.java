package com.collectionexception.essaicharge;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 08/02/2022
 * Time: 09:57
 */
public class ChargedException extends Exception {

    private int errorNumber;
    private Object o;

    public int getErrorNumber() {
        return errorNumber;
    }

    public Object getO() {
        return o;
    }


    public ChargedException(String message, int errorNumber) {
        super(message);
        this.errorNumber = errorNumber;
    }

    public ChargedException(String message, int errorNumber, Object o) {
        super(message);
        this.errorNumber = errorNumber;
        this.o = o;
    }
}
