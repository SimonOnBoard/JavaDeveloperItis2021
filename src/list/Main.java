package list;


public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(8);
        linkedList.add(43);
        linkedList.add(25);
        linkedList.add(5);
        linkedList.removeLast(3);
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " - ");
        }
        LinkedList list = new LinkedList();
        list.add(43);
        list.add(5);

        System.out.println(linkedList.removeAll(list));
        System.out.println("After deleting: ");
        Iterator iterator1 = linkedList.iterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " - ");
        }
     }
}
