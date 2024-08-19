package com.github.Robert_IX.codingassignment_lucksmith.controller;

import com.github.Robert_IX.codingassignment_lucksmith.model.Order;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for handling requests related to Orders.
 * This controller processes incoming Order requests by applying business rules
 * using Drools, and then returns the modified Order.
 *
 * The controller listens for POST requests on the '/api/rules/execute' endpoint.
 *
 * @author Robert Gheorghe
 */
@RestController
public class OrderController
{
    // Autowired KieSession used to interact with Drools rule engine
    @Autowired
    private KieSession session;

    /**
     * Endpoint to execute business rules on an incoming Order.
     * This method inserts the order into the Drools session, fires all rules,
     * and returns the processed order.
     *
     * @param order the Order object to be processed
     * @return the Order after applying the business rules
     */

    @PostMapping("/api/rules/execute")
    public Order orderNow(@RequestBody Order order) {
        // Insert the order into the Drools session
        session.insert(order);
        // Fire all rules associated with the session
        session.fireAllRules();
        // Return the modified order object
        return order;
    }
}