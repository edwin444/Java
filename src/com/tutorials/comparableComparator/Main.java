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
		//is set
		//Now when we create a treeSet object without any
		//comparator object then it means default sorting
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
        return (e1.compareTo(e2)+3)%3;       //  -1 1 0   2 4 3   => negating
    }
}
public class Main {
    public static void main(String[] args)
    {
        Employee e1 = new Employee(1,2,"Abraham");
        Employee e2 = new Employee(1,40,"Kevin");

        //default sorting order of TreeSet
        TreeSet t = new TreeSet(new MyComparator1());
        t.add(e1);
        t.add(e2);

        //Iterator should always the type declared.(here Employee)
        Iterator<Employee> it = t.iterator();
        while(it.hasNext())
            System.out.println("Default: "+ it.next().name);


        //custom sorting order using Comparator
        TreeSet t1 = new TreeSet(new MyComparator());
        t1.add(e1);
        t1.add(e2);

        Iterator<Employee> it1 = t1.iterator();
        while(it1.hasNext())
            System.out.println("Custom: "+it1.next().name);
    }
}
