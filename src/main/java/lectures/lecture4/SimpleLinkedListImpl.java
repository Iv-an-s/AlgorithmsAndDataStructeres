package lectures.lecture4;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    private int size;
    private Node<E> firstElement;



    @Override
    public void insertFirst(E value) {
        Node<E> node = new Node<>(value, firstElement);
        firstElement = node;
        size++;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }
        Node<E> removedElement = firstElement;
        firstElement = removedElement.next;
        removedElement.next = null;

        size--;
        return removedElement.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E>previous = null;
        Node<E>current = firstElement;
        while (current!=null){
            if (current.item.equals(value)){
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null){
            return false;
        }else if (current == firstElement){
            removeFirst();
            return true;
        }else{
            previous.next = current.next;
        }
        current.next = null;
        size--;
        return true;
    }

//    O(N)
    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current!=null){
            if(current.item.equals(value)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        Node<E>current = firstElement;
        StringBuilder sb = new StringBuilder("[");
        while (current!=null){
            sb.append(current.item);
            if(current.next != null){
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void display() {
        System.out.println("---------");
        System.out.println(this);
        System.out.println("---------");
    }

    @Override
    public E getFirst() {
        return firstElement.item!=null ? firstElement.item : null;
    }

    class Node<E>{
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}