import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements Iterable<E> {

    // --- Nested Node Class (implements Position) ---
    private class Node implements Position<E> {
        private E element;
        private Node prev;
        private Node next;

        Node(E e, Node p, Node n) {
            element = e; prev = p; next = n;
        }

        @Override public E getElement() { return element; }
    }

    private Node header;
    private Node trailer;
    private int size = 0;

    public LinkedPositionalList() {
        header = new Node(null, null, null);
        trailer = new Node(null, header, null);
        header.next = trailer;
    }

    private Node validate(Position<E> p) {
        if (p == null) throw new IllegalArgumentException("null position");
        if (!(p instanceof Node)) throw new IllegalArgumentException("invalid position");
        Node node = (Node) p;
        if (node.next == null) throw new IllegalStateException("position no longer in list");
        return node;
    }
    private Position<E> position(Node node) {
        return (node == header || node == trailer) ? null : node;
    }
    private Position<E> addBetween(E e, Node pred, Node succ) {
        Node newest = new Node(e, pred, succ);
        pred.next = newest;
        succ.prev = newest;
        size++;
        return newest;
    }

    public Position<E> first()               { return position(header.next); }
    public Position<E> last()                { return position(trailer.prev); }
    public Position<E> before(Position<E> p) { Node n = validate(p); return position(n.prev); }
    public Position<E> after(Position<E> p)  { Node n = validate(p); return position(n.next); }

    public Position<E> addFirst(E e)                   { return addBetween(e, header, header.next); }
    public Position<E> addLast(E e)                    { return addBetween(e, trailer.prev, trailer); }
    public Position<E> addBefore(Position<E> p, E e)   { Node n = validate(p); return addBetween(e, n.prev, n); }
    public Position<E> addAfter(Position<E> p, E e)    { Node n = validate(p); return addBetween(e, n, n.next); }

    public E set(Position<E> p, E e) {
        Node n = validate(p);
        E old = n.element;
        n.element = e;
        return old;
    }

    public E remove(Position<E> p) {
        Node n = validate(p);
        Node pred = n.prev, succ = n.next;
        pred.next = succ; succ.prev = pred;
        size--;
        E old = n.element;
        n.element = null; n.prev = null; n.next = null;
        return old;
    }

    private class ElementIterator implements Iterator<E> {
        Position<E> cursor = first(); 

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public E next() {
            if (cursor == null) throw new NoSuchElementException();
            E ans = cursor.getElement();   
            cursor = after(cursor);        
            return ans;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder("[");
        boolean firstOut = true;
        for (E e : this) {
            if (!firstOut) sb.append(", ");
            sb.append(e);
            firstOut = false;
        }
        return sb.append("]").toString();
    }
}
