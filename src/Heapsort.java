import java.util.Arrays;

public class Heapsort {
    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] intArray = new int[]{16523, 2, -25, 7, 5, 745, 2123, 23, 9, 400};

        heap.setData(intArray);

        System.out.println(Arrays.toString(heap.sort()));
    }
}

class Heap {
    // data members
    int[]   heap,        // implements the heap
            sortedArray; // stores the sorted list

    // constructors
    public Heap() {

    }

    public void setData(int[] data) {
        heap = new int[data.length];
        sortedArray = new int[data.length];

        heap = data.clone();
    }

    public int[] sort() {
        construct(); // perform the construction phase
        extract(); // perform the extraction phase
        return sortedArray;
    }

    private void construct( ) {
        int currentIndex, maxChildIndex;
        boolean done;

        for (int i = (heap.length-2) / 2; i >= 0; i--) {
            currentIndex = i;
            done = false;

            while (!done) {
                //perform one rebuild step with the node at index i
                if (2*currentIndex+1 > heap.length-1) {
                    // current node has no children, so stop
                    done = true;
                } else {
                    // current node has at least one child, get the index of larger child
                    maxChildIndex = getMaxChildIndex(currentIndex, heap.length-1);

                    if (heap[currentIndex] < heap[maxChildIndex]) {
                        // a child is larger, so swap and continue
                        swap(currentIndex, maxChildIndex);
                        currentIndex = maxChildIndex;
                    } else {
                        // the value relationship constraint is satisfied, so stop
                        done = true;
                    }

                }
            }
            assert isValidHeap(heap, i, heap.length-1): "Error: Construction phase is not working correctly.";
        }
    }

    private void extract() {
        int currentIndex, maxChildIndex;
        boolean done;

        for (int size = heap.length-1; size >= 0; size--) {
            //remove the root node data
            sortedArray[size] = heap[0];

            //move the last node to the root
            heap[0] = heap[size];

            //rebuild the heap with one fewer element
            currentIndex = 0;
            done = false;

            while (!done) {
                if (2*currentIndex+1 > size) {
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
            assert isValidHeap(heap, size, heap.length-1): "Error: Construction phase is not working correctly";
        }
    }

    private int getMaxChildIndex(int location, int end) {
        int result, leftChildIndex, rightChildIndex;

        leftChildIndex = 2 * location + 1;
        rightChildIndex = 2 * location + 2;

        assert leftChildIndex <= end: "Error: node at position " + location + " has no children.";

        if (rightChildIndex <= end && heap[leftChildIndex] < heap[rightChildIndex]) {
            result = rightChildIndex;
        } else {
            result = leftChildIndex;
        }

        return result;
    }

    private void swap (int loc1, int loc2) {
        int temp;
        temp = heap[loc1];
        heap[loc1] = heap[loc2];
        heap[loc2] = temp;
    }

    private boolean isValidHeap(int[] heap, int start, int end) {
        for (int i = start; i < end/ 2; i++) {
            if (heap[i] < Math.max(heap[2*i+1], heap[2*i+2])) {
                return false;
            }
        }
        return true;
    }
}