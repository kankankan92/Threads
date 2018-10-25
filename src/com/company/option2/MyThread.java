package com.company.option2;

public class MyThread extends Thread {

    public int biggestValue;
    int[] myArray;
    int startArray;
    int endArray;

    public void biggestValue(int[] myArray, int startArray, int endArray) {
        biggestValue = myArray[startArray];
        for (int i = startArray; i <= endArray; i++) {
            if (biggestValue < myArray[i]) {
                biggestValue = myArray[i];
            }
        }
    }

    @Override
    public void run() {
        biggestValue(myArray, startArray, endArray);
        Main.incWorkedThreads();
    }
}
