package com.tutorials.staticKeyword;

/*
 This code inside static block is executed only once:
 the first time you make an object of that class or the first time you access a static member of that class
 (even if you never make an object of that class).
 For example, check output of following Java program.
 */

class Test {
    static int i;
    int j;

    // start of static block
    static {
        i = 10;
        System.out.println("static block called ");
    }
    // end of static block
}

public class StaticBlocks {
    public static void main(String[] args)
    {
        System.out.println(Test.i);
    }
}
