package com.tutorials.stringClass;

public class Main {
    public static void main(String[] args)
    {
        //StringBuilder provides mutable string buffer
        StringBuilder sb = new StringBuilder(40);
        String location = "Florida";
        sb.append("I flew to ");
        sb.append(location);

        sb.insert(5," ** ");
        System.out.println("sb");

        //creatin a new string from a character array
        char a[]={'h','e','l','l','o'};    //note: "hello" is treated as a string
        String s = new String(a);
        System.out.println(s);

        //using the concatenate and the length inbuilt function
        String s1=" World";
        s1=s.concat(s1);                  //the concate function is used to return
        System.out.println(s1.length());
        System.out.println(s1);


        //creating format strings
        int num = 44;
        //method 1:
        System.out.printf("Hello world:%d",num);

        //method2:
        String f;
        f=String.format("Hello world:%d",num);

        //returning character at the specified index
        System.out.println("\n"+f.charAt(3));

        //comparing two strings as present in the dictionary
        String f1="I";
        System.out.println(f1.compareTo(f));
        System.out.println(f.compareTo(f1));
        System.out.println(f1.compareTo(f1));

        //compare two strings ignoring the case differences
        System.out.println(f1.compareToIgnoreCase(f));

        //to check if the string given is same as the string given in the
        //bracket==>note it returns a boolean value
        String f2 = "hello";
        System.out.println(f2.contentEquals("hello"));

        //to copy value of a character array into string
        char b[]={'e','d','w','i','n'};
        String c=String.copyValueOf(b);
        System.out.println(c);

        //to copy the value of a string only to a specified index of
        //the array==>indexing starts from 0 and the last index
        //is included
        c=String.copyValueOf(b,1,3);
        System.out.println(c);

        //to check if the string ends with a particular substring
        System.out.println(c);
        System.out.println(c.endsWith("wi"));

        //to compare if two string equals
        System.out.println(c.equals(c));

        //to ignore case and compare
        System.out.println(c.equalsIgnoreCase("DWI"));

        //to get a series of bytes regardless of formatting
        System.out.println(c.getBytes());

        //to convert a string to a character array
        String temp = "Edwin";
        char t[]= new char[5];
        temp.getChars(0,temp.length(),t,0);
        System.out.println(t);

        //to get the hash code for the string
        System.out.println(temp.hashCode());


        //to return the index of a character or a string
        //second parameter=>search starts from there means including that
        //position...
        System.out.println(temp.indexOf('i'));
        System.out.println(temp.indexOf('i',3));
        System.out.println(temp.indexOf("in"));
        System.out.println(temp.indexOf("in",3));

        //here searching starts from the end of the string
        System.out.println(temp.lastIndexOf('i'));
        System.out.println(temp.lastIndexOf('i',3));
        System.out.println(temp.lastIndexOf("in"));
        System.out.println(temp.lastIndexOf("in",3));

        //returns the canonical representation of the string object
        System.out.println(temp.intern());

        //to replace all the occurences of the character/string in the
        //given string
        temp = temp.replace('d','e');
        System.out.println(temp);

        temp = temp.replaceAll("win","vin");
        System.out.println(temp);

        temp = temp.replaceFirst("win","vin");
        System.out.println(temp);

        //splitting the string and assigning it to a string array
        temp="Edwinwinnnnwinnnn";
        String tempp[] = temp.split("wi");

        for (String temppp:tempp)
            System.out.println(temppp);
        System.out.println("\n");

        //it means it will split the first limit-1 occurences of the substring
        tempp = temp.split("wi",3);

        for (String temppp:tempp)
            System.out.println(temppp);

        //to check if the string starts with a particular string
        System.out.println(temp.startsWith("Ed"));
        System.out.println(temp.startsWith("Ed",3));

        //to return a sub-sequence to a character array
        //char at[] = new char[temp.length()];
        //at = temp.subSequence(1,temp.length());
        //System.out.println(at);

        //returns a substring
        temp = temp.substring(1,temp.length());
        System.out.println(temp);

        //To print upper case and lower casestring
        System.out.println(temp.toUpperCase());
        System.out.println(temp.toLowerCase());

        //to remove the extra leading and trailing white spaces
        String foo = "   foo    ";
        System.out.println(foo.trim());

        //to return the string representation of a primitive datatype
        System.out.println(foo.valueOf(9));



    }



}
