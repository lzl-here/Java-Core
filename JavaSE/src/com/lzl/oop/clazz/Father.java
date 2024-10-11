package com.lzl.oop.clazz;

public class Father {
    static {
        System.out.println("static Father block");
    }

    public Father(){
        System.out.println("construct Father");
    }

    {
        System.out.println("dynamic Father block");
    }
}
