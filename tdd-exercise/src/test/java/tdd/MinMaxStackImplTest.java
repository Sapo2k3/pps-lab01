package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    @Test
    public void pushAnElement() {
        MinMaxStack minMaxStack = new MinMaxStackImpl();
        minMaxStack.push(1);
        assertEquals(1, minMaxStack.peek());
    }

    @Test
    public void popAnElement() {
        MinMaxStack minMaxStack = new MinMaxStackImpl();
        minMaxStack.push(1);
        assertEquals(1, minMaxStack.pop());
    }
}
