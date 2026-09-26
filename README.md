# Warframe Melee Weapon Data Viewer

[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://github.com/Link1400/WarframeJFX)

An interactive JavaFX application for exploring and visualizing Warframe melee weapon statistics.

## What the Software Does

The application loads melee weapon data from a CSV file and presents it in a graphical interface. Users can:

- Browse weapon names, attack names, damage values, critical statistics, status chance, attack speed, mastery rank, release date, and weapon class.
- Search the data by weapon name or weapon class.
- Sort the table by statistics such as impact, puncture, slash, base damage, total damage, critical chance, critical multiplier, status chance, and attack speed.
- View the distribution of weapon classes in a pie chart.
- Compare base damage and attack speed in a line chart.
- Import another CSV file with the same column structure through the file picker.
- Reset the table to the original imported data.

The default dataset is stored in `src/CPT/CSV File/melee.csv` and is also available at the repository root as `melee.csv`.

## Why This Dataset

Melee weapons have many statistics that are useful for comparison. This dataset lets the application demonstrate several kinds of data visualization and gives users practical ways to filter, sort, and compare weapons.

## Object-Oriented Design

The project separates responsibilities across several classes:

- `MeleeWeapon` represents one weapon and its statistics.
- `Fileimport` reads CSV files and handles file selection.
- `weaponSearch` filters weapons by the selected search field.
- `weaponSort` sorts weapons and prepares chart data.
- `JFXTable` configures the table columns.
- `Display` builds the JavaFX interface and connects the components.

The project also includes an automatically generated UML class diagram in [ClassDiagram.svg](ClassDiagram.svg), with its source in [ClassDiagram.mmd](ClassDiagram.mmd).

## Credits

Created by **Ryan Fellin** and **Rami Kabak**.

## Running the Application

The project uses Maven to download the correct JavaFX libraries for the current operating system. Install a full JDK and Maven, then run from the repository root:

```bash
mvn clean javafx:run
```

The application entry point is `CPT.Display`. The JavaFX jars in `lib/` are not required when running through Maven.
