package com.tutorials.streamsDemo;


import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/*
java.io package
===============
For byte streams: 10101111(8bit) binary
---------------------------------------
InputStream Class:
1) int read()
2) int read(byte[] buff)

OutputStream Class:
1) void write(int b)
2) void write(byte[] buff)

For text streams:
-----------------

Reader Class:
1) int read()
2) int read(char[] buff)

Writer Class:
1) void write(int ch)
2) void write(char[] buff)
3) void write(String str)

 */

/*
java.nio package:
=================
Path Class:
-----------
1) Paths.get("[URI(Universal Resource Identifier/string-based hierarchical path]"): references to the path object
           object of that file.

Files Class:
------------

Its Open file streams are:
1) newBufferedReader
2) newBufferedWriter
3) newInputStream
4) newOutputStream

Methods: (it automatically closes the resources - convenient)
-------
readAllLines()
readLine()
write()
 */

/*
URI for zip file uses "jar:file" scheme
eg: "jar:file:/maindir/subdir/subsubdir"
 */



//user defined class
class MyAutoCloseable implements AutoCloseable{

    public void foo() throws IOException{
        //System.out.println("Something");
        throw new IOException("Exception from foo");
    }
    @Override
    public void close() throws IOException {
        //System.out.println("CLOSED...");
        throw new IOException("Exception from close");
    }
}

public class Main {
    public static void main(String[] args)
    {
        //doTryCatchFinally();
        //doTryWithResources();
        doTryWithResourcesMulti();
        //doCloseThing();
    }
    /*
    Using the readLine() method of Files class of java.nio
     */
    public static void doReadLine(){
        try(BufferedReader br = Files.newBufferedReader(Paths.get("file1.txt"))){
            String inValue;
            while((inValue = br.readLine())!=null){
                System.out.println(inValue);
            }
        }
        catch(IOException e)
        {
            System.out.println(e.getClass().getSimpleName() + " - "+ e.getMessage());
        }
    }
    /*
    Using readAllLines() method of Files class of java.nio
     */
    public static void doReadLines(){
        try{
            List<String> lines = Files.readAllLines(Paths.get("file1.txt"));
            for (String line: lines)
            {
                System.out.println(line);
            }
        }
        catch(IOException e)
        {
            System.out.println(e.getClass().getSimpleName() + " - "+ e.getMessage());
        }
    }

    /*
    Using Conventional try catch finally to handle closing of streams.
     */
    public static void doTryCatchFinally(){
        char[] buff = new char[8];
        int length;
        Reader reader = null;

        try{
            reader = new FileReader("C:\\JavaDemo\\src\\com\\tutorials\\streamsDemo\\file1.txt");
            while((length = reader.read(buff)) >=0){
                System.out.println("\nLength: "+length);
                for(int i=0;i<length;i++)
                    System.out.println(buff[i]);
            }
        }
        catch(IOException e){
            System.out.println(e.getClass().getSimpleName() +" - " + e.getMessage());
        }
        finally{
            try{
                if (reader != null){
                    reader.close();
                }
            }
            catch(IOException e1) {
                System.out.println(e1.getClass().getSimpleName()+" - "+e1.getMessage());
            }
        }
    }
    /*
      Using try-with-resources to handle closing of streams, automatically
      by calling the close of the AutoCloseable interface which implements the
      Closable interface.(supply resources in () next to try block(Syntax).
    */
    public static void doTryWithResources(){
        char[] buff = new char[8];
        int length;

        try(Reader reader =  new FileReader("C:\\JavaDemo\\src\\com\\tutorials\\streamsDemo\\file1.txt");){
            while((length = reader.read(buff)) >=0){
                System.out.println("\nLength: "+length);
                for(int i=0;i<length;i++)
                    System.out.println(buff[i]);
            }
        }
        catch(IOException e){
            System.out.println(e.getClass().getSimpleName() +" - " + e.getMessage());
        }

    }
    /*
     Using try-with-resources to handle multiple Resources.
    */
    public static void doTryWithResourcesMulti(){
        char[] buff = new char[8];
        int length;

        try(Reader reader = new FileReader("C:\\JavaDemo\\src\\com\\tutorials\\streamsDemo\\file1.txt");
            Writer writer = new FileWriter("C:\\JavaDemo\\src\\com\\tutorials\\streamsDemo\\file2.txt")){
            while((length = reader.read(buff)) >=0){
                System.out.println("\nlength: "+length);
                //writing into file2 the entire buff array read at a time.
                //length is how much of the array is filled by the read contend.
                writer.write(buff,0,length);
            }
        }
        catch(IOException e){
            System.out.println(e.getClass().getSimpleName() +" - " + e.getMessage());
        }

    }

    /*
    A demo of how custom AutoCloseable class works.
     */
    private static void doCloseThing(){
        try(MyAutoCloseable ac = new MyAutoCloseable()){
            //the ac.close() method is closed implicitly
            ac.foo();
        }catch(IOException e){
            //now if ac.foo() throws exception its caught here
            //if close() also throw exception its caught but is compressed
            //as two exceptions caught.
            System.out.println(e.getClass().getSimpleName()+" - "+e.getMessage());
            //To print all the compressed exceptions
            for(Throwable t: e.getSuppressed())
                System.out.println("Suppressed: " + t.getMessage());
        }
    }
}
