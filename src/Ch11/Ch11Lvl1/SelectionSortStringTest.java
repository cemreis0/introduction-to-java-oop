package Ch11.Ch11Lvl1;

import java.util.Arrays;

public class SelectionSortStringTest {
    public static void main(String[] args) {
        SelectionSortString selectionSortString = new SelectionSortString();
        String[] array = {"banana", "apple", "cherry", "date", "fig"};
        System.out.println(Arrays.toString(selectionSortString.sort(array)));
    }
}
