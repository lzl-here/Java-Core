package com.lzl.oop.clazz;

public class Son extends Father{
    static {
        System.out.println("static Son block");
    }

    public Son(){
        System.out.println("construct Son");
    }

    {
        System.out.println("dynamic Son block");
    }
}
