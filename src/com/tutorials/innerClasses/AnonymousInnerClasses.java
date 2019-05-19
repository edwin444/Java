package com.tutorials.innerClasses;

import java.util.Scanner;

/*anonymous inner classes are used for instant use only
  Whenever its a one time requirement we use the
  anonymous inner class rather that creating a
  top level class.
  based on declaration and behaviour there are
  3 types of anonymous inner classes
  1)that extends a class.
  2)that implements a class.
  3)anonymous inner class that defined inside arguments.
  example:
  PopCorn p=new PopCorn()
  {

  };
  Here we are creating an anonymous inner class
  that extends/implements the PopCorn class based on whether
  the popcorn class is interface or not.The object is of
  the anonymous class as specified by the RHS. However
  the reference on the LHS is of the parent class.



*/
abstract class car
{
    public int a=10;
    public void disp()
    {
        System.out.println("The instance variable: "+this.a);

    }
    public abstract void seta();
}
interface vehicle
{
    void disp();

}
public class AnonymousInnerClasses {
    public static void main(String[] args)
    {
        //note: this statement wont
        //work as car is abstract class
		/*car c=new car();
		c.disp();
		*/


		/*here even though we write car c , an object of
		car isnt created rather an object of the anonymous inner
		class of the car abstract class is created
		using this object we provide implementation of the
		abstract method
		*/
        car c = new car()
        {
            public void seta()
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the value of a: ");
                int b = sc.nextInt();
                this.a=b;
            }
        };

        c.seta();
        c.disp();

		/*here we use another anonymous inner class so as to
		  implement an interface.*/
        vehicle v = new vehicle()
        {
            //note: that the methods defined inside an
            //interface are implicitly public
            //and the variables constant public
            //so the disp function that we override below
            //must contain the public keyword
            //as when we override, we can only increase
            //visibility and not decrease visibility
            //if we dont specify the public keyword then
            //the by default it is package protected
            //which has lower visibility as compared to the
            //public keyword for visibility.
            public void disp()
            {
                System.out.println("Implemented the interface from the inner class of the interface");
            }
        };
        v.disp();
		/*note: anonymous inner class is not
                        inner class of vehicle but
                        rather that of the MainFoo class.
                        So during compilation we
                        get the MainFoo$1.class
                        and not vehicle$1.class
                        the 1 stands for the unknown
                        identity of the child class
                 */
    }
}
