# RISC-V Simulator

## Overview

This project is a RISC-V RV32I simulator developed as part of the **CSCE 231: Computer Organization and Assembly Language Programming** course during Spring 2024. The simulator supports a wide range of RISC-V instructions and includes advanced features such as a GUI, multi-format output, and support for compressed and pseudo instructions. The simulator aims to provide an intuitive and interactive platform for users to learn and experiment with RISC-V architecture.

---

## Features

1. **GUI Application**

   - Intuitive graphical interface built using Java Swing.
   - Users can input assembly programs, view program execution step-by-step, and customize display formats.

2. **Multi-Format Output**

   - Display values in Decimal, Binary, and Hexadecimal formats.

3. **Support for Pseudo Instructions and Directives**

   - Includes five pseudo instructions and three directives for enhanced program compatibility.

4. **Compressed Instructions (RV32IC)**

   - Comprehensive support for the RV32IC instruction set, including compressed instructions.

5. **Integer Multiplication/Division (RV32IM)**

   - Full support for RV32IM instructions to enable complex arithmetic operations.

6. **Predefined Test Programs**

   - Built-in test programs for quick evaluation of simulator capabilities.

---

## Design Decisions and Assumptions

- **Programming Environment**: Developed using Apache NetBeans for Java development.
- **GUI Framework**: Built with Java Swing to provide a user-friendly interface.
- **Instruction Handling**:
  - Sequential processing of instructions.
  - Error handling for unsupported instructions and invalid operations.
- **Visualization**:
  - Separate displays for data memory and instruction memory.
  - Program counter tracking and progress bar for simulation monitoring.
- **Initialization**: Default settings for assembly code, program counter, and memory ensure a seamless start.

---

## Installation and Usage

### Compilation and Execution

1. Clone the repository:
   ```
   git clone https://github.com/FaridaBey/rv32i-simulator.git
   ```
2. Open the project in your preferred IDE (e.g., Apache NetBeans) or compile using command-line tools.
3. Run the main Java class to launch the GUI application.
4. Follow the on-screen instructions to input assembly code, program data, and the starting address.

### User Guide

1. **Launching the Simulator**

   - Input assembly code and starting address in the provided textboxes.
   - Use predefined test programs for quick setup.

2. **Simulation Controls**

   - **Submit**: Load the program.
   - **Next Instruction**: Step through each instruction.
   - **Restart**: Reset the simulation.
   - **Format**: Toggle between Decimal, Binary, and Hexadecimal output formats.

3. **Visualization**

   - View program counter, current instruction, register values, and memory contents.
   - Progress bar updates with each executed instruction.

---

## Supported Instructions and Features

1. **Arithmetic and Logical Operations**: `add`, `sub`, `addi`, `xor`, `or`, `and`, etc.
2. **Memory Operations**: `lw`, `sw`, `lb`, `sh`, `sb`, etc.
3. **Control Transfer**: `jal`, `beq`, `bne`, `blt`, etc.
4. **Compressed Instructions**: `c.addi`, `c.lw`, etc.
5. **Directives and Pseudo Instructions**: Enhanced assembly program flexibility.
6. **Integer Multiplication/Division**: `mul`, `div`, etc.

---

## Test Programs

### Program 1: Basic Arithmetic

Supports instructions such as `addi`, `add`, `sub`, `lb`, `sw`, and `slli`.

### Program 2: Control Flow and Logic

Includes `lui`, `auipc`, `jal`, `bge`, and `beq` instructions.

### Program 3: Bitwise Operations

Demonstrates `xori`, `ori`, `and`, `srl`, and `sra` instructions.

### Program 4: Comparison Operations

Uses `slti`, `sltu`, `sll`, and `FENCE` instructions.

---

## Conclusion

The RISC-V RV32I simulator is a comprehensive tool for simulating assembly programs, providing an interactive learning experience for students and professionals. With its robust features and user-friendly interface, it offers an effective platform for exploring the RISC-V architecture.

---

## Contributors

- Farida Bey&#x20;
- Hassan Mohammed&#x20;
- Mark Kyrollos
- Peter Aziz 
