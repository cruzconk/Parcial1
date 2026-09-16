package com.globalmarket.shipping;

/**
 * Context class of the Strategy design pattern.
 *
 * Represents a customer's purchase order. It holds a reference to the
 * currently selected {@link ShippingStrategy} and delegates the shipping
 * cost/time calculation to it. The customer can change the shipping
 * strategy dynamically (e.g. in the checkout window) at any point before
 * confirming the purchase, simply by calling {@link #setShippingStrategy}.
 */
public class Order {

    private final String orderId;
    private final ShipmentDetails shipmentDetails;
    private ShippingStrategy shippingStrategy;
    private boolean confirmed = false;

    public Order(String orderId, ShipmentDetails shipmentDetails, ShippingStrategy initialStrategy) {
        this.orderId = orderId;
        this.shipmentDetails = shipmentDetails;
        this.shippingStrategy = initialStrategy;
    }

    /**
     * Allows the customer to dynamically switch the shipping calculation
     * strategy at checkout time, before the order is confirmed.
     *
     * @param newStrategy the new shipping strategy chosen by the customer
     */
    public void setShippingStrategy(ShippingStrategy newStrategy) {
        if (confirmed) {
            System.out.println("[ORDER " + orderId + "] Cannot change shipping method: order already confirmed.");
            return;
        }
        this.shippingStrategy = newStrategy;
        System.out.println("[ORDER " + orderId + "] Shipping method changed to: " + newStrategy.getStrategyName());
    }

    /**
     * Delegates the cost calculation to whichever strategy is currently set.
     * This is the core of the Strategy pattern: the Order does not know
     * (and does not need to know) HOW the cost is calculated.
     *
     * @return the shipping cost according to the current strategy
     */
    public double calculateShippingCost() {
        return shippingStrategy.calculateCost(shipmentDetails);
    }

    /**
     * @return the estimated delivery time according to the current strategy.
     */
    public String getEstimatedDeliveryTime() {
        return shippingStrategy.getEstimatedDeliveryTime(shipmentDetails);
    }

    /**
     * Prints a summary of the current shipping quote for this order.
     */
    public void printShippingQuote() {
        System.out.printf(
                "[ORDER %s] Method: %-32s | Cost: $%,.2f | Estimated time: %s%n",
                orderId,
                shippingStrategy.getStrategyName(),
                calculateShippingCost(),
                getEstimatedDeliveryTime());
    }

    /**
     * Confirms the purchase, locking in the currently selected shipping
     * strategy. After this point, the shipping method can no longer be
     * changed.
     */
    public void confirmPurchase() {
        this.confirmed = true;
        System.out.println("\n[ORDER " + orderId + "] Purchase CONFIRMED with shipping method: "
                + shippingStrategy.getStrategyName()
                + " | Final cost: $" + String.format("%,.2f", calculateShippingCost()));
    }

    public String getOrderId() {
        return orderId;
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}
