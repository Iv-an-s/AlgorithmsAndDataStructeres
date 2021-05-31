package homework4.doubleWayLinkedListDeque;

import homework3.deque.Deque;
import lectures.lecture4.SimpleLinkedListImpl;

import java.util.Iterator;

public class DoubleWayLinkedList<E> extends SimpleLinkedListImpl<E>{

    private Node<E> lastElement;

    @Override
    public void insertFirst(E value) {
        Node<E> node = new Node<E>(value, null, null);
        if(isEmpty()){
            lastElement = node;
            firstElement= node;
        }
        Node<E>tempFirst = firstElement;
        firstElement = node;
        firstElement.next = tempFirst;

        size++;
    }

    public void insertLast(E value) {
        Node<E> node = new Node<E>(value, null, null);
        if(isEmpty()){
            lastElement = node;
            firstElement= node;
        }
        lastElement.next = node;
        Node<E>tempLast = lastElement;
        lastElement = node;
        lastElement.previous = tempLast;

        size++;
    }


    @Override
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }
        Node<E> removedElement = firstElement;
        firstElement = removedElement.next;
        E item = removedElement.item;
        removedElement = null;
        firstElement.previous = null;

        size--;
        return item;
    }

    public E removeLast() {
        if(isEmpty()){
            return null;
        }
        Node<E> removedElement = lastElement;
        lastElement = removedElement.previous;
        E item = removedElement.item;
        removedElement = null;
        lastElement.next = null;

        size--;
        return item;
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
        }else if (current == lastElement){
            removeLast();
            return true;
        }else{
            previous.next = current.next;
            current.next.previous = previous;
        }
        current.next = null;
        current.previous = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        return super.contains(value);
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void display() {
        super.display();
    }

    @Override
    public E getFirst() {
        return super.getFirst();
    }

    public E getLast(){
        return lastElement !=null ? lastElement.item : null;
    }

    @Override
    public Iterator<E> iterator() {
        return super.iterator();
    }
}
