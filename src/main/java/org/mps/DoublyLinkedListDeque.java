package org.mps;

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
        DequeNode<T> aux = new DequeNode<>(value, null, null);
        if(this.first == null){
            aux.setNext(this.first);
            this.first = aux;
        }else{
            this.first.setPrevious(aux);
            aux.setNext(this.first);
        }
    }

    @Override
    public void append(T value) {
        // TODO
        DequeNode<T> aux = new DequeNode<>(value, null, null);
        if(this.last == null){
            aux.setPrevious(this.last);
            this.last = aux;
        }else{
            this.last.setNext(aux);
            aux.setPrevious(this.last);
        }
    }

    @Override
    public void deleteFirst() {
        // TODO
        if(this.first == null){
            throw new DoubleEndedQueueException("First is null");
        }else{
            DequeNode<T> aux = this.first;
            this.first = aux.getNext();
            this.first.setPrevious(null);
        }
    }

    @Override
    public void deleteLast() {
        // TODO
        if(this.last == null){
            throw new DoubleEndedQueueException("Last is null");
        }else{
            DequeNode<T> aux = this.last;
            this.last = aux.getPrevious();
            this.last.setNext(null);
        }
    }

    @Override
    public T first() {
        // TODO
        if(this.first.getItem()==null){
            return null;
        }else{
            return this.first.getItem();
        }
    }

    @Override
    public T last() {
        // TODO
        return this.last.getItem();
    }

    @Override
    public int size() {
        // TODO
        return this.size;
    }
}
