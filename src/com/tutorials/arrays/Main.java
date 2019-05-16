package com.tutorials.arrays;

public class Main {
    public static void main(String[] args) {
        //first method to declare array
        float[] temp = new float[3];

        //second method uses array literals,here we dont specify the size
        float[] temp1 = new float[]{0.1f, 0.2f, 0.3f};

        temp = temp1;

        for (int i = 0; i < temp.length; i++) {
            System.out.println("From the first Array: " + temp[i]);
        }

        //for each loop method
        for (float t : temp1) {
            System.out.println("From the second Array: " + t);
        }

    }

}
