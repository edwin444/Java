package com.tutorials.innerClasses;

interface something
{
    int some();
}

public class PassingAnonInnerClassAsArgument {
    //note:here anonymous inner class object is passed as an argument
    //     one point to observe here is that the something s argument
    //     in the function is equated to the object of anonymous
    //     inner class object which is the child of something
    //     so basically parent p=new child()
    //     a parent object can access any function that is common
    //     to both child and parent. The overriden child function
    //     is given more preference there.Here the anonymous class
    //     object redefines the parent method some and hence
    //     that definition is taken by s.some.
    public void disp(something s)
    {
        System.out.println(s.some()+": This is the message");
    }
    public static void main(String args[])
    {
        PassingAnonInnerClassAsArgument f=new PassingAnonInnerClassAsArgument();
        f.disp(new something()
        {
            public int some()
            {
                return 10;
            }
        });

    }
}
