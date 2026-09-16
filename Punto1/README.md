# Punto 1 - Real-Time Critical Patient Monitoring (Observer Pattern)

## Problem
HealthCare Pro needs a system in which several hospital professionals
(intensive care doctor, nursing chief, chief bacteriologist) can subscribe
and unsubscribe dynamically to a central monitoring unit and automatically
receive the notifications relevant to their role, replacing the current
phone-call based coordination.

## Design Pattern
**Observer**. The `PatientMonitoringCentral` class is the **Subject**
(Observable); it maintains the list of subscribers and broadcasts every
`MonitoringEvent` to all of them. Each professional is a **concrete
Observer** (`Doctor`, `NursingChief`, `Bacteriologist`) that implements the
`MedicalObserver` interface and decides internally whether a given event
is relevant to its role.

## Project structure
```
Punto1/
└── src/
    └── com/healthcarepro/monitoring/
        ├── EventType.java              (enum with the kinds of events)
        ├── MonitoringEvent.java        (event payload / DTO)
        ├── MedicalObserver.java        (Observer interface)
        ├── Subject.java                (Subject interface)
        ├── PatientMonitoringCentral.java (concrete Subject)
        ├── Doctor.java                 (concrete Observer - Elena Ramos)
        ├── NursingChief.java           (concrete Observer - Andres Suarez)
        ├── Bacteriologist.java         (concrete Observer - Marta Gomez)
        └── Main.java                   (demo / entry point)
```

## How to compile and run
From inside the `Punto1` folder:

```bash
# Compile
javac -d out src/com/healthcarepro/monitoring/*.java

# Run
java -cp out com.healthcarepro.monitoring.Main
```

## What the demo shows
1. The three professionals subscribe to the monitoring central.
2. Three events are emitted (a critical vital sign, a priority change, and
   an urgent lab request); each professional only reacts to the event
   type relevant to their role.
3. The nursing chief unsubscribes dynamically.
4. New events are emitted again, proving that the unsubscribed observer no
   longer receives notifications while the rest of the system keeps
   working correctly.
