package com.tutorials.collections;

import java.util.*;
import java.io.*;

public class MapDemo
{	/*
	If we want to represent a group of objects as key-value pairs
	then we should go for Map.

	Cont.. Interface:
	-----------------

	7)Map:
	 -----
	 Map is not child interface of Collection.
	 If we want to represent a group of objects as key-value pairs
         we should go for map.Duplication of values are allowed
         but duplication of keys not allowed. Both key and values are
	 objects.

	 IMPLEMENTATION CLASSES FOR MAP:
	 -------------------------------

	 1)HashMap
	   1.1)LinkedHashMap

	 2)WeakHashMap
	 3)IdentityHashMap
	 4)HashTable has abstract class as parent Dictionary
	      4.1)Properties

	8)SortedMap:
	 ----------
	It is the child interface of Map.
	If we want to represent a group of keyvalue pairs according to
        some sorting order of keys then we should go for sorted map.
	In sorted map the sorting should be based on key but not
        based on value.

	9)NavigableMap:
	 --------------
	It is the child interface of SortedMap.It defines
	several methods for navigation methods.

        IMPLEMENTATION CLASS:
	--------------------
	1)TreeMap


	*/
    public static void main(String args[]) throws Exception
    {
		/*
		Methods of mapinterface
		-----------------------
		1)Object put(Object key,Object value)
		2)void putAll(Map m);
		3)Object get(Object key)
		4)Object remove(Object key)
		5)boolean containsKey(Object Key)
		6)boolean containsValue(Object value)
		7)boolean isEmpty();
		8)int size();
		9)void clear();
		//collection view of map below because of its returns type
		10)Set keySet(); //duplicates not there
		11)Collection values();
		12)Set entrySet();   //the key-value rows together

		//Entry
		Map is a group of key value pairs and each key-value
		pair is called an entry
		hence map is considered as a collection of entry objects
		Without existing map objects there is no chance of
		existing entry object.hence entry interface is defined
		inside map interface
		interface Map
		{
			interface Entry
			{
				Object getKey()
				Object getValue()
				Object setValue(Object newobj)
			}
		}
		*/

        //implementation class hashmap
		/*
		constructors:
		------------
		HashMap m=new HashMap();  //default capacity initially=16
					  //default fill ratio=0.75
		HashMap m=new HashMap(int initialCapacity);
		HashMap m=new HaspMap(int initialCapacity,float fillratio);
		HashMap m=new HashMap(Map m);
		*/

        //samplecode
        HashMap m=new HashMap();
        m.put("pual",100);
        m.put("Edwin",800);
        m.put("aish",700);
        m.put("chintu",1000);

        System.out.println("Map: "+m);
        Set s=m.keySet();
        System.out.println("Keyset: "+s);

        Collection c=m.values();
        System.out.println("Values: "+c);

        Set s1=m.entrySet();
        System.out.println("EntrySet: "+s1);

        Iterator it=s1.iterator();
        while(it.hasNext())
        {
            Map.Entry row=(Map.Entry)it.next();
            System.out.println(row.getKey()+"..."+row.getValue());
            if (row.getKey().equals("chintu"))
                row.setValue("190");

        }

        System.out.println(s1);


        //linked hashmap is exactly same as hashmap except these
        //differences

		/*
		HashMap                     LinkedHashMap
		-----------------------------------------
		1)Hash table		    based on hashtable + linked list
		  internal implementation
		2)Insertion order is not    Insertion order is preserved
		  preserved
		*/

		/*
		note:
		-----
		Integer I1=new Integer(10);
		Integer I2=new Integer(10);
		System.out.println(I1==I2)   //false as different objects is pointed
		System.out.println(I1.equals(I2)); //true
		*/


        //identity hashmap is exactly same as hashmap
        //including methods and constructors except the
        //following difference
        //in the case of normal hashmap
        //JVM  will use .equals method to identify
        //duplicate keys which is meant for content
        //comparison
        //but in the case of identity hash map
        //JVM will use == operator to identify duplicate keys
        //which is meant for difference comparison(address comparison)


		/*
		weak hashmap: exactly same as hashmap
		except following difference
		In the case of hashmap even though object doesnt have
		any reference its not elligible for gc (garbage collection)
		if its associated with hashmap ie hashmap terminates
		garbage collector
		But in the case of weak hash map if object doesnt contain
		any references its elligible for gc even though object
		associated with weak hash map ie garbage collector
		dominates weak hash map.
		*/
        WeakHashMap whm=new WeakHashMap();
        Emp e=new Emp();
        whm.put(e,"edwin");
        System.out.println(whm);

        e=null;
        System.gc();
        Thread.sleep(2000);
        System.out.println(whm);


        //now we move into the sortedmap interface and its children
		/*
 		methods of sorted map interface
		-------------------------------
		eg:
		101->A
		103->B
		104->C
		107->D
		125->E
		136->F

		firstKey()-->101
		lastKey()-->136
		headMap(107)->{101=A,103=B,104=C}
		tailMap(107)->{107,125=E,136=F}
		subMap(103=B104=C,107=D}
		comparator()->null
		*/

        //implementation class TreeMap
        //implementation underlying data structure is RED-BLACK TREES
        //here if key is null the comparison of keys for keyset
        //same rules above for null as mentioned in collections
        //earlier exists.

		/*
		Constructor:
		------------
		1)TreeMap t=new TreeMap()
		2)TreeMap k=new TreeMap(Comparator c);
		3)TreeMap t=new TreeMap(SortedMap m);
		4)TreeMap t=new TreeMap(Map m);
		*/

        //demo
        TreeMap tm=new TreeMap();
        tm.put(100,"aA");
        tm.put(103,"we");
        tm.put(101,"sdf");

        System.out.println("TreeMap: "+tm);


        //hashtable
        //inserted based on hashCode of keys
        //implements serializable and clonable but not randomn access
        //Thread safe or synchronizable
        //for search its best.
        //duplicates keys not allowed

		/*constructors are same for HashTable but default innitial
		  capacity=11*/
        //here we create objects and override the hashCode()
        //of these methods in their class definition
        //now how its inserted is if its within default size of
        //insert in the same bucket as its hashcode
        //however if it exeeds total size insert in the
        //value mod size location in the hashTable

        Temp te=new Temp(10);
        Temp te1=new Temp(16);
        Temp te2=new Temp(30);
        Hashtable ht=new Hashtable();
        ht.put(te,"A");
        ht.put(te1,"B");
        ht.put(te2,"C");
        //note: if collisions occur then its printed from
        //      last entry to the first entry collided in the
        //      same cell
        //      otherwise all cell printed from top to bottom
        //      of cell index number of hashtable.
        System.out.println("HashTable: "+ht);

        //Properties class
        //In out program if anything which changes frequently
        //like username password and mailids etc are not
        //recommended to hardcode in java program because
        //if there is any change to reflect that change
        //recomplilation,rebuild,redeploy application are
        //required even sometimes server restart also required
        //which creates a big bussiness impact to the client
        //we can overcome this problem by using properties file
        //such type of variable things we have to configure
        //in the properties file
        //from the properties file we have to read into
        //java program and we can use those properties
        //the main advantage of this approach is if there is
        //a change in properties file to reflect that change
        //just redeployment is enough which wont create
        //any bussiness impact to the client.
        //we can use java properties object to hold properties
        //which are coming from properties file



        //in properties both key and value is string unlike normal
        //map
        Properties p=new Properties();
		/*methods of properties
		String setProperty(String pname,String pvalue)
			//to set a new property
		String getProperty(String pname);
			//to get value associated with the specified property
		Enumeration propertyNames()
			//enumeration cursor as its legacy class

		void load(InputStream is)
			//to load properties from java properties
			//object into properties file
		void store(OutputStream os,String comment)
			//to store properties from java properties object
			//into properties file
		*/

        Properties p1=new Properties();
        FileInputStream f=new FileInputStream("abc.properties");
        p1.load(f);
        System.out.println(p1);
        String ss=p1.getProperty("venki");
        System.out.println(ss);
        p1.setProperty("nag","8888");
        FileOutputStream fo=new FileOutputStream("abc.properties");
        p1.store(fo,"comment added");


        //NavigableMap
        //it defines several methods for navigation purposes
        //navigable map defines the following methods
		/*
		1)floorKey(e);
		2)lowerKey(e);
		3)ceilingKey(e);
		4)higherKey(e);
		5)pollFirstEntry();
		6)pollLastEntry();
		7)descendingMap();
		*/
        TreeMap<String,String> ttm=new TreeMap<String,String>();
        ttm.put("b","Banana");
        ttm.put("c","cat");
        ttm.put("a","apple");
        ttm.put("d","dog");
        ttm.put("g","gun");

        System.out.println("TreeMap");
        System.out.println(ttm);
        System.out.println(ttm.ceilingKey("c"));
        System.out.println(ttm.higherKey("e"));
        System.out.println(ttm.lowerKey("e"));
        System.out.println(ttm.floorKey("e"));
        System.out.println(ttm.pollFirstEntry());
        System.out.println(ttm.pollLastEntry());
        System.out.println("Descending Map: "+ttm.descendingMap());
        System.out.println("Map: "+ttm);


    }

}
class Temp
{
    int i;
    public int hashCode()
    {
        return i;
    }
    public Temp(int x)
    {
        this.i=x;
    }
    public String toString()
    {
        return "i: "+i;
    }


}
class Emp
{
    int j=10;
    public String toString()
    {
        return "emp_object";
    }
}
