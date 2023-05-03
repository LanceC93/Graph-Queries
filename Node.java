public class Node<E> {
    //contains value of the node
    public E info;
    //represents next node
    public Node<E> next;

    //constructs a node with parameters
    public Node(E e, Node<E> n) {
        info = e;
        next = n;
    }
}
