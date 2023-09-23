package Ch11.Ch11Lvl1;

import java.util.Arrays;

public class BubbleSortStringTest {
    public static void main(String[] args) {
        BubbleSortString bubbleSortString = new BubbleSortString();
        String[] array = {"banana", "apple", "cherry", "date", "fig"};
        System.out.println(Arrays.toString(bubbleSortString.sort(array)));
    }
}
