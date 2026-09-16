package com.globalmarket.shipping;

/**
 * Concrete Strategy: Locker / pickup point shipping.
 *
 * Applies a flat rate that is calculated according to the distance
 * between the customer's chosen locker and the nearest distribution
 * center. The rate is tiered rather than fully linear, which reflects
 * how real flat-rate locker networks usually price their service.
 */
public class LockerShipping implements ShippingStrategy {

    @Override
    public double calculateCost(ShipmentDetails details) {
        double distance = details.getDistanceKm();

        if (distance <= 10) {
            return 3.0;   // Nearby locker: cheapest flat rate.
        } else if (distance <= 50) {
            return 6.0;   // Medium distance locker.
        } else {
            return 10.0;  // Far locker, still a flat rate (independent of weight).
        }
    }

    @Override
    public String getEstimatedDeliveryTime(ShipmentDetails details) {
        return "2 to 4 business days (pickup at locker point)";
    }

    @Override
    public String getStrategyName() {
        return "Locker / Pickup Point Shipping";
    }
}
