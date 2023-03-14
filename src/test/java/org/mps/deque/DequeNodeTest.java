package org.mps.deque;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("A Integer queue")
class DequeNodeTest {

    DequeNode<Integer> node;
    private DequeNode<Integer> previous;
    private DequeNode<Integer> next;




    @Nested
    @DisplayName("when new")
    class TestCases {


        @BeforeEach
        void createNewQueue(){
            node = new DequeNode<>(1, null, null);
        }

        @AfterEach
        void shutdown(){
            node = null;
        }

        @Nested
        @DisplayName("Getters tests cases")
        class gettersTest{
        @Test
        @DisplayName("get a queue's item")
        void getItemTest(){
            int expectedValue = 1;
            assertEquals(expectedValue,node.getItem());
        }

        @Test
        @DisplayName("get the previous")
        void getPreviousTest(){
            assertNull(node.getPrevious());
        }

        @Test
        @DisplayName("get the next")
        void getNextTest(){
            assertNull(node.getNext());
        }

        }

        @Nested
        @DisplayName("Setters test cases")
        class settersTests{

            @Test
            @DisplayName("Set the item")
            void setItemCase(){
                int expected = 2;
                node.setItem(2);
                assertEquals(expected, node.getItem());
            }

            @Test
            @DisplayName("Set the previous")
            void setPreviousCase(){
                previous = new DequeNode<>(0, null, node);
                node.setPrevious(previous);
                assertEquals(previous, node.getPrevious());
            }

            @Test
            @DisplayName("Set the next")
            void setNextCase(){
                next = new DequeNode<>(2, node, null);
                node.setNext(next);
                assertEquals(next, node.getNext());
            }

        }

        @Nested
        @DisplayName("position tests cases")
        class positionTest{

           @Test
           @DisplayName("is the first node")
           void firstNodeTest(){
               next = new DequeNode<>(2, node, null);
               node.setNext(next);
               assertTrue(node.isFirstNode());
           }

            @Test
            @DisplayName("is the last node")
            void lastNodeTest(){
                previous = new DequeNode<>(0, null, node);
                node.setPrevious(previous);
                assertTrue(node.isLastNode());
            }

            @Test
            @DisplayName("is not terminal node")
            void notATerminalNodeTest(){
                previous = new DequeNode<>(0, null, node);
                node.setPrevious(previous);
                next = new DequeNode<>(2, node, null);
                node.setNext(next);
                assertTrue(node.isNotATerminalNode());

            }

            @Test
            @DisplayName("is a terminal node")
            void isATerminalNodeTest(){
                previous = new DequeNode<>(0, null, node);
                node.setPrevious(previous);
                assertFalse(node.isNotATerminalNode());
            }

            @Test
            @DisplayName("is a other terminal node")
            void isAOtherTerminalNodeTest(){
                next = new DequeNode<>(2, node, null);
                node.setNext(next);
                assertFalse(node.isNotATerminalNode());
            }
        }

    }




}