
# Java
Core Java Tutorial

* **out** directory contains the .class files.
* **src** directory contains the .java source files.

* To distribute the package structure of out files, we need to bootstrap it, which is done by making a jar file. It contains all the necessary folder structure and manifest files along with the start up app(main method location).


* Steps to use IJ Editor to convert the file structure

* File -> Project Structure -> Artifacts -> + -> (Add the start up main method location)+(specify the location to create the manifest jar file) -> OK
* An artifact folder containing the jar file will be created in the out folder which can be directly run in the cmd using the command
     java -jar jar_file_name.jar
     
     
