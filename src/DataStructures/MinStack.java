package DataStructures;

import java.util.Stack;

public class MinStack {
    /** initialize your data structure here. */
    class Data{
        public int value;
        public int min;
        public Data(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
    Stack<Data> stack;
    public MinStack() {
        stack = new Stack<>();
        stack.push(new Data(0,Integer.MAX_VALUE));
    }

    public void push(int x) {
        stack.push(new Data(x,Math.min(x,stack.peek().min)));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }
}
