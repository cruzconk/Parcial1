# Parcial 1 - Java Design Patterns

This repository contains the solutions for both exercises of Parcial 1,
each implemented as an independent Java project:

- **`Punto1/`** — Real-time critical patient monitoring system for
  HealthCare Pro, implemented with the **Observer** design pattern.
- **`Punto2/`** — International shipping cost calculator for
  GlobalMarket, implemented with the **Strategy** design pattern.

Each folder contains its own `README.md` with a detailed explanation of
the problem, the design, the project structure, and compile/run
instructions.

## Requirements
- JDK 8 or higher (no external dependencies / no Maven or Gradle needed).

## Quick start

```bash
# Punto 1
cd Punto1
javac -d out src/com/healthcarepro/monitoring/*.java
java -cp out com.healthcarepro.monitoring.Main

# Punto 2
cd ../Punto2
javac -d out src/com/globalmarket/shipping/*.java
java -cp out com.globalmarket.shipping.Main
```

---

## How to publish this repository on GitHub and create the release

1. Create a **new empty repository** on your personal GitHub account
   (do not initialize it with a README, .gitignore or license).
2. From this folder, run:
   ```bash
   git init
   git add .
   git commit -m "Parcial 1: Observer (Punto1) and Strategy (Punto2) patterns"
   git branch -M main
   git remote add origin https://github.com/<your-username>/<your-repo>.git
   git push -u origin main
   ```
3. Go to your repository on GitHub → **Releases** → **Draft a new
   release**.
4. In **Choose a tag**, type `v1.0.0` and select "Create new tag on
   publish".
5. In **Release title**, type `parcial1`.
6. Click **Publish release**.
7. Copy the repository URL and submit it on the Moodle activity
   (Parcial 1).

> ⚠️ Important: once submitted, do **not** modify the repository again
> (not even a small fix), since any change after submission voids the
> exam according to the instructions.
