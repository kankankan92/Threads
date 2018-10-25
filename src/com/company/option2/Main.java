package com.company.option2;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private static int workedThreads = 0;

    public static void main(String[] args) {

        final int ARRAY_LENGTH = 1000;
        final int BOUND = 101;
        final int QUANTITY_THREADS = 100;
        MyThread[] myThreads = new MyThread[QUANTITY_THREADS];


        int[] myArray = new int[ARRAY_LENGTH];
        for (int i = 0; i < myArray.length; i++) {
            Random random = new Random();
            myArray[i] = random.nextInt(BOUND);
        }


        System.out.println(Arrays.toString(myArray));
        for (int i = 0; i < QUANTITY_THREADS; i++) {
            MyThread myThread = new MyThread();
            myThreads[i] = myThread;
            myThread.myArray = myArray;
            myThread.startArray = i * (ARRAY_LENGTH / QUANTITY_THREADS);
            myThread.endArray = (i + 1) * ARRAY_LENGTH / QUANTITY_THREADS - 1;
            myThread.start();
        }

        while (Main.getWorkedThreads() != QUANTITY_THREADS) {
        }
//
//        System.out.println(myThreads[0].biggestValue);
//        System.out.println(myThreads[1].biggestValue);
//        System.out.println(myThreads[2].biggestValue);
        System.out.println(biggestValue(myThreads));
    }


    public static int biggestValue(MyThread[] myThreads) {
        int biggestValue = 0;
        for (int i = 0; i < myThreads.length; i++) {
            if (biggestValue < myThreads[i].biggestValue) {
                biggestValue = myThreads[i].biggestValue;
            }
        }
        return biggestValue;
    }

    public static int getWorkedThreads() {
        return workedThreads;
    }

    synchronized public static int incWorkedThreads() {
        return Main.workedThreads = Main.workedThreads + 1;
    }
}
