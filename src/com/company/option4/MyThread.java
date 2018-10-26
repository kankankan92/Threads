package com.company.option4;

public class MyThread extends Thread {

    public int biggestValue;
    private int[] myArray;
    private int startArray;
    private int endArray;

    public MyThread(int[] myArray, int startArray, int endArray) {
        this.myArray = myArray;
        this.startArray = startArray;
        this.endArray = endArray;
    }

    private void biggestValue(int[] myArray, int startArray, int endArray) {
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
        Main.START.countDown();
    }
}
