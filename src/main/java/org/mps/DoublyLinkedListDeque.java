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

        if(size == 0){
            this.first = aux;
            this.last = aux;
        }else{
            if(this.first.equals(this.last)){
                aux.setNext(this.last);
                this.last.setPrevious(aux);
                this.first = aux;
            }else{
                this.first.setPrevious(aux);
                aux.setNext(this.first);
                this.first = aux;
            }
        }
        this.size++;
    }

    @Override
    public void append(T value) {
        // TODO
        DequeNode<T> aux = new DequeNode<>(value, null, null);

        if(size == 0){
            this.first = aux;
            this.last = aux;
        }else{
            if(this.first.equals(this.last)){
                aux.setPrevious(this.first);
                this.first.setNext(aux);
                this.last = aux;
            }else{
                this.last.setNext(aux);
                aux.setPrevious(this.last);
                this.last = aux;
            }
        }
        this.size++;
    }

    @Override
    public void deleteFirst() {
        // TODO
        if(this.first == null){
            throw new DoubleEndedQueueException("First is null");
        }else{
            if(this.size==1){
                this.first = null;
                this.last = null;
            }else{
                if(this.first.getNext() == null){
                    this.first = this.last;
                }else{
                    this.first = this.first.getNext();
                    this.first.setPrevious(null);
                }
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
                if(this.last.getPrevious() == null){
                    this.last = this.first;
                }else{
                    this.last = this.last.getPrevious();
                    this.last.setNext(null);
                }
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
}
