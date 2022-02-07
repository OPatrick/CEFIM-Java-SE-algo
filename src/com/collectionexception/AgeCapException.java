package com.collectionexception;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 07/02/2022
 * Time: 12:13
 */
public class AgeCapException extends Exception {

    private String msg;

    public AgeCapException(String message) {
        super(message);
        this.msg = message;
    }

    public String toString() {
        return this.msg + " ans n'est pas un âge valide";
    }
}
