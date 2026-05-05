# Project
  - Tetris game.
# Description
  - This is a Java-based implementation of the game Tetris.
  - It allows users to play the game using a graphical user interface.
# Game Rules
  - Blocks fall from the top of the screen.
  - Player can move the blocks left or right.
  - Player can rotate and speed up the blocks.
  - A full horizontal line is cleared.
  - The game ends when blocks reach the top of the board.
# Main Features
  - Graphical user interface.
  - Player controls.
  - Score system.
  - Game board.
  - Game start and restart.
  - Basic game logic.
# Class Design 
  The project is divided into several classes:
    - "WindowGame.java": Creates the main game window and starts the program.
    - "Title.java": Displays the title screen and game instructions.
    - "Board.java": Handles the game board, game loop, keyboard input, score, pause, restart, and game over.
    - "Shape.java": Handles tetromino movement, rotation, falling speed, collision, and drawing.
    - "ImageLoader.java": Loads images used in the game.
# Class Diagram
  - "WindowGame" creates and manages "Title" and "Board".
  - "Title" calls "WindowGame" to start the game.
  - "Board" creates and manages "Shape" objects.
  - "Shape" uses "Board" to check collision and store landed blocks.
# Technologies Used
  - Java
  - Java Swing
  - Java AWT
  - Git
  - GitHub
  - Visual Studio Code
# Extra Features 
  - Title screen with instructions
  - Pause and resume game
  - Restart after game over
  - Score system
  - Image mode / classic mode
# Design Patterns 
  - Encapsulation: Each class has its own responsibility.
  - Separation of concerns: Window, title screen, board logic, and shape logic are separated into different classes.
  - Object composition: `Board` contains and manages multiple `Shape` objects.
# How To Run The Project (to be filled)
# Team Members
  - Trần Anh Khôi _ ITITIU25016
  - Cao Anh Khôi _ ITITIU25015
  - Trần Tuấn Hùng _ ITITIU25008
  - Phan Trung Tiến Nhật _ ITITIU25024
  - Đặng Thanh Sơn _ ITITIU25030
