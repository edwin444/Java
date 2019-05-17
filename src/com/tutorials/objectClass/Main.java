package com.tutorials.objectClass;

/*
The root of all classes is the Object Class
It contains the following methods which can be
overridden in base classes

1)clone
2)hashCode..
3)getClass(Returns the class object of “this” object and used to get actual runtime class of the object.
           It can also be used to get metadata of this class.)
4)finalize(called when the object is destroyed)[public void finalize()]..
5)toString..
6)equals..
 */


import com.tutorials.classDemo.FlightClass;

class Flight{
    int flightId;
    public void setFlightId(int x)
    {
        this.flightId = x;
    }
    public int getFlightId()
    {
        return this.flightId;
    }
    @Override
    public boolean equals(Object o)
    {
        return this.getFlightId() == ((Flight)o).getFlightId();
    }

    @Override
    public int hashCode()
    {
        return this.getFlightId();
    }

    @Override
    public String toString(){
        return "FlightId: "+this.getFlightId();
    }
}

public class Main {

    public static void main(String[] args)
    {
        //demonstrating benefits of Object class
        Object[] stuff = new Object[3];
        stuff[0] = new Flight();
        stuff[1] = new FlightClass();

        for (Object o:stuff)
        {
            if (o instanceof Flight)
            {
                Flight f = (Flight)o;
                System.out.println(f.getFlightId());
            }
        }


    }
}
