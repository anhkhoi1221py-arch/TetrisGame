# OOP Lab Report: Tetris Game Project

## 1. Project Information

**Project name:** Tetris Game  
**Programming language:** Java  
**User interface library:** Java Swing and Java AWT  
**Main package:** `tetris`  
**Main class:** `WindowGame`  
**Project type:** Object-Oriented Programming game application

**Group:** K

**Group members:**
- Cao Anh Khôi _ ITITIU25015
- Trần Anh Khôi _ ITITIU25016
- Trần Tuấn Hùng _ ITITIU25008
- Phan Trung Tiến Nhật _ ITITIU25024
- Đặng Thanh Sơn _ ITITIU25030

## 2. Introduction

This project is a Java implementation of the classic Tetris game. The program provides a graphical game window where the player controls falling tetromino blocks. The player can move blocks left and right, rotate them, speed up their fall, clear completed horizontal lines, pause the game, restart after game over, and return to the title menu.

The project is suitable for an Object-Oriented Programming lab because it separates the application into several cooperating classes. Each class has a clear role, and the game uses objects to represent the window, title screen, board, tetromino shapes, and image loading utility.

## 3. Objectives

The main objectives of this project are:

- To apply Object-Oriented Programming concepts in a real graphical game.
- To design separate classes with clear responsibilities.
- To use Java Swing and AWT to build a playable desktop interface.
- To manage game state, keyboard input, drawing, collision detection, and scoring.
- To demonstrate encapsulation, abstraction, composition, and separation of concerns.

## 4. Project Description

Tetris is a puzzle game where blocks with different shapes fall from the top of a rectangular board. The player tries to arrange the blocks so that a full horizontal row is filled. When a row is completed, it is removed and the score increases. The game ends when new blocks cannot appear because the top of the board is occupied.

In this implementation, the board has 10 columns and 20 rows. Each block has a size of 30 pixels. The game uses a Swing `Timer` to update the board repeatedly at 60 frames per second. The falling speed of the current shape is controlled inside the `Shape` class, while the `Board` class coordinates the overall game state.

The game also includes two visual modes:

- Classic mode, where blocks are drawn using colors.
- Image mode, where blocks are drawn using images from a sprite sheet.

## 5. Technologies Used

- Java 21
- Java Swing
- Java AWT
- Object-Oriented Programming
- Git and GitHub
- Visual Studio Code

## 6. Main Features

The project includes these main features:

- Title screen with instructions.
- Game start from the menu using the Enter key.
- Player movement using arrow keys.
- Shape rotation using the Up arrow key.
- Faster falling using the Down arrow key.
- Pause and resume using the Space key.
- Restart using the R key.
- Return to menu using the P key.
- Score system based on cleared lines.
- Game over detection.
- Classic color mode and image mode.

## 7. Class Design Overview

The project contains five main Java classes:

| Class | Responsibility |
| --- | --- |
| `WindowGame` | Creates the main `JFrame` window, shows the title screen, starts the game, and returns to the menu. |
| `Title` | Displays the title screen, controls mode selection, and starts the game when Enter is pressed. |
| `Board` | Represents the game board, game loop, game state, score, keyboard handling, drawing, restart, pause, and game over logic. |
| `Shape` | Represents a tetromino piece, including position, movement, rotation, collision, falling speed, line clearing, and rendering. |
| `ImageLoader` | Loads image resources from the project classpath. |

## 8. Class Responsibilities

### 8.1 `WindowGame`

`WindowGame` is the entry point of the application. It creates the `JFrame`, sets the window size, configures the close operation, and displays the title screen first. It also provides methods for switching between the title screen and the game board.

Important responsibilities:

- Create and configure the main game window.
- Create the `Title` screen.
- Start the game by replacing the title screen with a `Board` object.
- Return to the menu when requested by the board.

This class demonstrates object composition because it owns references to `JFrame`, `Title`, and `Board` objects.

### 8.2 `Title`

`Title` extends `JPanel` and implements `KeyListener`. It is responsible for the menu screen. It draws the game title, keyboard instructions, and visual mode options. The player can press `1` for classic mode, `2` for image mode, and Enter to start.

Important responsibilities:

- Draw the menu interface.
- Display movement and mode-selection instructions.
- Handle keyboard input on the title screen.
- Update the static mode setting `Board.USE_IMAGE_MODE`.
- Ask `WindowGame` to start the game.

### 8.3 `Board`

`Board` is one of the central classes in the project. It extends `JPanel` and implements `KeyListener`, which means it can draw the game and respond to keyboard input. It stores the current game state, score, board grid, landed block colors, landed block images, available shapes, and the current falling shape.

Important responsibilities:

- Store the 10 by 20 game board.
- Run the game loop using a Swing `Timer`.
- Update and repaint the game repeatedly.
- Draw the board, grid, score, pause message, and game-over message.
- Generate new random shapes.
- Check if the game is over.
- Reset the board and score.
- Process keyboard controls.

`Board` uses composition by containing an array of `Shape` objects and selecting one as the current active shape.

### 8.4 `Shape`

`Shape` represents a single tetromino. Its structure is stored as a two-dimensional integer matrix. A value of `1` means a block exists at that cell, and `0` means the cell is empty. The class also stores the shape position, color, image, movement speed, collision state, and reference to the board.

Important responsibilities:

- Store the tetromino matrix.
- Move left, move right, and fall downward.
- Rotate the tetromino matrix.
- Check horizontal and vertical collision.
- Place the shape permanently onto the board after collision.
- Clear completed lines.
- Increase the score through the board.
- Render the current falling piece.

The `Shape` class collaborates closely with `Board`. It reads the board grid to detect collisions and writes to the board grid when the piece lands.

### 8.5 `ImageLoader`

`ImageLoader` is a small utility class. It contains a static method that loads images using `ImageIO.read()` and returns a `BufferedImage`. If the image cannot be loaded, it returns `null`, allowing the game to continue in classic drawing mode.

Important responsibilities:

- Load image resources.
- Hide image-loading details from the other classes.
- Support the optional image mode feature.

## 9. Object-Oriented Programming Concepts Applied

### 9.1 Encapsulation

Encapsulation means keeping data and behavior together inside classes. This project applies encapsulation by placing related fields and methods inside the correct classes. For example, `Shape` stores its own `x`, `y`, `coords`, `color`, `image`, and movement timing. The methods `moveLeft()`, `moveRight()`, `speedUp()`, `speedDown()`, `rotateShape()`, and `update()` operate on that data.

`Board` encapsulates the board grid, score, game state, shape list, and game loop. Other classes do not directly control the board state except through public methods such as `getBoard()`, `getBoardImages()`, `setCurrentShape()`, `addPoint()`, and `reset()`.

### 9.2 Abstraction

Abstraction means hiding unnecessary implementation details and exposing useful behavior. For example, `WindowGame` does not need to know how a shape rotates or how lines are cleared. It only needs to create the board and switch screens. Similarly, `Title` does not need to know the details of the game loop. It only calls `window.startGame()`.

`ImageLoader.loadImage()` is another example of abstraction. The board asks for an image by path, while the loading details remain inside the utility class.

### 9.3 Inheritance

The project uses inheritance through Java Swing classes:

- `Board` extends `JPanel`.
- `Title` extends `JPanel`.

By extending `JPanel`, both classes can override `paintComponent(Graphics g)` and draw their own interface. They also become Swing components that can be added to the main `JFrame`.

### 9.4 Interface Implementation

The project uses the `KeyListener` interface:

- `Board implements KeyListener`.
- `Title implements KeyListener`.

This allows both classes to respond to keyboard events. Each class provides implementations for `keyTyped`, `keyPressed`, and `keyReleased`.

### 9.5 Composition

Composition is one of the most important OOP concepts in this project. `WindowGame` contains a `Title` object and a `Board` object. `Board` contains multiple `Shape` objects. A `Shape` also keeps a reference to the `Board` so it can check collisions and place landed blocks.

The main object relationship can be described as:

`WindowGame` creates `Title` and `Board`; `Board` creates and manages `Shape`; `Shape` interacts with `Board`.

### 9.6 Polymorphism

Polymorphism appears through Swing's component system and event interfaces. The `JFrame` can treat both `Title` and `Board` as Swing components because both extend `JPanel`. Also, the event system can call `keyPressed()` on any object that implements `KeyListener`, whether it is the title screen or the board.

## 10. Data Structures

The game uses several important data structures:

- `Color[][] board`: Stores landed blocks on the board. A `null` value means an empty cell.
- `BufferedImage[][] boardImages`: Stores block images for image mode.
- `int[][] coords`: Stores the structure of each tetromino shape.
- `Shape[] shapes`: Stores the seven available Tetris shapes.
- `Color[] colors`: Stores the color assigned to each shape.
- `BufferedImage[] tileImages`: Stores the image assigned to each shape.

These structures are simple but effective for a grid-based game. A two-dimensional array is a natural choice because the game board is also a two-dimensional grid.

## 11. Game Logic

### 11.1 Game Loop

The game loop is implemented using a Swing `Timer` in the `Board` class. The timer runs every `1000 / 60` milliseconds, which targets 60 updates per second. On each timer event, the board calls `update()` and then `repaint()`.

If the game state is `STATE_GAME_PLAY`, the current shape is updated. If the game is paused or over, the shape does not continue falling.

### 11.2 Shape Movement

The `Shape` class handles movement. Horizontal movement uses `deltaX`, which becomes `-1` for left and `1` for right. During `update()`, the shape checks whether the new horizontal position is inside the board and does not collide with landed blocks. If the movement is valid, the `x` position is updated.

Vertical movement happens based on elapsed time. The normal delay is 600 milliseconds. When the player holds the Down arrow key, the delay changes to 50 milliseconds.

### 11.3 Collision Detection

Collision detection checks whether the next position of the shape would exceed the board boundary or overlap with an existing block. If the shape cannot move downward, the `collision` flag becomes true. On the next update, the shape is copied into the board arrays and a new random shape is selected.

### 11.4 Rotation

Rotation is performed by transposing the shape matrix and then reversing the rows. This is a common matrix-based rotation technique. Before accepting the rotated shape, the program checks that the new shape does not go outside the board and does not overlap existing blocks.

### 11.5 Line Clearing and Score

After a shape lands, `checkLine()` scans the board from bottom to top. If a row is completely filled, it is removed by copying higher rows downward. For every cleared line, `board.addPoint()` increases the score by one.

### 11.6 Game Over

After a new shape is selected, `Board.checkOverGame()` checks whether the new shape overlaps existing blocks near the top of the board. If overlap occurs, the state changes to `STATE_GAME_OVER`.

## 12. User Controls

| Key | Action |
| --- | --- |
| Enter | Start the game from the title screen |
| 1 | Select classic mode |
| 2 | Select image mode |
| Left arrow | Move shape left |
| Right arrow | Move shape right |
| Up arrow | Rotate shape |
| Down arrow | Speed up falling |
| Space | Pause or resume during gameplay |
| R | Restart the game |
| P | Return to menu |

## 13. UML-Style Relationship Diagram

```text
+----------------+
|  WindowGame    |
+----------------+
| - JFrame       |
| - Title        |
| - Board        |
+----------------+
| + startGame()  |
| + returnToMenu() |
+----------------+
        |
        | creates and switches
        v
+----------------+          +----------------+
|    Title       |          |     Board      |
+----------------+          +----------------+
| extends JPanel |          | extends JPanel |
| KeyListener    |          | KeyListener    |
+----------------+          +----------------+
                                  |
                                  | owns and manages
                                  v
                           +---------------+
                           |    Shape      |
                           +---------------+
                           | coords matrix |
                           | position      |
                           | color/image   |
                           +---------------+
```

## 14. Strengths of the Design

- The project is divided into small classes with understandable roles.
- The use of `JPanel` makes drawing screens straightforward.
- The `Shape` class keeps tetromino behavior separate from the window setup.
- The board uses two-dimensional arrays, which match the grid nature of Tetris.
- The image mode is optional, so the game can still run if images are unavailable.
- The title screen and game board are separated instead of being drawn in one large class.

## 15. Testing

The project can be tested manually by running the main method in `WindowGame`. Important test cases include:

| Test case | Expected result |
| --- | --- |
| Press Enter on title screen | Game board appears and blocks start falling. |
| Press Left and Right arrows | Current shape moves horizontally if no collision occurs. |
| Press Up arrow | Current shape rotates if the rotated position is valid. |
| Hold Down arrow | Current shape falls faster. |
| Complete a row | Row is cleared and score increases. |
| Stack blocks to the top | Game over message appears. |
| Press Space during gameplay | Game pauses and resumes. |
| Press R | Board and score reset. |
| Press P | Game returns to the title menu. |
| Select modes with 1 and 2 | Classic or image mode is selected before starting. |

## 16. Conclusion

This Tetris project successfully demonstrates the use of Object-Oriented Programming in a Java game. The program separates the window, title screen, board, shape behavior, and image loading into different classes. It uses inheritance through Swing components, interface implementation through `KeyListener`, and composition between the main game objects.

The project also shows how OOP can make a graphical game easier to organize. Each class focuses on a specific part of the application, making the code easier to understand, test, and improve. Although there are opportunities for refinement, the current implementation provides a working Tetris game with clear examples of OOP principles.
