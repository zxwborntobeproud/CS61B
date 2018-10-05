public class ArrayDeque<T> implements Deque<T>{
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;

    public ArrayDeque(){
        size = 0;
        nextFirst = 0;
        nextLast = 1;
        items = (T[]) new Object[8];
    }

    private T[] reSize(){
        T[] newArray = (T[]) new Object[size*2];
        System.arraycopy(items, 0, newArray, 0, size);
        return newArray;
    }

    public void addFirst(T item) {
        //Adds an item of type T to the front of the deque.
        if (size < items.length){
            items[nextFirst] = item;
            if(size < items.length - 1) {
                nextFirst = (nextFirst - 1 < 0) ? items.length - 1 : nextFirst - 1;
            } else {
                nextFirst = items.length * 2 - 1;
                nextLast = size + 1;
            }
        }else{
            items = reSize();
            items[nextFirst] = item;
            nextFirst -= 1;
        }
        size += 1;
    }
    public void addLast(T item) {
        //Adds an item of type T to the back of the deque.
        if (size < items.length){
            items[nextLast] = item;
            if(size < items.length - 1) {
                nextLast = (nextLast + 1 >= items.length) ? 0 : nextLast + 1;
            } else {
                nextFirst = items.length * 2 - 1;
                nextLast = size + 1;
            }
        }else{
            items = reSize();
            items[nextLast] = item;
            nextLast += 1;
        }
        size += 1;
    }
    public boolean isEmpty(){
        //Returns true if deque is empty, false otherwise.
        return size == 0;
    }
    public int size(){
        //Returns the number of items in the deque.
        return size;
    }
    public void printDeque(){
        //Prints the items in the deque from first to last, separated by a space.
        for (T i : items ){
            if (i != null) {
                System.out.print(i + " ");
            }
        }
    }

    private T[] checkPerformance(){
        T[] newArray = (T[]) new Object[items.length/2];
        if (nextLast > nextFirst){
            System.arraycopy(items, nextFirst+1,newArray, 0, size);
            nextFirst = newArray.length - 1;
            nextLast = size;
        }else{
            System.arraycopy(items, nextFirst+1, newArray, 0, items.length - nextFirst - 1);
            System.arraycopy(items, 0, newArray, items.length - nextFirst - 1, nextLast);
            nextFirst = newArray.length - 1;
            nextLast = size;
        }
        return newArray;
    }

    public T removeFirst() {
        //Removes and returns the item at the front of the deque. If no such item exists, returns null.
        if (isEmpty()){
            return null;
        }
        nextFirst = (nextFirst+1 >= items.length)? 0: nextFirst+1;
        T delete = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        float space = (float) items.length;
        boolean check = (size/space) < 0.25 && space > 15;
        if (check){
            items = checkPerformance();
        }
        return delete;
    }
    public T removeLast() {
        //Removes and returns the item at the back of the deque. If no such item exists, returns null.
        if (isEmpty()){
            return null;
        }
        nextLast = (nextLast - 1 < 0)? items.length -1: nextLast - 1;
        T delete = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        float space = (float) items.length;
        boolean check = (size/space) < 0.25 && space > 15;
        if (check){
            items = checkPerformance();
        }
        return delete;
    }

    public T get(int index) {
        //Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
        if (index >= size){
            return null;
        }else{
            return items[index];
        }
    }
}
