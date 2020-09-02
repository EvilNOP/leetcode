package com.github.leetcode.minstack155;

import java.util.Stack;

public class MinStack {

    private final Stack<Integer> data;
    private final Stack<Integer> helper;

    public MinStack() {
        this.data = new Stack<>();
        this.helper = new Stack<>();
    }

    public void push(int x) {
        data.push(x);

        if (helper.isEmpty() || helper.peek() >= x) {
            helper.push(x);
        } else {
            helper.push(helper.peek());
        }
    }

    public void pop() {
        data.pop();
        helper.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return helper.peek();
    }
}
