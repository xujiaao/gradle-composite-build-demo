package com.xujiaao.gradle.composite.lib1;

public class Lib1 {

    private Lib1() {
        // hide.
    }

    public static String getMessage() {
        return String.format("Hello %s", Lib1.class.getSimpleName());
    }
}