package com.company.option1;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        final int ARRAY_LENGTH = 10;
        final int BOUND = 1000;
        final int QUANTITY_THREADS = 3;
        MyThread[] myThreads = new MyThread[QUANTITY_THREADS];


        int[] myArray = new int[ARRAY_LENGTH];
        for (int i = 0; i < myArray.length; i++) {
            Random random = new Random();
            myArray[i] = random.nextInt(BOUND);
        }
        myArray[9] = 999;

        System.out.println(Arrays.toString(myArray));
//        MyThread myThread = new MyThread();
//        myThread.myArray = myArray;
//        myThread.start();
//        while (!myThread.finish){}
//        System.out.println(myThread.biggestValue);

        for (int i = 0; i < QUANTITY_THREADS; i++) {
            MyThread myThread = new MyThread();
            myThreads[i] = myThread;
            myThread.myArray = myArray;
            myThread.startArray = i * (ARRAY_LENGTH / QUANTITY_THREADS);
            myThread.endArray = (i + 1) * ARRAY_LENGTH / QUANTITY_THREADS - 1;
            myThread.start();
        }

//        MyThread myThread0 = new MyThread();
//        myThread0.myArray = myArray;
//        myThread0.startArray = 0*(ARRAY_LENGTH/QUANTITY_THREADS);
//        myThread0.endArray = (0+1)*ARRAY_LENGTH/QUANTITY_THREADS-1;
//        myThread0.start();

        while (!treadsFinish(myThreads)) {
        }
        System.out.println(myThreads[0].biggestValue);

//        MyThread myThread1 = new MyThread();
//        myThread1.myArray = myArray;
//        myThread1.startArray = 1*(ARRAY_LENGTH/QUANTITY_THREADS);
//        myThread1.endArray = (1+1)*ARRAY_LENGTH/QUANTITY_THREADS-1;
//        myThread1.start();
//        while (!myThreads[1].finish) {
//        }
        System.out.println(myThreads[1].biggestValue);
//        while (!myThreads[2].finish) {
//        }
        System.out.println(myThreads[2].biggestValue);
        System.out.println(biggestValue(myThreads));
    }

    public static boolean treadsFinish(MyThread[] myThreads) {
        boolean finish = true;
        for (int i = 0; i < myThreads.length; i++) {
            if (!myThreads[i].finish) {
                finish = false;
            }
        }
        return finish;
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
}
