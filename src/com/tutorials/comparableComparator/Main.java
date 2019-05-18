package com.tutorials.comparableComparator;

/*
Concept of Comparable and Comparator explained
Comparator: An interface which contains the compareTo(Object o) method.
Comparable: An interface which contains the compare(Object o,Object o1) method.
 */

/*
//note: here Employee class
		// implements the Comparable class
		//only for the objects of employee
		//class and we can do this only for user defined
		//classes and not predefined classes like String
		//we do this so that default sorting order
		//is set.
		//Without any comparator object then it means default sorting.
 */



import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

//implementation without generics
class Employee implements Comparable{

    int salary;
    int id;
    String name;
    public Employee(int salary,int id,String name)
    {
        this.salary = salary;
        this.id = id;
        this.name = name;
    }
    @Override
    public int compareTo(Object o) {
        if (this.id == ((Employee)o).id)
            return 0;
        else if (this.id > ((Employee)o).id)
            return 1;
        else
            return -1;
    }
}
class MyComparator implements Comparator
{
    @Override
    public int compare(Object o1, Object o2) {
        Employee e1 = (Employee) o1;
        Employee e2 = (Employee) o2;
        return e1.compareTo(e2);
    }
}
class MyComparator1 implements Comparator
{
    @Override
    public int compare(Object o1, Object o2) {
        Employee e1 = (Employee) o1;
        Employee e2 = (Employee) o2;
        if (e1.id>e2.id)
            return -1;
        else if (e1.id<e2.id)
            return 1;
        else
            return 0;
    }
}
/*
If Comparable() is not inherited and Comparator is not used , default random sorting order is followed.

Here TreeSet by default considers the compareTo() overridden method in the
class of the object which is to be sorted , here Employee.

If we provide a comparator class implementation is takes that implementation of compare() method to sort instead.
We use comparator() way of sorting so, that we can define multiple ways to sort unlike Comparable.
 */
public class Main {
    public static void main(String[] args)
    {
        Employee e1 = new Employee(1,40,"Abraham");
        Employee e2 = new Employee(1,2,"Kevin");

        //Default Sorting order by overridden compareTo() method.
        TreeSet t0 = new TreeSet();
        t0.add(e1);
        t0.add(e2);

        //Iterator should always have the type declared.(here Employee)
        Iterator<Employee> it0 = t0.iterator();
        while(it0.hasNext())
            System.out.println("Default: "+ it0.next().name);


        //Custom Sorting order 1.
        TreeSet t = new TreeSet(new MyComparator1());
        t.add(e1);
        t.add(e2);

        //Iterator should always have the type declared.(here Employee)
        Iterator<Employee> it = t.iterator();
        while(it.hasNext())
            System.out.println("Default: "+ it.next().name);


        //Custom Sorting order 2.
        TreeSet t1 = new TreeSet(new MyComparator());
        t1.add(e1);
        t1.add(e2);

        Iterator<Employee> it1 = t1.iterator();
        while(it1.hasNext())
            System.out.println("Custom: "+it1.next().name);
    }
}
