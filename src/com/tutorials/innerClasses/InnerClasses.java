package com.tutorials.innerClasses;
/*
KEY CONCEPTS:
-------------

//One inner class can extend another inner class of the same class.

class OuterClass
{
    class InnerClassOne
    {
        int x = 10;

        void methodOfInnerClassOne()
        {
            System.out.println("From InnerClassOne");
        }
    }

    class InnerClassTwo extends InnerClassOne
    {
        //One Inner Class can extend another inner class
    }
}

public class InnerClasses
{
    public static void main(String args[])
    {
        OuterClass outer = new OuterClass();   //Instantiating OuterClass

        OuterClass.InnerClassTwo innerTwo = outer.new InnerClassTwo();  //Instantiating InnerClassTwo

        System.out.println(innerTwo.x);    //Accessing inherited field x from InnerClassOne
        innerTwo.methodOfInnerClassOne();  //calling inherited method from InnerClassOne
    }
}

//An inner class can be extended by another class outside of it’s outer class.
//If you are extending static inner class (Static nested class), then it is a straight forward implementation.
//If you are extending non-static inner class, then sub class constructor must explicitly call super class constructor
//using an instance of outer class. Because, you can’t access non-static inner class without the instance of outer class.


class OuterClass
{
    static class InnerClassOne
    {
        //Class as a static member
    }

    class InnerClassTwo
    {
        //Class as a non-static member
    }
}

//Extending Static inner class or static nested class
class AnotherClassOne extends OuterClass.InnerClassOne
{
    //static nested class can be referred by outer class name,
}

//Extending non-static inner class or member inner class
class AnotherClassTwo extends OuterClass.InnerClassTwo
{
    public AnotherClassTwo()
    {
        new OuterClass().super();  //accessing super class constructor through OuterClass instance
    }
}

//When an outer class is extended by it’s sub class,
//Member inner classes will not be inherited to sub class.
//To use inner class properties inside the sub class of outer class,sub class must also have an inner class and that inner class must extend inner class of the outer class. For example,


class OuterClass
{
    int x;

    void methodOfOuterClass()
    {
        System.out.println("From OuterClass");
    }

    //Class as a member
    class InnerClass
    {
        int y;
    }
}

class AnotherClass extends OuterClass
{
    //Only fields and methods are inherited.
    // To use inner class properties,
    //it's inner class must extend inner class of it's super class
    class AnotherInnerClass extends InnerClass
    {
        //Inner Class of AnotherClass extends Inner Class of OuterClass
    }
}

public class InnerClasses
{
    public static void main(String args[])
    {
        AnotherClass anotherClass = new AnotherClass();  //creating AnotherClass Object

        System.out.println(anotherClass.x);    //accessing inherited field x from OuterClass

        anotherClass.methodOfOuterClass();    //calling inherited method from OuterClass

        //Using the properties of InnerClass

        AnotherClass.AnotherInnerClass anotherInnerClass = anotherClass.new AnotherInnerClass();

        //creating object to AnotherInnerClass

        System.out.println(anotherInnerClass.y);  //accessing inherited field y from InnerClass

    }
}
//Inner class can extend it’s outer class.
//But, it does not serve any meaning.
//Because, even the private members of outer class are available inside the inner class.Even though, When an inner class extends its outer class, only fields and methods are inherited but not inner class itself.


class OuterClass
{
    int x;

    void methodOfOuterClass()
    {
        System.out.println("From OuterClass");
    }

    //Class as a member
    class InnerClass extends OuterClass
    {
        //only fields and methods are inherited, but not member Inner Classes
    }

    class InnerClassOne
    {
        //another class as a member
    }
}

public class InnerClasses
{
    public static void main(String args[])
    {
        OuterClass outer = new OuterClass();
        //You have to create OuterClass object to access non-static inner class

        OuterClass.InnerClass inner = outer.new InnerClass();  //creating object to InnerClass

        System.out.println(inner.x);   //accesiing inherited field x

        inner.methodOfOuterClass();   //accessing inherited method
    }
}
*/
public class InnerClasses {
    public static void main(String[] args)
    {
        System.out.println("Key concepts on innerClasses in multi-line comments");
    }
}
