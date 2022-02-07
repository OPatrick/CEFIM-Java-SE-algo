package com.collectionexception;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 07/02/2022
 * Time: 11:48
 */
public class ListEmptyException extends Exception {

    public String toString() {
        return "This list is empty";
    }
}
