package com.github.Robert_IX.codingassignment_lucksmith.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class OrderTest
{
    @Test
    public void testOrderProperties()
    {
        Order order = new Order();
        order.setName("Test Name");
        order.setCardType("A");
        order.setDiscount(2500);
        order.setPrice(6000);

        assertEquals("Test Name", order.getName());
        assertEquals("A", order.getCardType());
        assertEquals(2500, order.getDiscount());
        assertEquals(6000, order.getPrice());
    }
}
