package ru.itis;

class Sorter {
    private int[] helpArray;

    public void sort(int array[]) {
        helpArray = new int[array.length];
        sort(array, 0, array.length - 1);
    }

    public void sort(int array[], int lower, int higher) {
        LogUtils.log(array, "sort", lower, higher);
        if (lower >= higher) {
            return;
        }

        int middle = lower + (higher - lower) / 2;

        LogUtils.indentUp();

        sort(array, lower, middle);
        sort(array, middle + 1, higher);
        merge(array, lower, middle, higher);

        LogUtils.indentDown();
    }


    // merge subarrays:
    // array[lower..middle] and array[middle+1, higher]
    public void merge(int array[], int lower, int middle, int higher) {
        // copy subarray
        for (int currentIndex = lower; currentIndex <= higher; currentIndex++) {
            helpArray[currentIndex] = array[currentIndex];
        }

        int i = lower, j = middle + 1;

        for (int currentIndex =lower; currentIndex <= higher; currentIndex++) {
            if (i > middle) {
                array[currentIndex] = helpArray[j];
                j++;
            } else if (j > higher) {
                array[currentIndex] = helpArray[i];
                i++;
            } else if (helpArray[j] < helpArray[i]) {
                array[currentIndex] = helpArray[j];
                j++;
            } else if (helpArray[i] <= helpArray[j]) {
                array[currentIndex] = helpArray[i];
                i++;
            }
        }
        LogUtils.log(array, "merge", lower, higher);
    }
}