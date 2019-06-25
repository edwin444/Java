package com.tutorials.stringClass;

class ThreadB extends Thread{
    public void run(){
        //do something here

    }
}
public class ThreadA {
    public static void main(String[] args) throws InterruptedException
    {
        ThreadB b = new ThreadB();
        b.start();

        synchronized (b)
        {
            //b.wait();
            System.out.println("From inside the main thread");
        }
    }
}
