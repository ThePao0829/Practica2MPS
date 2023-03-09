package org.mps.deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("A Integer queue")
class DequeNodeTest {

    DequeNode<Integer> queue;
    private DequeNode<Integer> previous;
    private DequeNode<Integer> next;


    private Integer item;

    @Test
    @DisplayName("is instantiated with new DequeNode()")
    void isInstantiatedWithNew(){
        new DequeNode<>(item, previous, next);
    }

    @Nested
    @DisplayName("when new")

    class whenNew {

        @BeforeEach
        void createNewQueue(){
            queue = new DequeNode<>(item, previous, next);
        }

        @Test
        @DisplayName("is empty")
        void isEmpty(){
            assertTrue(queue == null);
        }


    }




}