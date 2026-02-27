package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircularListTest {

    private final int MAX_SIZE = 10;

    private final int VALUE = 1;
    private final int NEW_VALUE = 2;

    private final int SMALL_CAPACITY = 3;

    private final int FIRST = 0;
    private final int SECOND = 1;
    private final int THIRD = 2;

    private final int OVERWRITE_VALUE = 99;

    private final int INVALID_ZERO_CAPACITY = 0;
    private final int INVALID_NEGATIVE_CAPACITY = -1;

    @Test
    public void testOfferInQueue() {
        CircularQueue circularQueue = new CircularQueueImpl(MAX_SIZE);
        circularQueue.offer(VALUE);
        assertEquals(VALUE, circularQueue.peek());
    }

    @Test
    void testPollreturnsOldestandDecrementsSize() {
        CircularQueue q = new CircularQueueImpl(MAX_SIZE);
        for (int i = 0; i < MAX_SIZE; i++) q.offer(i);
        assertEquals(MAX_SIZE, q.size());
        assertEquals(FIRST, q.poll());
        assertEquals(MAX_SIZE - 1, q.size());
        assertEquals(SECOND, q.peek());
    }

    @Test
    void testPeekDoesNotRemoveElement() {
        CircularQueue q = new CircularQueueImpl(MAX_SIZE);

        q.offer(VALUE);

        assertEquals(VALUE, q.peek());
        assertEquals(VALUE, q.peek());
        assertEquals(1, q.size());
    }

    @Test
    void testPeekOnEmptyReturnsNull() {
        CircularQueue q = new CircularQueueImpl(MAX_SIZE);

        assertNull(q.peek());
        assertEquals(0, q.size());
        assertTrue(q.isEmpty());
    }

    @Test
    void testPollOnEmptyReturnsNull() {
        CircularQueue q = new CircularQueueImpl(MAX_SIZE);

        assertNull(q.poll());
        assertEquals(0, q.size());
        assertTrue(q.isEmpty());
    }

    @Test
    void testIsEmptyAndIsFullTransitions() {
        CircularQueue q = new CircularQueueImpl(SMALL_CAPACITY);

        assertTrue(q.isEmpty());
        assertFalse(q.isFull());

        q.offer(FIRST);
        q.offer(SECOND);
        q.offer(THIRD);

        assertFalse(q.isEmpty());
        assertTrue(q.isFull());
        assertEquals(SMALL_CAPACITY, q.size());
    }

    @Test
    void testOverwriteWhenFullDropsOldestAndKeepsSize() {
        CircularQueue q = new CircularQueueImpl(SMALL_CAPACITY);

        q.offer(FIRST);
        q.offer(SECOND);
        q.offer(THIRD);
        q.offer(OVERWRITE_VALUE);

        assertEquals(SMALL_CAPACITY, q.size());
        assertEquals(SECOND, q.peek());
        assertEquals(SECOND, q.poll());
        assertEquals(THIRD, q.poll());
        assertEquals(OVERWRITE_VALUE, q.poll());
        assertNull(q.poll());
    }

    @Test
    void testWrapAroundAfterPollThenOfferPreservesOrder() {
        CircularQueue q = new CircularQueueImpl(SMALL_CAPACITY);

        q.offer(FIRST);
        q.offer(SECOND);
        q.offer(THIRD);

        assertEquals(FIRST, q.poll());

        q.offer(OVERWRITE_VALUE);

        assertEquals(SECOND, q.poll());
        assertEquals(THIRD, q.poll());
        assertEquals(OVERWRITE_VALUE, q.poll());
        assertTrue(q.isEmpty());
    }

    @Test
    void testClearEmptiesQueue() {
        CircularQueue q = new CircularQueueImpl(MAX_SIZE);

        q.offer(VALUE);
        q.offer(NEW_VALUE);

        q.clear();

        assertTrue(q.isEmpty());
        assertEquals(0, q.size());
        assertNull(q.peek());
        assertNull(q.poll());
    }

    @Test
    void testCapacityIsFixed() {
        CircularQueue q = new CircularQueueImpl(MAX_SIZE);

        assertEquals(MAX_SIZE, q.capacity());

        q.offer(VALUE);
        q.offer(NEW_VALUE);

        assertEquals(MAX_SIZE, q.capacity());
    }

    @Test
    void testConstructorWithInvalidCapacityThrows() {
        assertThrows(IllegalArgumentException.class, () -> new CircularQueueImpl(INVALID_ZERO_CAPACITY));
        assertThrows(IllegalArgumentException.class, () -> new CircularQueueImpl(INVALID_NEGATIVE_CAPACITY));
    }
}
