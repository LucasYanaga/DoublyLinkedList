import java.util.Objects;

public class DoublyLinkedList<T>{
    Node<T> top;
    Node<T> base;
    int size = 0;
    int capacity;

    public DoublyLinkedList(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull(){
        return this.size == this.capacity;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void add(T data){
        if(!this.isFull()){
            Node<T> newNode = new Node(data);
            if (this.isEmpty()) {
                this.base = newNode;
                this.top = newNode;
                this.size++;
            } else {
                newNode.setPrev(this.top);
                this.top.setNext(newNode);
                this.top = newNode;
                this.size++;
            }
        }else{
            System.out.println("Lista cheia!");
        }
    }

    public void add(int index, T data){
        if(!this.isFull()){
            index = Objects.checkIndex(index, this.size);

            if (index == this.size) {
                this.add(data);
            } else {
                Node<T> newNode = new Node(data);
                Node<T> next = this.getNode(index);
                Node<T> prev = next.getPrev();

                if (prev == null) {
                    newNode.setNext(next);
                    next.setPrev(newNode);
                    this.base = newNode;
                } else {
                    newNode.setPrev(prev);
                    newNode.setNext(next);

                    prev.setNext(newNode);
                    next.setPrev(newNode);
                }

                this.size++;
            }
        }
    }

    public T remove(int index){
        if(!this.isEmpty()){
            Node<T> node = getNode(index);
            return this.remove(node);
        }else{
            return null;
        }
    }

    private T remove(Node<T> node){
        Node<T> prev = node.getPrev();
        Node<T> next = node.getNext();

        if(prev == null){
            node.setNext(null);
            next.setPrev(null);
            this.base = next;
        }else if(next == null){
            node.setPrev(null);
            prev.setNext(null);
            this.top = prev;
        }else{
            prev.setNext(next);
            next.setPrev(prev);

            node.setNext(null);
            node.setPrev(null);
        }

        this.size--;

        return node.getData();
    }

    public Node<T> getNode(int index){
        index = Objects.checkIndex(index, this.size);
        int mid = this.size/2;
        Node<T> current;

        if(index < mid) {
            current = this.base;
            for (int i = 0; i < index + 1; i++) {
                current = current.getNext();
            }
        }else{
            current = this.top;
            for (int i = this.size; i > index + 1; i--) {
                current = current.getPrev();
            }
        }

        return current;
    }

    public T getData(int index){
        Node<T> node = this.getNode(index);

        return node.data;
    }

    public void setData(int index, T data){
        Node<T> node = this.getNode(index);

        node.setData(data);
    }

    public void print(){
        Node<T> current = this.base;

        System.out.print("[");
        for (int i = 0; i < this.size; i++) {
            if(i == this.size - 1){
                System.out.print(current.getData());
            }else{
                System.out.print(current.getData() + ", ");
            }

            current = current.getNext();
        }
        System.out.println("]");
    }

    public Node<T> getTop() {
        return top;
    }

    public void setTop(Node<T> top) {
        this.top = top;
    }

    public Node<T> getBase() {
        return base;
    }

    public void setBase(Node<T> base) {
        this.base = base;
    }

    public int getSize(){
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
