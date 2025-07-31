# Simple Tic Tac Toe with Java

A console-based Tic Tac Toe game written in Java featuring multiple game modes including AI opponents. This project demonstrates object-oriented programming principles, game logic implementation, and AI algorithms.

## 🎮 Features

- **Multiple Game Modes:**
  - Player vs Player (Human vs Human)
  - Player vs Random AI
  - Player vs MinMax AI (Unbeatable AI)
- **Clean Console Interface** with visual board representation
- **Smart AI Implementation** using the MinMax algorithm
- **Input Validation** and error handling
- **Modular Design** using object-oriented principles

## 🚀 How to Run

### Prerequisites
- Java 8 or higher
- Any Java IDE or command line

### Compilation and Execution

#### Using Command Line:
```bash
# Navigate to the project directory
cd Simple-TicTacToe-with-Java

# Compile all Java files
javac -d bin src/game/*.java src/game/player/*.java

# Run the game
java -cp bin game.Main
```

#### Using an IDE:
1. Import the project into your Java IDE
2. Run the `Main.java` file located in `src/game/`

## 🎯 How to Play

1. **Choose Game Mode:** Select from the menu options when the game starts
2. **Make Moves:** Enter row and column coordinates (0-2) when prompted
3. **Win Condition:** Get three of your symbols in a row (horizontal, vertical, or diagonal)
4. **Board Layout:** The game uses a 3x3 grid with coordinates:
   ```
   (0,0) | (0,1) | (0,2)
   ------|-------|------
   (1,0) | (1,1) | (1,2)
   ------|-------|------
   (2,0) | (2,1) | (2,2)
   ```

## 🏗️ Project Structure

```
src/
├── game/
│   ├── Main.java           # Entry point and main game loop
│   ├── Game.java           # Game controller and player management
│   ├── Board.java          # Game board logic and win detection
│   ├── Console.java        # User input/output handling
│   ├── GameMode.java       # Enum for different game modes
│   └── player/
│       ├── Player.java         # Abstract base class for all players
│       ├── HumanPlayer.java    # Human player implementation
│       ├── RandomAIPlayer.java # Random move AI
│       └── MinMaxAI.java       # Intelligent AI using MinMax algorithm
```

## 🤖 AI Implementation

### Random AI
Makes random valid moves on the board. Good for casual play and testing.

### MinMax AI
Implements the **MinMax algorithm** with the following features:
- **Perfect Play:** Never loses when playing optimally
- **Strategic Depth:** Evaluates all possible future game states
- **Move Optimization:** Prefers faster wins and slower losses
- **Unbeatable:** Will always win or tie against any opponent

The MinMax algorithm recursively explores all possible moves, alternating between maximizing the AI's score and minimizing the opponent's score.

## 🛠️ Technical Highlights

- **Object-Oriented Design:** Uses inheritance, polymorphism, and encapsulation
- **Strategy Pattern:** Different player types implement the same interface
- **Clean Architecture:** Separation of concerns between game logic, UI, and player behavior
- **Input Validation:** Robust handling of user input with error messages
- **Recursive Algorithms:** MinMax implementation with game tree traversal

## 📚 What I Learned

This project helped me practice and understand:
- **Java OOP concepts:** Classes, inheritance, abstract classes, polymorphism
- **Game Development:** Game loops, state management, win condition checking
- **Algorithm Implementation:** MinMax algorithm for game AI
- **Code Organization:** Package structure and modular design
- **User Input Handling:** Scanner usage and input validation
- **Error Handling:** Graceful handling of invalid inputs

## 🔧 Possible Improvements

- Add a graphical user interface (GUI)
- Implement Alpha-Beta pruning for MinMax optimization
- Add difficulty levels for AI
- Include game statistics and score tracking
- Add network multiplayer functionality

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

*This project was created as a learning exercise to practice Java programming and game development concepts.*
