package tdd;

/**
 * A simple circular FIFO queue of primitive integers with a fixed {@link #capacity()}.
 * <p>
 * When the queue is full, adding a new element overwrites (drops) the oldest element.
 * Removing elements always follows FIFO order (oldest first).
 */
public interface CircularQueue {

    /**
     * Returns the maximum number of elements this queue can hold.
     *
     * @return the fixed capacity of this queue (must be &gt; 0).
     */
    int capacity();

    /**
     * Returns the number of elements currently stored in the queue.
     *
     * @return the current size, in the range {@code [0, capacity()]}.
     */
    int size();

    /**
     * Returns {@code true} if this queue contains no elements.
     *
     * @return {@code true} if empty, {@code false} otherwise.
     */
    boolean isEmpty();

    /**
     * Returns {@code true} if this queue is currently at full capacity.
     * <p>
     * Note: calling {@link #offer(int)} when full is allowed and will overwrite the oldest element,
     * so this method is primarily informative.
     *
     * @return {@code true} if {@code size() == capacity()}, {@code false} otherwise.
     */
    boolean isFull();

    /**
     * Inserts {@code value} into this queue.
     * <p>
     * If the queue is full, this operation overwrites the oldest element, keeping the size unchanged.
     *
     * @param value the value to insert.
     */
    void offer(int value);

    /**
     * Retrieves and removes the oldest element (head) of this queue.
     *
     * @return the removed element, or {@code null} if the queue is empty (safe removal) [web:12].
     */
    Integer poll();

    /**
     * Retrieves, but does not remove, the oldest element (head) of this queue.
     *
     * @return the head element, or {@code null} if the queue is empty (safe peek) [web:12].
     */
    Integer peek();

    /**
     * Removes all elements from this queue, making it empty.
     */
    void clear();
}
