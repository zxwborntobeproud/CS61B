public class LinkedListDeque<T> implements Deque<T>{
    public class Node{
        public T item;
        private Node prev;
        private Node next;

        public Node(){
            item = null;
            prev = null;
            next = null;
        }

        public Node(T x){
            item = x;
            prev = null;
            next = null;
        }
    }

    private Node watcher;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public LinkedListDeque(){
        this.watcher = new Node();
        size = 0;
    }

    public void addFirst(T item){
        Node newNode = new Node(item);
        newNode.prev = watcher;
        if (size == 0){
            newNode.next = watcher;
            watcher.prev = newNode;
        } else {
            newNode.next = watcher.next;
            watcher.next.prev = newNode;
        }
        watcher.next = newNode;
        size += 1;
    }

    public void addLast(T item){
        Node newNode = new Node(item);
        newNode.next = watcher;
        if (size == 0){
            newNode.prev = watcher;
            watcher.next = newNode;
        } else{
            newNode.prev = watcher.prev;
            watcher.prev.next = newNode;
        }
        watcher.prev = newNode;
        size += 1;
    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        T delete = watcher.next.item;
        watcher.next.next.prev = watcher;
        watcher.next = watcher.next.next;
        size -= 1;
        return delete;
    }

    @Override
    public T removeLast() {
        if (isEmpty()){
            return null;
        }
        T delete = watcher.prev.item;
        watcher.prev.prev.next = watcher;
        watcher.prev = watcher.prev.prev;
        return delete;
    }

    public T get(int index){
        if (index > size){
            return null;
        }
        Node ptr = watcher.next;
        while (index-1 != 0){
            ptr = ptr.next;
            index --;
        }
        return ptr.item;
    }

    public void printDeque(){
        for (int i = 1; i <= size; i++){
            System.out.println(get(i));
        }
    }

    private Node getNodeRecursive(int index){
        if (index > size){
            return null;
        }
        if (index == 0){
            return watcher;
        }
        index --;
        return getNodeRecursive(index).next;
    }

    public T getRecursive(int index){
        return getNodeRecursive(index).item;
    }


}
