package tdd;

import java.util.Stack;

public class MinMaxStackImpl implements MinMaxStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> maxStack = new Stack<>();

    @Override
    public void push(int value) {
        if(stack.isEmpty()){
            stack.push(value);
            minStack.push(value);
            maxStack.push(value);
        } else {
            stack.push(value);
            minStack.push(Math.min(value, minStack.peek()));
            maxStack.push(Math.max(value, maxStack.peek()));
        }
    }

    @Override
    public int pop() {
        minStack.pop();
        maxStack.pop();
        return this.stack.pop();
    }

    @Override
    public int peek() {
        return this.stack.peek();
    }

    @Override
    public int getMin() {
        return minStack.peek();
    }

    @Override
    public int getMax() {
        return maxStack.peek();
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
