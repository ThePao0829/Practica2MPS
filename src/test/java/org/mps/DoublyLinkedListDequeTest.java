package org.mps;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListDequeTest {

    DoublyLinkedListDeque<Integer> deque;

    @Nested
    @DisplayName("DoublyLikneListDequeTest")
    class TestCases{
        @BeforeEach
        void setup(){
            deque = new DoublyLinkedListDeque<>();
        }

        @AfterEach
        void down(){
            deque = null;
        }

        @Test
        @DisplayName("EmptyDeque")
        void emptyDeque(){
            assertAll(
                    () -> assertTrue(deque.first()==null),
                    () -> assertTrue(deque.last()==null),
                    () -> assertTrue(deque.size()==0)
            );
        }
    }

}