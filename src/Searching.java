public class Searching {
    public static void main(String[] args) {

    }

    // The linear search is also called a sequential search.
    public static int linearSearch(int[] number, int searchValue) {
        int location = 0;

        while (location < number.length && number[location] != searchValue) {
            location++;
        }

        if (location == number.length) {
            return -1; // not found
        } else {
            return location;
        }
    }


    /*
    If number[mid] is less than the search value, then low is reset to mid+1. If
    number[mid] is greater than the search value, then high is reset to mid-1, and the
    search continues. Eventually, we will locate the search value, or we will run out of
    elements to compare. We know that there are no more elements to compare when
    low becomes larger than high.
    */
    public static int binarySearch(int[] number, int searchValue) {
        int     low = 0,
                high = number.length - 1,
                mid = (low + high) / 2;

        while (low < high && number[mid] != searchValue) {
            if (number[mid] < searchValue) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }

        if (low > high) {
            mid = -1;
        }

        return mid;
    }
}
