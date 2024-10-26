package com.sweetmanor.exams.linear;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinStackTest {

    @Test
    void test() {
        MinStack stack = new MinStack();
        stack.push(0);
        stack.push(-1);
        stack.push(1);
        assertEquals(-1, stack.getMinValue());

        stack.push(-2);
        stack.push(3);
        stack.push(-5);
        stack.push(-5);
        assertEquals(-5, stack.getMinValue());

        assertEquals(-5, stack.pop());
        assertEquals(-5, stack.getMinValue());

        assertEquals(-5, stack.pop());
        assertEquals(-2, stack.getMinValue());
    }

}
