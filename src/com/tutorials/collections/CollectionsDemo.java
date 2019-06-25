package com.tutorials.collections;

import java.util.*;
public class CollectionsDemo
{
    /*
    ARRAYS:
    ------

    advantages of arrays:
    ---------------------
    1)we can represent multiple values using single variable
      so that readability of the code will be removed.
    limitations of arrays:
        ----------------------
    1)arrays are fixed in size,no chance of inc or dec size at runtime.
    2)arrays are homogenous and can only store one type of object
      in it,however we can solve this problem by using
      object array.
    3)No underlying data structure so no readymade methods available.


    COLLECTIONS: overcomes problems of arrays.If we want to represent
    -----------   a group of entities as a single entity..


    Advantages:
    -----------
    1)Growable in size.
    2)can hold homogenous and heterogenous elements.
    3)every collections are implemented using some underlying data
      structure.

    Disadvantages:
    --------------
    1)performance of the collection is not very good whereas
      memory wise its good.
    2)collections can hold only objects and not primitives like array
      eg: holding primitive: int[] x;    //collections cant hold it.
          holding objects:   Integer[] x;


    INTERFACES:
    -----------

    1)COLLECTION FRAMEWORK:
    ---------------------
    Contains several Classes and interfaces that can be used to
    represent a group of individual objects as a single entity.

    Collection INTERFACE:
    --------------------
    In general its considred as root interface of collection framework.
    No concrete class implements collection interface directly.

    Difference between collection and collections:
    ----------------------------------------------
    Collection-->interface
    Collections-->concrete class which defines several utility method
              for collection objects.


    2)List:
      ----
      Its the child interface of Collection framework.
      If we want to represent a group of objects as a single entity
      and duplication is allowed and insertion order is preserved
      we should go for list.

      CLASSES THAT IMPLEMENT LIST:
      ----------------------------
      1)ArrayList
      2)LinkedList
      3)Vector           //considered as legacy or old classes 1.0v
        3.1)Stack

    3)Set:
      ----
      It is the child interface of Collection.
      If we want to represent of group of individual objects as a
      single entity where duplicates are not allowed and insertion
          order not required then we should go for set interface.

      CLASSES THAT IMPLEMENT Set Interface:
      -------------------------------------

      1)HashSet
        1.1)LinkedHashSet

    4)SortedSet:
      ---------
      It is child interface of Set.If we want represent a group
      of individual objects as a single entity where duplicates
          are not allowed and all objects should be inserted according
      to some sorting order then we should go for SortedSet.

    5)NavigableSet:
      ------------
          It is the child interface of sorted set.It contains several methods
      for navigation purposes.

      CLASSES FOR IMPLEMENTATION:
           ---------------------------
      1)TreeSet

    6)Queue:
      ------
      It is the child interface of Collection.
      If we want to represent a group of individual objects
      prior to processing then we should go for queue.
      Usually queue follows FIFO order but based on our requirement
      we can implement our own priority order also.

      Implementation Classes:
      -----------------------
      1)PriorityQueue
      2)BlockingQueue
               2.1)PriorityBlockingQueue
           2.2)LinkedBlockingQueue
      3)....





    */
    public static void main(String args[])
    {
		/*
                functions in Collection interface for any collection object:
		------------------------------------------------------------
		boolean add(Object o);
		boolean addAll(Collection c);   //add everything from c to the obj invoking it.
		boolean remove(Object o);
		boolean removeAll(Collection c);
		boolean retainAll(Collection c);  //intersection.
		void clear();
		boolean contains(Object o);
		boolean containsAll(Collection c);
		boolean isEmpty();
		int size();
		Object[] toArray(); //convert the collection to an array
				      of Object objects.
		Iterator iterator();
		*/


		/*
		List interface methods:
		-----------------------
		void add(int index,Object o); //adds an object to that index
		boolean addAll(int index,Collection c);
		Object get(int index);
		Object remove(int index);
		Object set(int index,Object new);
		int indexOf(Object o);
		int lastIndexOf(Object o);
		ListIterator listIterator();

		*/

        //ArrayList class method demostration
        ArrayList l=new ArrayList();
		/*other constructors
		ArrayList l=new ArrayList(Collection c);
		ArrayList l=new ArrayList(int maxcap);
		Note: be default maxcap=10 once full maxcap=(3/2*currcap)+1
		*/

        //l is a reference to ArrayList object
        //printing l directly will print toString() method
        //of the object..

        l.add("A");
        l.add(10);
        l.add("A");
        l.add(100);
        l.add(null);
        System.out.println("The collection: "+l);
        l.remove(2);   //remove object in the second index
        l.add(2,"m");
        l.add("N");
        System.out.println("After: "+l);

        //array list implicitly implement below
        //System.out.println(l instanceof Serializable);
        System.out.println(l instanceof Cloneable);
        System.out.println(l instanceof RandomAccess);

		/*
		ArrayList                                    Vector
		--------------------------------------------------------------------
		1)Every method is                           1)synchronized
		  non-synchronized
		  However we can make
	          array list synchronized
		  by the following:
		  ArrayList al=new ArrayList();
	          List l1=Collections.synchronizedList(l);

		2)At a time multiple                        2)thread safe only one
		  threads are allowed                         thread can operate on vector at a time.
		  to operate on ArrayList
		  object and hence its
		  not thread safe.
		---------------------------------------------------------------------
		*/

        //LinkedList class methods
        //LinkedList l=new LinkedList(Collection c);
        LinkedList ll=new LinkedList();

        //used to implement stack and queue
        ll.addFirst(10);
        System.out.println(ll);

        ll.addLast(100);
        System.out.println(ll);

        System.out.println("first element: "+ll.getFirst());

        System.out.println("second element: "+ll.getLast());

        ll.removeFirst();
        System.out.println(ll);

        ll.removeLast();
        System.out.println(ll);

        //vector class demonstration
        //default vector capacity=10
        //once vector reaches full capacity it will be resized to double capacity

        Vector v = new Vector();
        //Other constructors
        //Vector v=new Vector(int maxCap);
        //Vector v=new Vector(int innitialcapacity,int incrementalcapacity);
        // Note: the incremental capacity specifies by how much should vector increase

        System.out.println("Vector methods");
        //methods of the vector class
        v.addElement(10);
        v.addElement(20);
        v.addElement(100);
        System.out.println(v);

        System.out.println("Element at index0: "+v.elementAt(0));
        System.out.println("Last element: "+v.lastElement());
        System.out.println("First element: "+v.firstElement());


        v.removeElement(20);
        System.out.println(v);

        v.removeElementAt(1);
        System.out.println(v);

        v.removeAllElements();
        System.out.println(v);

        System.out.println("size of vector: "+v.size());
        System.out.println("capacity of vector: "+v.capacity());


        //Stack class which is child class of vector
        //it is specially designed class for first in first out
        //order

        //only one constructor
        Stack s=new Stack();
        s.push(10);
        System.out.println("Stack s: "+s);

        s.push(20);
        System.out.println(s);

        System.out.println(s.peek());

        System.out.println(s.empty());
        s.pop();

        System.out.println("AFter poping: "+s);

        System.out.println("position of 10: "+s.search(10));

        //returns the offset from the top
        //of the stack with numbering from 1

		/*
		concept of cursor
		-----------------
		1)Enumeration
		2)Iterator
		3)ListIterator
		*/

        //enumeration object is used to get elements one by
        //one from legacy collection objects only.
        //limitation: only read access and we cant perform remove
        //            operation.
        Vector v1=new Vector();
        for (int i=0;i<=10;i++)
        {
            v1.addElement(i);
        }

        Enumeration e=v1.elements();
        while (e.hasMoreElements())
        {
            Integer I=(Integer)e.nextElement();
            if (I%2==0)
                System.out.println(I);
        }

        //using iterator cursor

        ArrayList ar=new ArrayList();
        int count=1;
        while(count<=10)
        {
            ar.add(count);
            count++;
        }

        Iterator it=ar.iterator();
        while (it.hasNext())
        {
            Integer I=(Integer)it.next();
            if (I%2==0)
                System.out.println(I);
            else
                it.remove();
        }
        System.out.println(ar);

        //limitations of iterator
		/*
		1)can only move is one direction ie forward
		  we cant move to the backward direction
		  they are not bi-directional cursors.
		2)We can perform only read and remove operations
		  and we cant perform replacement and addition
		  of new objects.
		*/

        //ListIterator overcomes the above limitations
        //can be applied to only List objects
        //list iterator is the child interface of iterator
        //and hence all methods present in iterator by default
        //available to the list iterator...


		/* methods of list iterator
		1)forward movement:
		  -----------------
		  public boolean hasNext();
		  public Object next();
		  public int nextIndex();

		2)backward movement:
		  ------------------
		  public boolean hasPrevious();
		  public Object previous();
		  public int previousIndex();

		3)Extra operations:
		--------------------
		  public void remove();         //removal
		  public void add(Object o);    //addition
		  public void set(Object o);    //replacement

		*/

        //sample program or arl
        LinkedList arl=new LinkedList();


        arl.add("edwin");
        arl.add("paul");
        arl.add("kevin");
		/*
		note: very important.
		----  always the Listiterator assignment object
		      must be made after the array has been modified
		      ie after arl.add
		*/

        ListIterator Li=arl.listIterator();
        while(Li.hasNext())
        {
            String s1=(String)Li.next();
            if (s1.equals("edwin"))
                Li.set("11");
            else if (s1.equals("paul"))
                Li.add("22");
            else if (s1.equals("kevin"))
                Li.remove();


        }
        System.out.println("modified using ListIterator: "+arl);


        //now set interface has no new methods
        //we go for first implementation class hashSet
        HashSet h=new HashSet();
		/*
		Constructors common to all set classes
		-------------------------------------
		1)HashSet h=new HashSet();
		default size:16
		Fill Ratio/Load Factor: 0.75
		It means after the existing size is completed by 75%
		a new HashSet object is created.

		2)HashSet s=new HashSet(int initialCapacity);
		3)HashSet s=new HashSet(int initialCapacity,float fillratio);
		4)HashSet s=new HashSet(Collection c);
		*/
        h.add("b");
        h.add("c");
        h.add("d");
        h.add(null);
        System.out.println("HashSet: "+h);
        //note: the order of elements insertion is not preserved.

        //linkedhashset is the child class of hashset
        //it is exactly same as hashset including constructors
        //and methods except the following differences
        //linkedhashset preserves order
        //the underlying datastructure is linkedlist+hashtable

        LinkedHashSet lh=new LinkedHashSet();
        lh.add("b");
        lh.add("c");
        lh.add("d");
        lh.add(null);
        System.out.println("LinkedHashSet: "+lh);

		/*
		Methods of SortedSet:
		---------------------
		1)first()
		2)last()
		3)headSet(element) : returns a set of elements from
				     first elements to specified element
				     exclusive
		4)tailSet(element) : returns a set of elements from
				     specified elements inclusive
				     to last element.
		5)subSet(a,b)
			it returns a set of elements >=a
			and lesser than b
		6)comparator()

		Note: we cant give demo program as its interface
		     object cant be created
		/*
		//implementation class-TreeSet
		//its an exception to collection objects
		//heterogenous objects are not allowed
		//underlying datastructure is balanced tree
		//null can be inserted only once
		*/

		/*
		constructors:
		1)TreeSet t=new TreeSet();
		2)TreeSet t=new TreeSet(Comparator c);
		       ==>here elements will be inserted according
			  to the order specified by the Comparator
			  object logic.
		3)TreeSet t=new TreeSet(Collection c);
		4)TreeSet t=new TreeSet(SortedSet s);
		*/

        //Demo
        TreeSet t=new TreeSet();
        t.add("a");
        t.add("A");
        t.add("Z");
        t.add("C");
        System.out.println("Treeset: "+t);

		/*
		NULL ACCEPTANCE:
		----------------
		1)k.add(null);
		       if tree non-empty tree set if we insert null
		       we get null point exception due to comparison
		       with null [but from 1.7 v onwards even this
				  is not allowed]

		       if tree is empty and we insert null its fine
		       but then if we add any other element we get
		       exception
		*/

        //if we use default sort order constructor the objects
        //added must be homogenous and comparable
        //hence if add StringBuffer object then it will
        //raise classCasteException as they are not comparable.
        //The JVM by default used the obj.compareTo(obj1) while
        //adding the object into the treeset

		/*
		Concept of Comparator:
		---------------------
		Comparator interface contains two methods in java.util
		package. Comparable interface present in java.lang
		package which contains compareTo method called by JVM
		for natural default sorting.

		1)int compare(Object obj1,Object obj2);
		   -1,0,1

		2)boolean equals(Object obj)

		now, whenever we implement comparator interface
		we should provide implementation for compare method
		and we are not required to provide implementation
		for eqauls method because it is already available
		to our class from Object class through inheritance.


		*/
        //implementation of comparator logic to display in descending
        //order
        TreeSet ts=new TreeSet(new mycomp());
        ts.add(-100);
        ts.add(-200);
        ts.add(8);
        ts.add(2);
        ts.add(1000);
        System.out.println("TreeSet in descending order: "+ts);
        //note:to ensure insertion order just return +1 always
        //     if we return 0 means only first element
        //     will be inserted and the remaining will be considered
        //     as duplicates.

        //NavigableSet
		/*
		It is the child interface of sorted set
		and it defines several methods for navigation purposes
		NavigableSet defines the following methods:
		1)floor(e)
			//it returns highest element which is <=e
		2)lower(e)
			//it returns highest element which is <e
		3)ceiling(e)
			//it returns lowest element which is >=e
		4)higher(e)
			//it returns lowest element which is >e
		5)pollFirst()
			//remove and return first element
		6)pollLast()
			//remove and return last element
		7)descendingSet()
			//it returns NavigableSet in reverseorder

		*/
        //demo
        TreeSet<Integer> tt=new TreeSet<Integer>();
        tt.add(1000);
        tt.add(2000);
        tt.add(3000);
        tt.add(4000);
        tt.add(5000);
        System.out.println(tt);
        System.out.println(tt.ceiling(2000));
        System.out.println(tt.higher(2000));
        System.out.println(tt.lower(3000));
        System.out.println(tt.floor(3000));
        System.out.println(tt.pollFirst());
        System.out.println(tt.pollLast());
        System.out.println(tt.descendingSet());
        System.out.println(tt);





        /*Queue interface*/
        //from 1.5v onwards
        //linked list class also implements queue interface
        //linked list based implementation of queue always
        //follows first in first out order.

		/*
		Queue interface specific methods
		--------------------------------
		1)boolean offer(Object o)
			//to add an object into the queue
		2)Object peek()
			//to return head element of the queue.If queue
			//is empty then this method returns null
		3)Object element()
			//to return head element of the queue.If queue
			//is empty it returns NoSuchElementException

		4)Object poll()
			//to remove and return head element of the queue
			//if queue is empty then it returns null
		5)Object remove()
			//to remove and return head element of the queue
			//however if empty it returns NoSuchElementException

		*/

        //implementation class priority queue
        //if we want to represent a group of individual objects
        //Prior to processing in some priority use this
        //priority can be either default sorting order or
        //customized sorting order based on comparator obj
        //insertion order is not preserved and duplicates not allowed

		/* constructors
		   ------------
		1)PriorityQueue q=new PriorityQueue();
		2)PriorityQueue q=new PriorityQueue(int initialcapacity);
		3)PriorityQueue q=new PriorityQueue(int initialcapacity,Comparator c);
		4)PriorityQueue q=new PriorityQueue(SortedSet s);
		5)PriorityQueue q=new PriorityQueue(Collection c);


		*/
        //demo
        PriorityQueue q=new PriorityQueue(15,new MyComparator());
        q.offer("A");
        q.offer("Z");
        q.offer("L");
        q.offer("B");
        System.out.println(q);
		/*Note:
		Some platforms wont provide proper support for thread
		priorities and priority queues.thats why its doesnt
		print in descending order for mycomparator obj
		*/

    }



}
class mycomp implements Comparator
{
    public int compare(Object a,Object b)
    {
        Integer x=(Integer)a;
        Integer y=(Integer)b;
        //here type casting say for string is done(String) for
        //internal string and toString() method is called
        //for StringBuffer object that is not comparable
        //when we define our own sorting we can also add
        //heterogenous objects.
        if (x>y)
            return -1;
        else if (x<y)
            return +1;
        else
            return 0;


    }


}
class MyComparator implements Comparator
{
    public int compare(Object obj1,Object obj2)
    {
        String s1=(String)obj1;
        String s2=(String)obj2;
        return s2.compareTo(s1);

    }

}

