package com.sarg.dsa.datastructures.stack;

import com.sarg.dsa.datastructures.implementation.stack.ArrayStack;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestArrayStack {

    private ArrayStack<Integer> stack = new ArrayStack<>();

    @Test
    @Order(1)
    public void testEmptyStack(){
        assertEquals(stack.isEmpty(), true);
        assertEquals(stack.size(), 0);
    }

    @Test
    @Order(2)
    public void testPush(){
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        assertEquals(stack.size(), 6);
    }

    @Test
    @Order(3)
    public void testPop(){

        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.pop();
        assertEquals(stack.size(), 2);
        stack.pop();
        assertEquals(stack.size(), 1);
    }

    @Test
    @Order(4)
    public void testPeek(){
        stack.push(2);
        stack.push(3);
        stack.push(5);
        assertEquals(stack.peek(), 5);
    }
}
