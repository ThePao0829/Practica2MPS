package org.mps.deque;

import java.util.Comparator;

/***
 * @author Fan Yang
 * @author Longxiang Chen Chen
 */

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        // TODO
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public void prepend(T value) {
        // TODO
        DequeNode<T> aux;

        if(size == 0){
            aux = new DequeNode<>(value, null, null);
            this.last = aux;
        }else{
            aux = new DequeNode<>(value, null, this.first);
            if(size == 1){
                this.last.setPrevious(aux);
            }else{
                this.first.setPrevious(aux);
            }
        }
        this.first = aux;
        this.size++;
    }

    @Override
    public void append(T value) {
        // TODO
        DequeNode<T> aux;

        if(size == 0){
            aux = new DequeNode<>(value, null, null);
            this.first = aux;
        }else{
            aux = new DequeNode<>(value, this.last, null);
            if(size == 1){
                this.first.setNext(aux);
            }else{
                this.last.setNext(aux);
            }
        }
        this.last = aux;
        this.size++;
    }

    @Override
    public void deleteFirst() {
        // TODO
        if(this.first == null){
            throw new DoubleEndedQueueException("First is null");
        }else{
            if(this.size == 1){
                this.first = null;
                this.last = null;
            }else{
                this.first = this.first.getNext();
                this.first.setPrevious(null);
            }
            this.size--;
        }
    }

    @Override
    public void deleteLast() {
        // TODO
        if(this.last == null){
            throw new DoubleEndedQueueException("Last is null");
        }else{
            if(this.size == 1){
                this.first = null;
                this.last = null;
            }else{
                this.last = this.last.getPrevious();
                this.last.setNext(null);
            }
            this.size--;
        }
    }

    @Override
    public T first() {
        // TODO
        if(this.first == null){
            return null;
        }else{
            return this.first.getItem();
        }
    }

    @Override
    public T last() {
        // TODO
        if(this.last == null){
            return null;
        }else{
            return this.last.getItem();
        }
    }

    @Override
    public int size() {
        // TODO
        return this.size;
    }

    @Override
    public T get(int index) {
        T item;
        DequeNode<T> node;
        node = first;
        int position = 0;
        if(index == 0){
            item = first.getItem();
        }else{
            while (node != null && position != index){
                node = node.getNext();
                position++;
            }
            if(node == null){
                throw new IndexOutOfBoundsException("fuera del indice");
            }
            item = node.getItem();
        }

        return item;
    }

    @Override
    public boolean contains(T value) {
        boolean contains = false;
        DequeNode<T> node;
        node = first;
        if(first.getItem() == value){
            contains = true;
        }else {
            while (node != null && node.getItem() != value){
                node = node.getNext();
            }
            if(node == null){
                throw new IndexOutOfBoundsException("fuera de la cola");
            }else {
                contains = true;
            }
        }

        return contains;
    }

    @Override
    public void remove(T value) {

    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        /*......*/
    }
}
