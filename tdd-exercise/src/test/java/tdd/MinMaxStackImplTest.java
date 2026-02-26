package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 100;
    private final int VALUE = 7;

    private MinMaxStackImpl minMaxStack;

    @BeforeEach
    void setUp() {
        minMaxStack = new MinMaxStackImpl();
        minMaxStack.push(VALUE);
    }

    @Test
    public void pushAnElement() {
        final int size = minMaxStack.size();
        assertEquals(VALUE, minMaxStack.peek());
        assertEquals(size, minMaxStack.size());
    }

    @Test
    public void popAnElement() {
        assertEquals(VALUE, minMaxStack.pop());
    }

    @Test
    public void getMinimumElement(){
        minMaxStack.push(MIN_VALUE);
        minMaxStack.push(MAX_VALUE);
        assertEquals(MIN_VALUE, minMaxStack.getMin());
    }

    @Test
    public void getMaximumElement(){
        minMaxStack.push(MAX_VALUE);
        minMaxStack.push(MIN_VALUE);
        assertEquals(MAX_VALUE, minMaxStack.getMax());
    }
}
