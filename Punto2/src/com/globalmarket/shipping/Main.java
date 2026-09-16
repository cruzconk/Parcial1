package com.globalmarket.shipping;

/**
 * Demo / entry point.
 *
 * Simulates a GlobalMarket customer building a purchase order and
 * comparing the available shipping methods in the checkout window before
 * finally confirming the purchase with the one that best fits their
 * needs. It also shows how a brand new shipping method (Locker) can be
 * plugged in without touching the {@link Order} class at all.
 */
public class Main {

    public static void main(String[] args) {

        // Package details: 4.5 kg, 320 km to destination, shipping to Medellin.
        ShipmentDetails shipment = new ShipmentDetails(4.5, 320, "Medellin, Colombia");

        // The customer starts checkout with the Economy strategy by default.
        Order order = new Order("ORD-2026-001", shipment, new EconomyShipping());

        System.out.println("===== CHECKOUT: COMPARING SHIPPING METHODS =====");
        order.printShippingQuote();

        // The customer explores other options dynamically, without creating a new Order.
        order.setShippingStrategy(new ExpressShipping());
        order.printShippingQuote();

        order.setShippingStrategy(new EcoShipping());
        order.printShippingQuote();

        order.setShippingStrategy(new LockerShipping());
        order.printShippingQuote();

        // The customer decides Express best fits their needs and switches back to it.
        System.out.println("\n===== CUSTOMER FINAL DECISION =====");
        order.setShippingStrategy(new ExpressShipping());
        order.printShippingQuote();

        // The purchase is confirmed; the strategy is now locked in.
        order.confirmPurchase();

        // Any further attempt to change the strategy after confirmation is rejected.
        System.out.println("\n===== ATTEMPT TO CHANGE AFTER CONFIRMATION =====");
        order.setShippingStrategy(new EconomyShipping());

        // Demonstrating a second, independent order using a different starting strategy.
        System.out.println("\n===== A SECOND, INDEPENDENT ORDER =====");
        ShipmentDetails smallLocalPackage = new ShipmentDetails(1.0, 8, "Local pickup point");
        Order secondOrder = new Order("ORD-2026-002", smallLocalPackage, new LockerShipping());
        secondOrder.printShippingQuote();
        secondOrder.confirmPurchase();
    }
}
