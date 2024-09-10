

# Uno Game Engine

## 1. Introduction

This Uno Game Engine allows developers to create their own variations of the Uno game by extending the provided classes and methods. Built using Object-Oriented Programming (OOP) principles, the engine incorporates design patterns, clean code practices, and best practices from "Effective Java" and SOLID principles.

## 2. Object-Oriented Design

The engine adheres to core OOP principles, promoting reusability, scalability, and maintainability.

### 2.1 Encapsulation

- **Card Class**: Encapsulates properties like color and restricts modification after creation.
- **Player Class**: Encapsulates the player's hand, ensuring controlled modification through specific methods.

### 2.2 Inheritance

- **Card Hierarchy**: A base `Card` class is extended by `NumberCard`, `ActionCard`, `ColorCard`, and `WildCard`.
- **Game Hierarchy**: An abstract `Game` class defines common behavior for various Uno game types like `ClassicUnoGame`.

### 2.3 Polymorphism

- **Card Handling**: The `applyRules()` method allows all cards to be treated as instances of `Card`, while performing specific actions based on the actual card type.
- **Action Cards**: Each action card subclass implements its own `apply()` method, providing specific behavior.

### 2.4 Abstraction

- **Game Class**: The abstract `Game` class provides a high-level interface for all games, hiding implementation details.
- **Card Class**: Abstracts the concept of a card, enabling the creation of various card types.

## 3. Design Patterns

Several design patterns are used to enhance the engine’s flexibility and maintainability.

### 3.1 Factory Method Pattern

The `DrawPile` class uses the Factory Method pattern in `initialize()` to create different types of cards and encapsulate the creation logic.

### 3.2 Template Method Pattern

The `Game` class uses the Template Method pattern in the `play()` method, defining a common game loop structure while allowing specific game rules to be implemented in subclasses.

### 3.3 Strategy Pattern

The Strategy Pattern is used to manage different card actions, providing flexibility and modularity.

- **Abstract Strategy**: `ActionCard` defines a common interface for action cards.
- **Concrete Strategies**: Specific action cards (`SkipCard`, `ReverseCard`, etc.) implement the `apply()` method.
- **Context**: The `Game` class manages the game flow and delegates actions to specific cards.

### 3.4 Singleton Pattern (Potential Improvement)

Applying the Singleton pattern to the `DiscardPile` and `DrawPile` classes ensures only one instance exists in the game.

## 4. Clean Code Principles

The engine adheres to clean code practices from Robert C. Martin’s "Clean Code."

### 4.1 Meaningful Names

Class and method names are descriptive and consistent (e.g., `DrawPile`, `apply()`).

### 4.2 Small Functions

Each method has a single responsibility, keeping functions short and focused (e.g., `initialize()` and `apply()`).

### 4.3 Comments

The code is mostly self-explanatory with minimal comments, ensuring readability and clarity.

### 4.4 Error Handling

Exception handling and defensive programming are employed to catch errors early and handle edge cases.

## 5. Effective Java Items

Best practices from "Effective Java" by Joshua Bloch are incorporated where applicable.

### Item 1: Consider static factory methods instead of constructors

While constructors are currently used for simplicity, static factory methods could be introduced if more complex object creation is required in future versions.


### Extending the Engine

To create your own game variation, extend the `Game` class and implement the necessary methods. Similarly, you can create new card types by extending the `Card` class or its subclasses.

## 7. Contributing

Contributions are welcome! Feel free to submit a pull request or open an issue for discussion.

## 8. License

This project is licensed under the MIT License.

---

This README.md provides a clear overview of your project, including key design elements and instructions for getting started.
