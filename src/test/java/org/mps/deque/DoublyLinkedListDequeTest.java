package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/***
 * @author Fan Yang
 * @author Longxiang Chen Chen
 */

class DoublyLinkedListDequeTest {

    DoublyLinkedListDeque<Integer> deque;

    @BeforeEach
    void setup(){
        deque = new DoublyLinkedListDeque<>();
    }

    @AfterEach
    void down(){
        deque = null;
    }

    @Nested
    @DisplayName("DoublyLinkedListDequeTest")
    class TestCases{

        @Nested
        @DisplayName("Empty deque test cases")
        class emptyDequeClass{
            @Test
            @DisplayName("EmptyDeque")
            void emptyDeque(){
                assertAll(
                        () -> assertThrows(DoubleEndedQueueException.class, () -> deque.first()),
                        () -> assertThrows(DoubleEndedQueueException.class, () -> deque.last()),
                        () -> assertEquals(0, deque.size())
                );
            }
            @Test
            @DisplayName("Throw exception if deleteFirst in empty deque")
            void deleteFirstEmptyDeque(){
                assertThrows(DoubleEndedQueueException.class, () -> deque.deleteFirst());
            }
            @Test
            @DisplayName("Throw exception if deleteLast in empty deque")
            void deleteLastEmptyDeque(){
                assertThrows(DoubleEndedQueueException.class, () -> deque.deleteLast());
            }
        }
        @Nested
        @DisplayName("Prepend test cases")
        class prependClass{
            @Test
            @DisplayName("Prepend one node")
            void prependOneNode(){
                int expectedValue = 1;
                deque.prepend(expectedValue);
                assertAll(
                        () -> assertEquals(expectedValue, deque.first()),
                        () -> assertEquals(expectedValue, deque.last()),
                        () -> assertEquals(deque.size(), 1)
                );
            }

            @Test
            @DisplayName("Prepend two node")
            void prependTwoNode(){
                int expectedValue1 = 1;
                int expectedValue2 = 2;
                deque.prepend(expectedValue2);
                deque.prepend(expectedValue1);
                assertAll(
                        () -> assertEquals(expectedValue1, deque.first()),
                        () -> assertEquals(expectedValue2, deque.last()),
                        () -> assertEquals(deque.size(), 2)
                );
            }

            @Test
            @DisplayName("Prepend three node")
            void prependThreeNode(){
                int expectedValue1 = 1;
                int expectedValue2 = 2;
                int expectedValue3 = 3;
                deque.prepend(expectedValue3);
                deque.prepend(expectedValue2);
                deque.prepend(expectedValue1);
                assertAll(
                        () -> assertEquals(expectedValue1, deque.first()),
                        () -> assertEquals(expectedValue3, deque.last()),
                        () -> assertEquals(3, deque.size())
                );
            }
        }
        @Nested
        @DisplayName("Append test cases")
        class appendClass{
            @Test
            @DisplayName("Append one node")
            void appendOneNode(){
                int expectedValue = 1;
                deque.append(expectedValue);
                assertAll(
                        () -> assertEquals(expectedValue, deque.first()),
                        () -> assertEquals(expectedValue, deque.last()),
                        () -> assertEquals(deque.size(), 1)
                );
            }

            @Test
            @DisplayName("Append two node")
            void appendTwoNode(){
                int expectedValue1 = 1;
                int expectedValue2 = 2;
                deque.append(expectedValue1);
                deque.append(expectedValue2);
                assertAll(
                        () -> assertEquals(expectedValue1, deque.first()),
                        () -> assertEquals(expectedValue2, deque.last()),
                        () -> assertEquals(deque.size(), 2)
                );
            }

            @Test
            @DisplayName("Apppend three node")
            void appendThreeNode(){
                int expectedValue1 = 1;
                int expectedValue2 = 2;
                int expectedValue3 = 3;
                deque.append(expectedValue1);
                deque.append(expectedValue2);
                deque.append(expectedValue3);
                assertAll(
                        () -> assertEquals(expectedValue1, deque.first()),
                        () -> assertEquals(expectedValue3, deque.last()),
                        () -> assertEquals(3, deque.size())
                );
            }
        }
        @Nested
        @DisplayName("Prepend and Append test cases")
        class prependAndAppendClass{
            @Test
            @DisplayName("Prepend and append once")
            void PreAndApOnce(){
                deque.prepend(1);
                deque.append(2);
                assertAll(
                        () -> assertEquals(2, deque.size()),
                        () -> assertEquals(1, deque.first()),
                        () -> assertEquals(2, deque.last())
                );
            }
            @Test
            @DisplayName("Prepend and append thrice")
            void PreAndApThrice(){
                deque.prepend(1);
                deque.append(2);
                deque.prepend(3);
                deque.append(4);
                deque.prepend(5);
                deque.append(6);
                assertAll(
                        () -> assertEquals(6, deque.size()),
                        () -> assertEquals(5, deque.first()),
                        () -> assertEquals(6, deque.last())
                );
            }
        }
        @Nested
        @DisplayName("DeleteFirst test cases")
        class deleteFirstClass{
            @BeforeEach
            void setup(){
                deque.prepend(1);
                deque.prepend(2);
                deque.prepend(3);
            }

            @Test
            @DisplayName("Delete first once")
            void deleteFirstOnceNode(){
                deque.deleteFirst();
                assertAll(
                        () -> assertEquals(2, deque.size()),
                        () -> assertEquals(2, deque.first()),
                        () -> assertEquals(1, deque.last())
                );
            }
            @Test
            @DisplayName("Delete first twice")
            void deleteFirstTwiceNode(){
                deque.deleteFirst();
                deque.deleteFirst();
                assertAll(
                        () -> assertEquals(1, deque.size()),
                        () -> assertEquals(1, deque.first()),
                        () -> assertEquals(1, deque.last())
                );
            }
            @Test
            @DisplayName("Delete first thrice")
            void deleteFirstThriceNode(){
                deque.deleteFirst();
                deque.deleteFirst();
                deque.deleteFirst();
                assertAll(
                        () -> assertEquals(0, deque.size()),
                        () -> assertThrows(DoubleEndedQueueException.class, () -> deque.first()),
                        () -> assertThrows(DoubleEndedQueueException.class, () -> deque.last())
                );
            }
        }
        @Nested
        @DisplayName("DeleteLast test cases")
        class deleteLastClass{
            @BeforeEach
            void setup(){
                deque.prepend(1);
                deque.prepend(2);
                deque.prepend(3);
            }

            @Test
            @DisplayName("Delete last once")
            void deleteFirstOnceNode(){
                deque.deleteLast();
                assertAll(
                        () -> assertEquals(2, deque.size()),
                        () -> assertEquals(3, deque.first()),
                        () -> assertEquals(2, deque.last())
                );
            }
            @Test
            @DisplayName("Delete last twice")
            void deleteFirstTwiceNode(){
                deque.deleteLast();
                deque.deleteLast();
                assertAll(
                        () -> assertEquals(1, deque.size()),
                        () -> assertEquals(3, deque.first()),
                        () -> assertEquals(3, deque.last())
                );
            }
            @Test
            @DisplayName("Delete last thrice")
            void deleteFirstThriceNode(){
                deque.deleteLast();
                deque.deleteLast();
                deque.deleteLast();
                assertAll(
                        () -> assertEquals(0, deque.size()),
                        () -> assertThrows(DoubleEndedQueueException.class, () -> deque.first()),
                        () -> assertThrows(DoubleEndedQueueException.class, () -> deque.last())
                );
            }
        }
        @Nested
        @DisplayName("DeleteFirst and deleteLast test cases")
        class deleteFirstAndLastClass{
            @BeforeEach
            void setup(){
                deque.prepend(1);
                deque.prepend(2);
                deque.prepend(3);
                deque.append(4);
                deque.append(5);
                deque.append(6);
            }
            @Test
            @DisplayName("DeleteFirst and deleteLast once")
            void deleteFirstAndLastOnce(){
                deque.deleteFirst();
                deque.deleteLast();
                assertAll(
                        () -> assertEquals(2, deque.first()),
                        () -> assertEquals(5, deque.last()),
                        () -> assertEquals(4, deque.size())
                );
            }
            @Test
            @DisplayName("DeleteFirst and deleteLast thrice")
            void deleteFirstAndLastThrice(){
                deque.deleteFirst();
                deque.deleteLast();
                deque.deleteFirst();
                deque.deleteLast();
                deque.deleteFirst();
                deque.deleteLast();
                assertAll(
                        () -> assertThrows(DoubleEndedQueueException.class, () -> deque.first()),
                        () -> assertThrows(DoubleEndedQueueException.class, () -> deque.last()),
                        () -> assertEquals(0, deque.size())
                );
            }
        }
    }

    @Nested
    @DisplayName("DoublyLinkedListDeque Complex Operations Test")
    class complexTestCases{
        @Nested
        @DisplayName("Index tests cases")
        class indexTestClass{
            @BeforeEach
            void setup(){
                deque.prepend(3);
                deque.prepend(2);
                deque.prepend(1);
                deque.append(4);
                deque.append(5);
                deque.append(6);
            }
            @Test
            @DisplayName("the first element of the index")
            void firstIndexTest(){
                assertEquals(1, deque.get(0));
            }

            @Test
            @DisplayName("the second element of the index")
            void SecIndexTest(){
                assertEquals(2, deque.get(1));
            }

            @Test
            @DisplayName("the third element of the index")
            void thirdIndexTest(){
                assertEquals(3, deque.get(2));
            }

            @Test
            @DisplayName("the last element of the index")
            void lastIndexTest(){
                assertEquals(6, deque.get(5));
            }

            @Test
            @DisplayName("out of range of queue")
            void OutOfRangeIndexTest(){
                assertAll(
                        ()-> assertThrows(IndexOutOfBoundsException.class, ()->deque.get(6)),
                        ()-> assertThrows(IndexOutOfBoundsException.class, ()->deque.get(8)),
                        ()-> assertThrows(IndexOutOfBoundsException.class, ()->deque.get(100))

                );
            }
        }
        @Nested
        @DisplayName("Contains tests cases")
        class containsTestClass{
            @BeforeEach
            void setup(){
                deque.prepend(3);
                deque.prepend(2);
                deque.prepend(1);
                deque.append(4);
                deque.append(5);
                deque.append(6);
            }

            @Test
            @DisplayName("A simple contains test")
            void containsTest(){
                assertAll(
                        ()-> assertTrue(deque.contains(1)),
                        ()-> assertTrue(deque.contains(2)),
                        ()-> assertTrue(deque.contains(4)),
                        ()-> assertFalse(deque.contains(8))
                );
            }

        }
        @Nested
        @DisplayName("Remove test cases")
        class removeTestClass{

            @BeforeEach
            void setup(){
                deque.append(1);
                deque.append(2);
                deque.append(3);
                deque.append(4);
                deque.append(5);
                deque.append(3);
                deque.append(4);
                deque.append(5);
                deque.append(6);
                deque.append(1);
            }

            @Test
            @DisplayName("Remove once test and will remove the first ocurrence")
            void removeOnceTest(){
                int expected = 1;
                int expectedSize = deque.size()-1;
                deque.remove(expected);
                assertAll(
                        () -> assertEquals(expectedSize, deque.size()),
                        () -> assertTrue(deque.contains(1)),
                        () -> assertEquals(expected, deque.last())
                );
            }

            @Test
            @DisplayName("Remove twice test")
            void removeTwiceTest(){
                int expected = 1;
                int expectedSize = deque.size()-2;
                deque.remove(expected);
                deque.remove(expected);
                assertAll(
                        () -> assertEquals(expectedSize, deque.size()),
                        () -> assertFalse(deque.contains(expected))
                );
            }

            @Test
            @DisplayName("Remove no exist element, will do nothing")
            void removeNoExistElementTest(){
                int expected = 1;
                int expectedSize = deque.size()-2;
                deque.remove(expected);
                deque.remove(expected);
                deque.remove(expected);
                assertAll(
                        () -> assertEquals(expectedSize, deque.size()),
                        () -> assertFalse(deque.contains(expected))
                );
            }
        }
        @Nested
        @DisplayName("Sort test cases")
        class sortTestClass{

            @Test
            @DisplayName("Normal sort test")
            void sortTest(){
                deque.append(5);
                deque.append(4);
                deque.append(3);
                deque.append(2);
                deque.append(1);
                deque.sort(Integer::compareTo);

                assertAll(
                        () -> assertEquals(1, deque.first()),
                        () -> assertEquals(5, deque.last())
                );
            }

            @Test
            @DisplayName("All same element sort test, will do nothing")
            void allSameSortTest(){
                deque.append(5);
                deque.append(5);
                deque.append(5);
                deque.append(5);
                deque.append(5);
                DoublyLinkedListDeque<Integer> expected = deque;
                deque.sort(Integer::compareTo);

                assertAll(
                        () -> assertSame(expected, deque),
                        () -> assertEquals(5, deque.first()),
                        () -> assertEquals(5, deque.last()),
                        () -> assertEquals(5, deque.size())
                );
            }
        }
    }

}