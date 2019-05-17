package com.tutorials.exceptionHandling;

class Test extends RuntimeException
{

    public Test() {
        System.out.println("Called the custom defined class");
    }
    public Test(String s)
    {
        //calling the RuntimeException class constructor and passing the string s to it.
        super(s);
    }
}
public class Main {

    public static void main(String[] args) throws InterruptedException
    {
        doStuff();

        //Some more key points...
        /*
        Concept of runtime stack
        for every thread JVM will create a run-time stack
        Each and every method call performed by the thread will be stored
        in the stack.Each entry in the stack is called stack frame or
        activation record.After completing every method call the corr.
        entry from the stack will be removed.After completing all method
        calls the empty stack is destroyed by JVM just before terminating
        the thread.
        */

        /*inside a method if any exception occurs the method in which it
          rose is responsible to create exception object by including
          the following information
          1)name of exception
          2)description of exception
          3)location at which exception occurs

             after creating exception objec,method hands that object to the
         JVM,JVM will check whether the method contains any exception
         handling code or not.If the method doesnt contain exception
             handling code then JVM terminates that method abnormally
             and removes the corr. entry from the stack.
         Then jvm identifies caller method and checks if the caller
         method contains any handling code or not.if the caller method
             doesnt contain handling code then the jvm terminates the caller
             method also abnormally and removes the corr. entry from the stack
             This process will be continued until main method and if the
         main method also doesnt contain handling code then jvm terminates
             it abnormally and removes corresponding entry from the stack.
         Then jvm handovers responsibility of exception handling
             to default exception handler,which is the part of jvm.Default
             exception handler prints exception information in the
             following format and terminates program abnormally.*/

            //checked exceptions are those exceptions that are checked during
            //complile time
            //fully checked means all the children are checked
            //if only few of the children are checked means partially checked
            //unchecked means those not checked by compiler and arised during
            //run-time.
            //Customized exception handling using try-catch statements

            try
            {
                int x=10/0;
            }
            catch(Exception e)
            {
                System.out.println("Division by zero exception");

                //to print the stack trace
                e.printStackTrace();
                //to print the description of object
                System.out.println(e.toString());
                //to print only the error message
                System.out.println(e.getMessage());
            }
            finally
            {
                /*
                note:
                1)final: is a modifier for classes,methods and variables.
                  If a class is declared as final no inheritance is allowed
                  If a method is declared as final then we cant override the method in the child class
                  If a variable is declared as final then we cant perform reassignment of that variable like a contant variable.

                2)finally: finally is a block associated with try catch
                       it will be implemented whether exception
                       occurs or doesnt occur.
                3)finalize: just before terminating an object
                        the garbage collector calls the finalize()
                        method for cleanup activity.
                */
                    System.out.println("clean up code");
            }

            //using the throw keyword
            try
            {
                //this class type must be child of the throwable class
                //to throw it..
                throw new Test();
            }
            catch(Test t)
            {
                System.out.println("tst error");
            }



            //throws keyword (which is written next to function definition header line)
            //if there is a chance of checked exception to rise
            //then it must be handled or the method should declare
            //the exception to be thrown else we get a complile
            //time error.
            //throws exception is only required for checked exception
            //its useless for unchecked exception..
            //throws keyword is required only to satisfy compiler.
            //throws keyword doesnt prevent abnormal termination
            Thread.sleep(1000);

            //customer defined error usage
            throw new Test("Error to demonstrate throw keyword in custom defined class");
    }
    public static void doStuff() throws InterruptedException
    {
        doMoreStuff();
    }
    public static void doMoreStuff() throws InterruptedException
    {
        //here as the below statement can lead to exception
        //during run time the calling methods must throw exception
        //if try catch is not used to handle this exception.
        Thread.sleep(1000);
    }
}
/*note: here the entire stack of callers down the stack must
	throw the unchecked exception from the method
	where the unchecked exception occurs because otherwise
        jvm will look for error handling or throwing to all its
	callers in the stack.
	We should write throw statement not only on the bottom of stack
	but for all the methods from main to method where unchecked
	exception occurs.
	We can only throw an object of throwable child class type
*/

