package com.tutorials.staticKeyword;
/*
If inner class is:
1) protected : Its accessible by any class that derives from the outer class and the outer class itself.
2  private: Its accessible by only the outer class
3) public: Accessible even outside the outer class accross packages
4) default: Accessible even outside the outer class but within the same package.
 */

public class StaticInnerClassDemo {
    public static class Foo{
        int id;
        public Foo(){
            this.id = 10;
        }
    }

    private static class Foo1{
        int id;
        public Foo1(){
            this.id = 20;
        }
    }

    //accessing static inner class by the class name
    Foo f = new Foo();
    Foo1 f1 = new Foo1();
    public void printValues()
    {
        System.out.println(f.id +" "+f1.id);
    }

}


class Main{
    public static void main(String[] args)
    {
        /*
        Notice, I have used the outerclassname.innerclassname  varname = new outerclassname[no brackets here as we are accessing static member].innerclassname();
         */
        //accessing private inner class is not allowed
        //StaticInnerClassDemo.Foo1 temp1= new StaticInnerClassDemo.Foo1();

        //accessing public inner class is allowed
        StaticInnerClassDemo.Foo temp2= new StaticInnerClassDemo.Foo();

    }
}