package Ch11.Ch11Lvl1;

public class BubbleSortString {
    // data members

    // constructors
    public BubbleSortString() {

    }

    // main method
    public static void main(String[] args) {

    }

    public String[] sort(String[] array) {
        int bottom;
        boolean exchanged = true;
        String temp;
        bottom = array.length - 2;

        while (exchanged) {
            exchanged = false;
            for (int i = 0; i <= bottom; i++) {
                // greater than 0 means the other string is bigger
                if (array[i].compareTo(array[i+1]) > 0) {
                    temp = array[i]; //exchange
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    exchanged = true; //exchange is made
                }
            }
            bottom--;
        }

        return array;
    }
}
