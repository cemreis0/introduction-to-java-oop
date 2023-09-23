package Ch11.Ch11Lvl1;

public class SelectionSortString {
    // data members


    // constructors


    // main method
    public static void main(String[] args) {

    }

    // selection sort the given string array
    public String[] sort(String[] array) {
        int minIndex, length;
        String temp;
        length = array.length;

        //each iteration of the for loop is one pass
        for (int startIndex = 0; startIndex <= length - 2; startIndex++) {
            minIndex = startIndex;

            // find the smallest in this pass at position minIndex
            for (int i = startIndex; i <= length - 1; i++) {
                if (array[i].compareTo(array[minIndex]) < 0) {
                    minIndex = i;
                }
            }

            //exchange number[startIndex] and number[minIndex]
            temp = array[startIndex];
            array[startIndex] = array[minIndex];
            array[minIndex] = temp;
        }

        return array;
    }
}