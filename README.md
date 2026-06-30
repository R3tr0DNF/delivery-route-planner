
# delivery-route-planner

delivey-route-planner is a Java application designed to optimize local delivery routes using graph algorithms and decision trees. The system computes the shortest path between locations with Dijkstra's algorithm and provides route recommendations based on weather conditions, traffic congestion, and delivery priority.

## Features

- Graph-based route representation
- Shortest path calculation using Dijkstra's algorithm
- Decision tree for route recommendations
- Route loading from external files
- Console-based user interaction
- Route report generation

## Technologies

- Java
- Java Collections Framework
- Graph Data Structures
- Dijkstra's Algorithm
- Decision Trees

## Project Structure

```text
src/
├── Main.java
│   Application entry point.
│
├── Grafo.java
│   Graph representation and route management.
│
├── AlgoritmosRuta.java
│   Route optimization algorithms, including Dijkstra.
│
├── ArbolDecision.java
│   Decision tree used to recommend routes based on delivery conditions.
│
└── NodoDistancia.java
    Helper class for priority queue operations.
```

## How It Works

1. The application loads a graph representing local delivery routes from a text file.
2. The user selects an origin and destination.
3. Dijkstra's algorithm computes the shortest available path.
4. A decision tree analyzes additional factors such as:
   - Weather conditions
   - Traffic congestion
   - Delivery priority
5. The system recommends the most suitable route and generates a report.

## Requirements

- Java JDK 8 or later

## Installation

1. Clone the repository.

```bash
git clone https://github.com/R3tr0DNF/routewise.git
```

2. Open the project in your preferred Java IDE.

3. Ensure the route dataset is located in the `resources` directory.

4. Build and run the application.

## Learning Objectives

This project was developed to apply concepts related to:

- Graph data structures
- Shortest path algorithms
- Decision trees
- Java Collections Framework
- File handling
- Object-Oriented Programming

## Authors

Developed as an academic project.

- Frank Jumbo
- Celeste Lascano

## License

This project was developed for academic purposes only.
````
