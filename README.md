# Canvas Project (Java Swing)

A lightweight and interactive **Paint Canvas Application** built using Java Swing.
This project demonstrates real-time drawing, mouse event handling, and Object-Oriented Programming (OOP) concepts in Java.

The application allows users to draw freely on a digital canvas with customizable brush sizes and colors, making it a simple yet effective Java GUI project.

---

## Overview

The Paint Canvas Application provides a user-friendly environment for freehand drawing using mouse interactions. It is designed to showcase how graphical interfaces and event-driven programming can be implemented in Java.

The system integrates essential drawing tools such as color selection, brush size control, and canvas reset into a single desktop application.

---
![image_url](https://github.com/Jaffer-29/Canvas-Project/blob/56affd8ebd46c08bef7db6e3fae3a5178eee6d97/Canvas%20ScreenShort.png)

---

## User Interface Note

The graphical interface is developed using Java Swing with manual layout management.

* The application uses a fixed window size
* The layout is not responsive
* UI appearance may vary across different screen resolutions
* Minor adjustments may be required for optimal display

---

## Features

### Drawing Canvas

* Interactive canvas for freehand drawing
* Smooth rendering using mouse drag events
* Real-time visual feedback
* Continuous stroke tracking

### Color Selection

* Choose custom colors using a color picker
* Apply selected color dynamically to brush strokes
* Button reflects selected color

### Brush Size Control

* Adjustable brush size using a slider
* Supports both fine and thick strokes
* Updates applied instantly during drawing

### Eraser Tool

* Works by switching brush color to white
* Enables selective removal of drawings

### Reset Canvas

* Clears the entire canvas
* Includes confirmation dialog to prevent accidental reset

### Stroke Persistence

* Stores drawing paths in memory
* Automatically redraws content when refreshed
* Maintains drawing state during execution

---

## Additional Feature (Optional Audio)

### Background Music Support

The project includes a `play()` method (currently commented out) intended to enhance the drawing experience.

#### Purpose of `play()` Method

* Plays a `.wav` audio file using the Java Sound API
* Creates a more engaging and relaxing environment while drawing
* Demonstrates integration of multimedia features in a Java application

#### Note on Audio File

* The audio file (`Paint Song.wav`) is not included in the repository
* This is because the file size is relatively large and would unnecessarily increase repository size
* Users can add their own `.wav` file and enable the method if desired

---

## Technologies Used

* Java
* Java Swing (GUI Development)
* AWT (Graphics and Event Handling)
* Java Sound API (Audio Playback)

---

## Object-Oriented Programming Concepts

* Encapsulation: Implemented through classes like `ColorPoints`
* Abstraction: Separation of GUI and drawing logic
* Composition: GUI constructed using multiple Swing components
* Event Handling: Managed using MouseAdapter and ActionListeners

---

## Project Structure

```id="project-structure"
Paint-Canvas-Application/
│── RunFrame.java          # Application entry point
│
├── GUI
│   └── PaintGUI.java      # Main frame and UI components
│
├── Core
│   ├── Canvas.java        # Drawing logic and rendering
│   └── ColorPoints.java   # Data model for storing points
```

---

## Getting Started

### Requirements

* Java JDK 8 or higher

### Compile and Run

```bash id="run-instructions"
javac *.java
java RunFrame
```

---

## How It Works

1. The application starts from `RunFrame.java`
2. The main window (`PaintGUI`) is initialized
3. A drawing canvas is displayed
4. Mouse interactions control drawing:

   * Mouse Press → Start drawing
   * Mouse Drag → Draw continuous strokes
   * Mouse Release → Save the stroke path
5. All drawing data is stored in memory
6. The canvas repaints using stored paths when needed

---

## Limitations

* No save or export functionality
* No undo/redo support
* UI is not responsive
* Limited drawing tools (basic brush and eraser)
* Audio feature is optional and disabled by default

---
## Acknowledgment

This project was inspired by a tutorial from Curad Programmer.  
The original concept was learned from the following resources:

- GitHub Repository: https://github.com/curadProgrammer/Java-Paint  
- YouTube Tutorial: https://www.youtube.com/watch?v=vcgeCYKdyC4

The implementation in this repository has been modified and extended with additional features and improvements.

---
## Project Status

Completed (Mini Project) <br>
Open for learning and academic use

---

## Author

Muhammad Jaffer<br>
Paint Canvas Application – Java Project

---

## License

This project is intended for educational purposes and is open for academic use.

---

