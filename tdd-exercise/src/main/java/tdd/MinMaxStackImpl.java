package tdd;

import java.util.Stack;

public class MinMaxStackImpl implements MinMaxStack {

    private Stack<Integer> stack = new Stack<>();

    @Override
    public void push(int value) {
        stack.push(value);
    }

    @Override
    public int pop() {
        return this.stack.pop();
    }

    @Override
    public int peek() {
        return this.stack.peek();
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
