 public class LinkedList {
    Node head;

    public void append(int data) {
        Node node = new Node(data);
        if (isEmpty()) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    public void prepend(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void delete(int data) throws InvalidDataException {
        if (!contains(data)) {
            throw new InvalidDataException("List does not contains " + data);
        } else {
            if (data == head.data) {
                head = head.next;
                return;
            } else {
                // 0 -> 1 -> 2 -> 4 -> null
                Node current = head;
                while (current.next.data != data) {
                    current = current.next;
                }
                current.next = current.next.next;
            }
        }
    }

    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data)
                return true;
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int indexOf(int data) throws InvalidDataException {
        if (!contains(data)) {
            throw new InvalidDataException("List does not contains " + data);
        } else {
            int sayac = 0;
            Node current = head;
            while (current.data != data) {
                current = current.next;
                sayac++;
            }
            return sayac;
        }
    }

    public int get(int index) throws InvalidIndexException {
        if (index >= 0 && index < size()) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }
        throw new InvalidIndexException("Invalid Index!");
    }

    public void clear() {
        head = null;
    }

    /*
         10 20 30 40 50 60
    */

    public int getFirst() throws EmptyListException {
        if (!isEmpty())
            return head.data;
        throw new EmptyListException("List is empty!");
    }

    /*
        10 20 30 40 50 60
    */
    public int getLast() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("List is empty!");
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    //   1 -> 2 -> 3 -> 4 -> 5
    // head
    // current
    public int size() {
        Node current = head;
        int sayac=0;
        while (current != null){
            current=current.next;
            sayac++;

        }
        return sayac;
    }
}
