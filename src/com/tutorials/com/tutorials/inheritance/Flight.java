package com.tutorials.com.tutorials.inheritance;
/*
Clearly methods are overridden by child class.
However, if base case pointer used to point to child class reference, for data members
with same name the base class data type is given more preference.
 */
public class Flight{
    int seats = 100;
    public int getSeats()
    {
        return this.seats;
    }
}

class CargoFlightG extends Flight{
    int seats = 12;
    public int getSeats() {
        return this.seats;
    }
}

class CargoFlightB extends Flight{
    int seats = 14;

    //below keyword allows the getSeats() function to override the base
    //function when a statement like Flight name = new CargoFlightB() is used
    @Override
    public int getSeats() {
        return this.seats;
    }

}

class main{
    public static void main(String[] args)
    {
        Flight f1 = new CargoFlightG();
        System.out.println("f1.getSeats(): "+f1.getSeats());
        System.out.println("f1.seats: "+f1.seats);

        Flight f2 = new CargoFlightB();
        System.out.println("f2.getSeats(): "+f2.getSeats());
        System.out.println("f2.seats: "+f2.getSeats());

    }
}
