package list;

import java.util.NoSuchElementException;

public class LinkedList implements List {

    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int count;

    @Override
    public int get(int index) {
        if (index < count && index > -1) {
            Node current = this.first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        }
        System.err.println("Out of Bounds");
        return -1;
    }

    @Override
    public void removeAt(int index) {
        if (index == 0) {
            first = first.next;
            count--;
            return;
        }
        Node current = first;
        Node temp = current;
        for (int i = 0; i < index; i++) {
            temp = current;
            current = current.next;
        }
        temp.next = current.next;
        count--;
    }

    @Override
    public int indexOf(int element) {
        int index = 0;
        Node current = first;
        boolean flag = false;
        while (!flag && index < count - 1) {
            if (current.value == element) {
                flag = true;
                return index;
            } else {
                current = current.next;
                index++;
            }
        }
        if (!flag) {
            System.err.println("The element isn't in List");
            return -1;
        } else {
            return index;
        }
    }

    @Override
    public int lastIndexOf(int element) {
        if (last.value == element) {
            return count - 1;
        } else {
            Node current = first;
            int index = 0;
            int i = 0;
            while (current.next != null) {
                if (current.value == element) {
                    index = i;
                    current = current.next;
                    i++;
                } else {
                    current = current.next;
                    i++;
                }
            }
            return index;
        }
    }

    @Override
    public void add(int element) {
        Node newNode = new Node(element);
        if (first == null) {
            this.first = newNode;
        } else {
            last.next = newNode;
        }
        this.last = newNode;
        this.count++;
    }

    @Override
    public int size() {
        return count;
    }


    @Override
    public void removeFirst(int element) {
        Node prev = first;
        Node current = first;
        if (current.value == element) {
            first = first.next;
            count--;
            return;
        }
        current = current.next;
        while (current != null) {
            if (current.value == element) {
                prev.next = current.next;
                count--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    @Override
    public void removeLast(int element) {
        //проверяем содержится ли элемент
        if (!contains(element)) throw new NoSuchElementException("Element not found");
        Node prev = first;
        Node current = first;
        //проверяем первый ли это элемент и единственный ли он
        Node prevBeforeDeleting = null;
        Node toDelete = null;
        if (current.value == element) {
            prevBeforeDeleting = null;
            toDelete = current;
        }
        current = current.next;
        //идём по всему списку и запоминаем элемент которые необходимо удалить + предыдущий перед ним
        while (current != null) {
            if (current.value == element) {
                prevBeforeDeleting = prev;
                toDelete = current;
            }
            prev = current;
            current = current.next;
        }
        if (prevBeforeDeleting != null) {
            prevBeforeDeleting.next = toDelete.next;
        } else {
            first = first.next;
        }
        count--;
    }

    @Override
    public boolean removeAll(Collection elements) {
        int currentSize = count;
        Iterator iterator = elements.iterator();
        while (iterator.hasNext()) {
            //элемент который нужно сейчас удалить
            int toDelete = iterator.next();
            //если этот элемент всё ещё содержится в нашей коллекции - удаляем
            while (contains(toDelete)) {
                this.removeFirst(toDelete);
            }
        }
        return currentSize != count;
    }

    @Override
    public boolean containsFromIndex(int element, int index) {
        Node current = first.next;
        boolean contains = false;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        while (!contains && index < count) {
            if (current.value == element) {
                contains = true;
            } else {
                current = current.next;
                index++;
            }
        }
        return contains;
    }

    @Override
    public boolean contains(int element) {
        Node current = first;
        while (current != null){
            if(current.value == element){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public class LinkedListIterator implements Iterator {

        private LinkedList.Node current;

        public LinkedListIterator() {
            this.current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public int next() {
            int value = current.value;
            current = current.next;

            return value;
        }
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }
}
