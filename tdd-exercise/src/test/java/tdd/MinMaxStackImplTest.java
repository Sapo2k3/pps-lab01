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
    public void testPushAnElement() {
        final int size = minMaxStack.size();
        assertEquals(VALUE, minMaxStack.peek());
        assertEquals(size, minMaxStack.size());
    }

    @Test
    public void testPopAnElement() {
        assertEquals(VALUE, minMaxStack.pop());
    }

    @Test
    public void testPopAnEmptyStack(){
        MinMaxStack minMaxStack = new MinMaxStackImpl();
        assertThrows(IllegalStateException.class, () -> minMaxStack.pop());
    }

    @Test
    public void testPeekAnEmptyStack() {
        MinMaxStack minMaxStack = new MinMaxStackImpl();
        assertThrows(IllegalStateException.class, () -> minMaxStack.peek());
    }

    @Test
    public void testGetMinimumElement(){
        minMaxStack.push(MIN_VALUE);
        minMaxStack.push(MAX_VALUE);
        assertEquals(MIN_VALUE, minMaxStack.getMin());
    }

    @Test
    public void testGetMinimumElementFromAnEmptyStack(){
        MinMaxStack minMaxStack = new MinMaxStackImpl();
        assertThrows(IllegalStateException.class, () -> minMaxStack.getMin());
    }

    @Test
    void testDuplicateMinsSurvivePop() {
        minMaxStack.push(MIN_VALUE);
        minMaxStack.push(MIN_VALUE);
        assertEquals(MIN_VALUE, minMaxStack.getMin());
        minMaxStack.pop();
        assertEquals(MIN_VALUE, minMaxStack.getMin());
    }

    @Test
    void testDuplicateMaxsSurvivePop() {
        minMaxStack.push(MAX_VALUE);
        minMaxStack.push(MAX_VALUE);
        assertEquals(MAX_VALUE, minMaxStack.getMax());
        minMaxStack.pop();
        assertEquals(MAX_VALUE, minMaxStack.getMax());
    }

    @Test
    public void testGetMaximumElement(){
        minMaxStack.push(MAX_VALUE);
        minMaxStack.push(MIN_VALUE);
        assertEquals(MAX_VALUE, minMaxStack.getMax());
    }

    @Test
    public void testGetMaximumElementFromAnEmptyStack(){
        MinMaxStack minMaxStack = new MinMaxStackImpl();
        assertThrows(IllegalStateException.class, () -> minMaxStack.getMax());
    }

    @Test
    public void testIsEmpty(){
        MinMaxStack minMaxStack = new MinMaxStackImpl();
        assertTrue(minMaxStack.isEmpty());
    }

    @Test
    public void testIsEmptyAfterPop() {
        minMaxStack.pop();
        assertTrue(minMaxStack.isEmpty());
    }
}
