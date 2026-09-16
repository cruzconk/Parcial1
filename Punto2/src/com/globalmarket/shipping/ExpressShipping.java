package com.globalmarket.shipping;

/**
 * Concrete Strategy: Express shipping (air transport).
 *
 * Minimizes delivery time as much as possible using partner airlines,
 * at a higher cost than the other methods.
 */
public class ExpressShipping implements ShippingStrategy {

    private static final double BASE_FEE = 20.0;
    private static final double COST_PER_KG = 8.0;
    private static final double COST_PER_KM = 0.05;

    @Override
    public double calculateCost(ShipmentDetails details) {
        return BASE_FEE
                + (details.getWeightKg() * COST_PER_KG)
                + (details.getDistanceKm() * COST_PER_KM);
    }

    @Override
    public String getEstimatedDeliveryTime(ShipmentDetails details) {
        return "1 to 3 business days (air freight)";
    }

    @Override
    public String getStrategyName() {
        return "Express Shipping (Air)";
    }
}
