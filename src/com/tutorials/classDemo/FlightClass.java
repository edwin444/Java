package com.tutorials.classDemo;
/*
public: Accessible in every package, if so the classes name should be same as the files name
no specifier: (Default) Accessible only within the current package
private: Accessible only within ones own class
protected: Is private and accessible across child classes.
 */

class Main{
    public static void main(String[] args)
    {
        FlightClass fc = new FlightClass();
        fc.addPassengers(4);
        fc.dispAvailableSeats();
    }
}

//notice the naming style for the classes
public class FlightClass {
    int passengers;
    int seats;

    //field innitializers
    long circumferenceInMiles  = 24901;
    //it is rounded as otherwise a case of (long) will truncate the float result.
    long circumferenceInKilometers = Math.round(circumferenceInMiles+1.6d);

    FlightClass()
    {
        passengers = 0;
        seats = 150;
    }

    //notice camel case for naming functions.
    public void addPassengers(int no)
    {
        if (no>seats)
        {
            System.out.println("Error");
            return;
        }
        this.passengers+=no;
        this.seats-=passengers;
    }

    //to print the number of available seats
    public void dispAvailableSeats()
    {
        System.out.println("No of Available Seats: "+this.seats);
    }
}

