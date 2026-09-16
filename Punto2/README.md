# Punto 2 - International Shipping Cost Calculation (Strategy Pattern)

## Problem
GlobalMarket needs to let a purchase order dynamically switch between
several shipping cost calculation algorithms (economy/maritime,
express/air, eco/carbon-neutral, locker/pickup point flat rate) at
checkout time, and be able to easily add new methods in the future.

## Design Pattern
**Strategy**. `ShippingStrategy` is the strategy interface, implemented by
four concrete strategies (`EconomyShipping`, `ExpressShipping`,
`EcoShipping`, `LockerShipping`). The `Order` class is the **Context**: it
holds a reference to the currently selected strategy and delegates the
cost/time calculation to it, allowing the strategy to be swapped at
runtime via `setShippingStrategy()` before the purchase is confirmed.

## Project structure
```
Punto2/
└── src/
    └── com/globalmarket/shipping/
        ├── ShipmentDetails.java   (value object: weight, distance, destination)
        ├── ShippingStrategy.java (Strategy interface)
        ├── EconomyShipping.java  (concrete Strategy - maritime)
        ├── ExpressShipping.java  (concrete Strategy - air)
        ├── EcoShipping.java      (concrete Strategy - carbon neutral)
        ├── LockerShipping.java   (concrete Strategy - flat rate by distance tier)
        ├── Order.java            (Context)
        └── Main.java             (demo / entry point)
```

## How to compile and run
From inside the `Punto2` folder:

```bash
# Compile
javac -d out src/com/globalmarket/shipping/*.java

# Run
java -cp out com.globalmarket.shipping.Main
```

## What the demo shows
1. An order is created with the Economy strategy by default.
2. The customer compares quotes by dynamically switching between Economy,
   Express, Eco and Locker strategies, on the same `Order` instance.
3. The customer confirms the purchase with the Express strategy, which
   locks the strategy in place.
4. A further attempt to change the strategy after confirmation is
   rejected by the `Order`.
5. A second, independent order demonstrates that new strategies (like
   Locker) can be used right away without any change to the `Order`
   class, illustrating the Open/Closed Principle.
