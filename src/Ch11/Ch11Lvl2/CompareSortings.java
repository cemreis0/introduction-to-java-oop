/*
Write a test program to compare the performances of selection sort,
bubble sort, and heapsort algorithms experimentally. Randomly generate
5000 integers, and sort the generated integers by using the three sorting
algorithms. For each execution, record the time it took to sort the numbers.
*/

package Ch11.Ch11Lvl2;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;
public class CompareSortings {
    public static void main(String[] args) {
        HeapWithOneArray heap = new HeapWithOneArray();
        Random random = new Random();
        Date startTime, endTime;
        double elapsedTimeSelection, elapsedTimeBubble, elapsedTimeHeap;
        int[]   selectionSortArray = new int[5000],
                bubbleSortArray = new int[5000],
                heapSortArray = new int[5000];
        int randomInt;

        for (int i = 0; i < 5000; i++) {
            randomInt = random.nextInt();
            // generate the arrays with the same numbers
            selectionSortArray[i] = randomInt;
            bubbleSortArray[i] = randomInt;
            heapSortArray[i] = randomInt;
        }

        startTime = new Date();
        Sorting.selectionSort(selectionSortArray);
        endTime = new Date();
        elapsedTimeSelection = endTime.getTime() - startTime.getTime();

        System.out.println("Selection sort elapsed time: " + elapsedTimeSelection);
        System.out.println(Arrays.toString(selectionSortArray));

        startTime = new Date();
        Sorting.bubbleSort(bubbleSortArray);
        endTime = new Date();
        elapsedTimeBubble= endTime.getTime() - startTime.getTime();

        System.out.println("Bubble sort elapsed time: " + elapsedTimeBubble);
        System.out.println(Arrays.toString(bubbleSortArray));

        heap.setData(heapSortArray);
        startTime = new Date();
        heapSortArray = heap.sort();
        endTime = new Date();
        elapsedTimeHeap = endTime.getTime() - startTime.getTime();

        System.out.println("Heap sort elapsed time: " + elapsedTimeHeap);
        System.out.println(Arrays.toString(heapSortArray));
    }
}

