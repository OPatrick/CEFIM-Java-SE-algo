package com.livretest.pond.goose;

import com.livretest.pond.shore.Bird; // in a different package

public class Gosling extends Bird { // extends means create subclass
    public void swim() {
        floatInWater(); // calling protected member
        System.out.println(text); // calling protected member
    }
}
