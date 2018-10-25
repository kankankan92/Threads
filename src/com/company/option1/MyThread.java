package com.company.option1;

public class MyThread extends Thread {

    public int biggestValue;
    int[] myArray;
    int startArray;
    int endArray;
    boolean finish = false;

    public void biggestValue(int[] myArray, int startArray, int endArray) {
        biggestValue = myArray[startArray];
        for (int i = startArray; i <= endArray; i++) {
            if (biggestValue < myArray[i]) {
                biggestValue = myArray[i];
            }
        }
    }
    @Override
    public void run () {
        biggestValue(myArray, startArray, endArray);
        finish = true;
//        System.out.println("хай");
    }
}
