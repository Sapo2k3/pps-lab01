package tdd;

import java.util.NoSuchElementException;

/**
 * Circular FIFO queue of ints with fixed capacity.
 * <p>
 * Backed by an int array and two indices:
 * head = index of the oldest element (next to be removed),
 * tail = index where the next element will be inserted.
 * <p>
 * A separate {@code size} counter removes the ambiguity of {@code head == tail}
 * (which can mean both empty and full in a ring buffer) [web:39].
 */
public final class CircularQueueImpl implements CircularQueue {

    private final int[] buffer;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    /**
     * Creates a new queue with the given fixed capacity.
     *
     * @param capacity maximum number of elements the queue can hold; must be > 0.
     * @throws IllegalArgumentException if capacity <= 0.
     */
    public CircularQueueImpl(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be > 0");
        this.buffer = new int[capacity];
    }

    @Override
    public int capacity() {
        return this.buffer.length;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean isFull() {
        return this.size == this.buffer.length;
    }

    @Override
    public void offer(int value) {
        this.buffer[this.tail] = value;
        this.tail = (this.tail + 1) % this.buffer.length;

        if (this.size < this.buffer.length) {
            this.size = this.size + 1;
        } else {
            this.head = (this.head + 1) % this.buffer.length;
        }
    }

    @Override
    public Integer peek() {
        return (this.size == 0) ? null : this.buffer[this.head];
    }

    @Override
    public Integer poll() {
        if (this.size == 0) return null;
        int value = this.buffer[this.head];
        this.head = (this.head + 1) % this.buffer.length;
        this.size =  this.size - 1;
        return value;
    }

    @Override
    public void clear() {
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }
}
