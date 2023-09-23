/*
 * We start by discussing sorting algorithms in Section 11.2 and the limitations of crossing out
 * numbers for further consideration when using arrays.
 * If we use a LinkedList for the original unsorted list, we can effectively
 * implement the action of crossing out a number and moving it to a sorted list.
 * Let `originalList` be a LinkedList. To remove an item from `originalList` at
 * index position I, we use the following code:
 *     originalList.remove(I);
 * This code will actually remove the item from the list, as opposed to
 * just marking it as removed, which is the case with an array.
 * This program includes suitable input and output routines, and it is designed
 * to work with integer data.
 */

package Ch11.Ch11Lvl2;

import java.util.LinkedList;
import java.util.List;

public class SortingAlgorithmWithLinkedList {
    public static void main(String[] args) {
        List<Integer> originalList = new LinkedList<>();
        List<Integer> sortedList = new LinkedList<>();
        int minIndex;

        originalList.add(182);
        originalList.add(21);
        originalList.add(3235);
        originalList.add(45);
        originalList.add(636266);

        while (originalList.size() != 0) {
            minIndex = 0;

            for (int i = 0; i < originalList.size(); i++) {
                if (originalList.get(minIndex) > originalList.get(i)) {
                    minIndex = i;
                }
            }

            sortedList.add(originalList.get(minIndex));
            originalList.remove(minIndex);
        }

        System.out.println(sortedList);
    }
}
