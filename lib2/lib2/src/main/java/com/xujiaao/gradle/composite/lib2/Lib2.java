package com.xujiaao.gradle.composite.lib2;

public class Lib2 {

    private Lib2() {
        // hide.
    }

    public static String getMessage() {
        return String.format("Hello %s", Lib2.class.getSimpleName());
    }
}