public class MainDLL {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList(100);

        //Add
        list.add(1);
        list.add(2);
        list.add(3);
        list.print();

        //Add index
        list.add(1, 4);
        list.print();
        list.add(0, 5);
        list.print();

        //set
        list.setData(0, 6);
        //get
        System.out.println(list.getData(0));
        list.print();

        //remove base
        list.remove(0);
        list.print();

        //remove top
        list.remove(list.getSize() - 1);
        list.print();

        //remove mid
        list.remove(1);
        list.print();

        list.add(9);
        list.print();

        list.add(2, 69);
        list.print();

    }
}
