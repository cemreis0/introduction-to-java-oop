package Ch11.Ch11Lvl2;

public class Sorting {
    public static void main(String[] args) {

    }

    /*
     First we locate the smallest element in the array and set the index min to point to this element. Then we
    exchange number[start] and number[min]. After the first pass, the smallest element
    is moved to the correct position. We increment the value of start by 1 and then
    execute the second pass. We start the first pass with start = 0 and end the last pass
    with start = N-2.
    */
    public static void selectionSort(int[] number) {
        int minIndex, length, temp;
        length = number.length;

        //each iteration of the for loop is one pass
        for (int startIndex = 0; startIndex <= length-2; startIndex++) {
            minIndex = startIndex;

            //find the smallest in this pass at
            //position minIndex
            for (int i = startIndex; i <= length-1; i++) {
                if (number[i] < number[minIndex]) {
                    minIndex = i;
                }
            }

            //exchange number[startIndex] and number[minIndex]
            temp = number[startIndex];
            number[startIndex] = number[minIndex];
            number[minIndex] = temp;

            assert minStart(number, startIndex):
                    "Error: " + number[startIndex] +
                    " at position " + startIndex +
                    " is not the smallest.";
        }
    }

    // confirm that the smallest element in that pass moved to the beginning position of the pass
    private static boolean minStart(int[] number, int startIndex) {
        for (int i = startIndex+1; i < number.length; i++) {
            if (number[startIndex] > number[i]) {
                return false;
            }
        }
        return true;
    }


    // verify that no elements are out of place after the sorting is complete
    private static boolean isSorted(int[] number) {
        for (int i = 0; i < number.length-1; i++) {
            if (number[i] > number[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void bubbleSort(int[] number) {
        int temp, bottom;
        boolean exchanged = true;

        bottom = number.length - 2;

        while (exchanged) {
            exchanged = false;
            for (int i = 0; i <= bottom; i++) {
                if (number[i] > number[i+1]) {
                    temp = number[i]; //exchange
                    number[i] = number[i+1];
                    number[i+1] = temp;
                    exchanged = true; //exchange is made
                }
            }
            assert maxBottom(number, bottom):
                    "Error: " + number[bottom] +
                    " at position " + bottom +
                    " is not the largest.";
            bottom--;
        }

        assert isSorted(number): "Error: the final is not sorted";
    }

    private static boolean maxBottom(int[] number, int lastIndex) {
        for (int i = 0; i < lastIndex; i++) {
            if (number[lastIndex] < number[i]) {
                return false;
            }
        }
        return true;
    }
}
