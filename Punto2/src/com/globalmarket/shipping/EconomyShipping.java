package com.globalmarket.shipping;

/**
 * Concrete Strategy: Economy shipping (maritime transport).
 *
 * Prioritizes the lowest possible cost, regardless of how long the
 * delivery takes (it may take several weeks).
 */
public class EconomyShipping implements ShippingStrategy {

    private static final double BASE_FEE = 5.0;
    private static final double COST_PER_KG = 1.5;

    @Override
    public double calculateCost(ShipmentDetails details) {
        return BASE_FEE + (details.getWeightKg() * COST_PER_KG);
    }

    @Override
    public String getEstimatedDeliveryTime(ShipmentDetails details) {
        return "3 to 6 weeks (maritime route)";
    }

    @Override
    public String getStrategyName() {
        return "Economy Shipping (Maritime)";
    }
}
