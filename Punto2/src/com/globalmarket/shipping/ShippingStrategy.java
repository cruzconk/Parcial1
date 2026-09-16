package com.globalmarket.shipping;

/**
 * Strategy interface of the Strategy design pattern.
 *
 * Declares the contract that every shipping calculation policy must
 * implement. GlobalMarket can add new shipping methods at any time simply
 * by creating a new class that implements this interface, without having
 * to modify the {@link Order} (the context) or any existing strategy
 * (Open/Closed Principle).
 */
public interface ShippingStrategy {

    /**
     * Calculates the shipping cost for the given shipment details,
     * according to this particular strategy's pricing policy.
     *
     * @param details the package weight, distance and destination
     * @return the calculated shipping cost
     */
    double calculateCost(ShipmentDetails details);

    /**
     * @param details the package weight, distance and destination
     * @return a human-readable estimated delivery time (e.g. "3-5 business days")
     */
    String getEstimatedDeliveryTime(ShipmentDetails details);

    /**
     * @return the commercial name of this shipping method, used for display purposes.
     */
    String getStrategyName();
}
