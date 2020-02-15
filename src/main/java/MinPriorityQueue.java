
/*
    min prio queue implemnted as binary heap, using array
 */

//check vals now that have made 0 element blank

import java.util.Arrays;

public class MinPriorityQueue<T extends Comparable<T>> {

    private int capacity = 10;
    /* front of the queue array is index 0, back is the greatest index of element in the array */
    private T[] data;
    private int back; //greatest index
    private final static int FRONT = 1; //first index left blank to simplify nav functions

    public MinPriorityQueue() {
        //maybe could do objects, see arraylist source code for an example
        data = (T[]) new Comparable[capacity];
        back = 0;
    }

    //testing
    public MinPriorityQueue(int maxCap) {
        capacity = maxCap;
        data = (T[]) new Comparable[capacity];
        back = 0;
    }

    //swap to elements for purpose of sorting
    private void swap(int parentIndex, int current) {
        T tmp = data[parentIndex];
        data[parentIndex] = data[current];
        data[current] = tmp;
    }

    //-1 element at start so
    public int size() {
        return back;
    }

    public void add(T elem) {

        if (back == capacity-1) {
            doubleArrayCapacity();
        }

        data[++back] = elem;

        //if the array was empty before we added the element then we are done
        if (back == 1) {
            return;
        }

        //start: binary heap add - lec 8 for reference
        int current = back; //current
        int parent = current/2;

        System.out.println("current at start: " + current);

        while((elem.compareTo(data[parent]) < 0) && parent > 0) {
            swap(parent, current);
            parent = current/2;
        }

    }

    //i guess this is a reasonable way of doing it
    //check values
    private void doubleArrayCapacity() {
        capacity *= 2;
        data = Arrays.copyOf(data, capacity);
    }

    //feel like this is necessary in the instance where a lot of elements
    //are added and then subsequently removed
    private void trim() {
        capacity = back+1;
        data = Arrays.copyOf(data, capacity);
    }

    public T remove() {
        if (isEmpty()) {
            return null;
        }

        T toRemove = (T)data[FRONT];
        //implement reorganising array
        return null; //placeholder
    }


    public T front() {
        return (data[FRONT]);
    }

    public T back() {
        return (data[back]);
    }

    public boolean isEmpty() {
        return (back == 0);
    }

    public static void main(String[] args) {
        MinPriorityQueue<Integer>  testQueue = new MinPriorityQueue<>();
    }

}