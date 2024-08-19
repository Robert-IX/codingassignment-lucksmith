package com.github.Robert_IX.codingassignment_lucksmith.model;

/**
 * Represents an Order in the system.
 * This model contains basic information about an order, such as the customer's name,
 * the type of card used for payment, the discount applied, and the price of the order.
 *
 * @author Robert Gheorghe
 */
public class Order
{

    // Name of the customer who placed the order
    private String name;

    // Type of card used for the order (e.g., Credit, Debit)
    private String cardType;

    // Discount applied to the order
    private int discount;

    // Total price of the order before discount
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}