package com.github.Robert_IX.codingassignment_lucksmith.controller;

import static org.mockito.Mockito.*;
import com.github.Robert_IX.codingassignment_lucksmith.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieSession;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderControllerTest
{

    @Mock
    private KieSession kieSession;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testOrderNow()
    {
        // Arrange
        Order order = new Order();
        order.setName("Test");
        order.setCardType("A");
        order.setDiscount(2500);
        order.setPrice(5000);

        // Act
        Order result = orderController.orderNow(order);

        // Assert
        verify(kieSession, times(1)).insert(order);
        verify(kieSession, times(1)).fireAllRules();
    }
}