package com.globalmarket.shipping;

/**
 * Concrete Strategy: Eco / carbon-neutral shipping.
 *
 * Selects ground and electric transport routes in order to minimize CO2
 * emissions. Cost and delivery time sit between the economy and express
 * options.
 */
public class EcoShipping implements ShippingStrategy {

    private static final double BASE_FEE = 8.0;
    private static final double COST_PER_KG = 3.0;
    private static final double COST_PER_KM = 0.02;

    @Override
    public double calculateCost(ShipmentDetails details) {
        return BASE_FEE
                + (details.getWeightKg() * COST_PER_KG)
                + (details.getDistanceKm() * COST_PER_KM);
    }

    @Override
    public String getEstimatedDeliveryTime(ShipmentDetails details) {
        return "5 to 10 business days (electric/ground route)";
    }

    @Override
    public String getStrategyName() {
        return "Eco Shipping (Carbon Neutral)";
    }
}
