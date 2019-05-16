package com.tutorials.classDemo;

//these classes are available across all the packages(public).
public class Passenger {

    public int freeBags = 0;
    public int checkedBags = 0;

    //chaining of constructors concept.
    public Passenger(int freeBags)
    {
        this.freeBags = freeBags;
    }
    public Passenger(int freeBags,int checkedBags)
    {
        //chained the first constructor here
        this(freeBags);
        this.checkedBags = checkedBags;
    }


}
