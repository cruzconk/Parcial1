package com.globalmarket.shipping;

/**
 * Simple value object that groups the data needed by any shipping
 * calculation strategy: the package weight, the distance to the
 * destination, and the destination name (used only for display purposes).
 *
 * Keeping this data separate from the {@link Order} class allows any
 * strategy to receive exactly the information it needs without depending
 * on the whole order.
 */
public class ShipmentDetails {

    private final double weightKg;
    private final double distanceKm;
    private final String destination;

    public ShipmentDetails(double weightKg, double distanceKm, String destination) {
        this.weightKg = weightKg;
        this.distanceKm = distanceKm;
        this.destination = destination;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public String getDestination() {
        return destination;
    }
}
