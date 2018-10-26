package com.company.option3;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static AtomicInteger workedThreads = new AtomicInteger(0);

    public static void main(String[] args) {

        final int ARRAY_LENGTH = 30;
        final int BOUND = 101;
        final int QUANTITY_THREADS = 3;
        MyThread[] myThreads = new MyThread[QUANTITY_THREADS];


        int[] myArray = new int[ARRAY_LENGTH];
        for (int i = 0; i < myArray.length; i++) {
            Random random = new Random();
            myArray[i] = random.nextInt(BOUND);
        }

        System.out.println(Arrays.toString(myArray));

        for (int i = 0; i < QUANTITY_THREADS; i++) {
            int startArray = i * (ARRAY_LENGTH / QUANTITY_THREADS);
            int endArray = (i + 1) * ARRAY_LENGTH / QUANTITY_THREADS - 1;
            MyThread myThread = new MyThread(myArray, startArray, endArray);
            myThreads[i] = myThread;
            myThread.start();
        }

        while (workedThreads.get() != QUANTITY_THREADS) {
        }

        System.out.println(biggestValue(myThreads));
    }


    public static int biggestValue(MyThread[] myThreads) {
        int biggestValue = 0;
        for (MyThread myThread : myThreads) {
            if (biggestValue < myThread.biggestValue) {
                biggestValue = myThread.biggestValue;
            }
        }
        return biggestValue;
    }
}
