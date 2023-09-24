/*
In the Heap class, we used two separate arrays: one for the heap and another
for the sorted list. It turns out we can do everything with just one array.
Notice that the heap will decrease in size by one element after every rebuild
step. The unused space at the end of the heap array can be used to store the
sorted list. Modify the Heap class so it will use only one array.
*/

package Ch11.Ch11Lvl2;

public class HeapWithOneArray {
    // data members
    int[] heap,        // implements the heap
            sortedArray; // stores the sorted list

    // constructors
    public HeapWithOneArray() {

    }

    public void setData(int[] data) {
        heap = new int[data.length];
        sortedArray = new int[data.length];

        heap = data.clone();
    }

    public int[] sort() {
        construct(); // perform the construction phase
        extract(); // perform the extraction phase
        return heap;
    }

    private void construct() {
        int currentIndex, maxChildIndex;
        boolean done;

        for (int i = (heap.length - 2) / 2; i >= 0; i--) {

            rebuild(i, heap.length-1);

            assert isValidHeap(heap, i, heap.length - 1) : "Error: Construction phase is not working correctly.";
        }
    }

    private void extract() {


        for (int size = heap.length - 1; size >= 0; size--) {
            int temp;

            rebuild(0, size);

            temp = heap[0];
            // move the last node to the root
            heap[0] = heap[size];
            // add the root node to the end of the array
            heap[size] = temp;


            assert isValidHeap(heap, size, heap.length - 1) : "Error: Construction phase is not working correctly";
        }
    }

    private void rebuild(int startIndex, int size) {
        int currentIndex, maxChildIndex;
        boolean done;

        //rebuild the heap with one fewer element
        currentIndex = startIndex;
        done = false;

        while (!done) {
            if (2 * currentIndex + 1 > size) {
                // current node has no children, so stop
                done = true;
            } else {
                // current node has at least one child, get the index of larger child
                maxChildIndex = getMaxChildIndex(currentIndex, size);
                if (heap[currentIndex] < heap[maxChildIndex]) {
                    // a child is larger, so swap and continue
                    swap(currentIndex, maxChildIndex);
                    currentIndex = maxChildIndex;
                } else {
                    //value relationship constraint is satisfied, so stop
                    done = true;
                }
            }
        }
    }

    private int getMaxChildIndex(int location, int end) {
        int result, leftChildIndex, rightChildIndex;

        leftChildIndex = 2 * location + 1;
        rightChildIndex = 2 * location + 2;

        assert leftChildIndex <= end : "Error: node at position " + location + " has no children.";

        if (rightChildIndex <= end && heap[leftChildIndex] < heap[rightChildIndex]) {
            result = rightChildIndex;
        } else {
            result = leftChildIndex;
        }

        return result;
    }

    private void swap(int loc1, int loc2) {
        int temp;
        temp = heap[loc1];
        heap[loc1] = heap[loc2];
        heap[loc2] = temp;
    }

    private boolean isValidHeap(int[] heap, int start, int end) {
        for (int i = start; i < end / 2; i++) {
            if (heap[i] < Math.max(heap[2 * i + 1], heap[2 * i + 2])) {
                return false;
            }
        }
        return true;

    }
}
