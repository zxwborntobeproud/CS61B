public class ArrayDeque<T> {
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
        //TODO: Adds an item of type T to the front of the deque.
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
        }
        size += 1;
    }
    public void addLast(T item) {
        //TODO: Adds an item of type T to the back of the deque.
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
        }
        size += 1;
    }
    public boolean isEmpty(){
        //TODO:Returns true if deque is empty, false otherwise.
        return size == 0;
    }
    public int size(){
        //TODO Returns the number of items in the deque.
        return size;
    }
    public void printDeque(){
        //TODO: Prints the items in the deque from first to last, separated by a space.
        for (int i = 0; i < items.length; i++ ){
            System.out.print(items[i] + " ");
        }
    }

//    public T removeFirst() {
//        //TODO:Removes and returns the item at the front of the deque. If no such item exists, returns null.
//        if (isEmpty()){
//            return null;
//        }
//        nextFirst = (nextFirst+1 >= items.length)? 0: nextFirst+1;
//        T delete = items[nextFirst];
//        items[nextFirst] = null;
//        size -= 1;
//        if (items.length >= 16 && size/items.length < 0.25){
//            items = checkPerformance();
//        }
//        return delete;
//    }
//    public T removeLast() {
//        //TODO:Removes and returns the item at the back of the deque. If no such item exists, returns null.
//        if (isEmpty()){
//            return null;
//        }
//        int index = (nextLast - 1 < 0)? items.length -1: nextLast - 1;
//        T delete = items[index];
//        items[index] = null;
//        findNextLast();
//        size -= 1;
//        if (items.length >= 16 && size/items.length < 0.25){
//            items = checkPerformance();
//        }
//        return delete;
//    }
    public T get(int index) {
        //TODO:Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
        if (index >= size){
            return null;
        }else{
            return items[index];
        }
    }
    public static void main(String[] args){
        ArrayDeque<Integer> test = new ArrayDeque<>();
        test.addFirst(1);
        test.addFirst(2);
        test.addLast(3);
        test.printDeque();
    }
}
