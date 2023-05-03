public class LinkedList<E> {
    public Node<E> head;
    public Node<E> currentPos;

    public LinkedList() {
        head = null;
    }
    public LinkedList(E e) {
        head = new Node<E>(e, null);
        reset();
    }
    public void next() {
        currentPos = currentPos.next;
    }

    public void reset() {
        currentPos = head;
    }
    public void insert(E item) {
        if(head == null) {
            head = new Node<E>(item,null);
            currentPos = head;
        } else {
            reset();
            while(currentPos.next != null) {
                currentPos = currentPos.next;
            }
            currentPos.next = new Node<E>(item, null);
            currentPos = currentPos.next;
        }
    }

    public E currentValue() {
        return currentPos.info;
    }
    public E headValue() {
        return head.info;
    }
}
