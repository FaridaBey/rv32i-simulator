/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Hassan
 */





public class Viewer extends javax.swing.JFrame {
//global Varibels
public  Map <Integer, Integer> Memory = new HashMap<>(); // Memory
public  ArrayList<Integer> reg = new ArrayList<>(Collections.nCopies(32, 0));
// binary output 
public String decimalToBinary(int decimal) {
    return Integer.toBinaryString(decimal);
}
// hexa output
public String decimalToHexadecimal(int decimal) {
    return Integer.toHexString(decimal);
}




//Parsing Functions
   public  String extractOpcode(String instruction) {
        // Splitting the instruction by whitespace or comma
        String[] parts = instruction.split("[,\\s]+");
        // Returning the first part, which is the opcode
        return parts[0];
    }
//Instruction Functions 
   // 1
   public void lui (String instr){
        String[] parts = instr.split("[,\\s]+");
            int regd = 0, imm = 0;
        
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("x")) {
                regd = Integer.parseInt(part.substring(1));
            } else {
                imm = Integer.parseInt(part);
            }
        }
     
        reg.set(regd, imm);
        
     }
   
   // 10
   public  void BGEU (String instr){
       String[] assembly_line_split = instr.split("[\\s,]+");

        //getting the first source register number
        String rs1_string = assembly_line_split[1].substring(1);
        int rs1_int = Integer.parseInt(rs1_string);
        
        // getting the second source register number
        String rs2_string = assembly_line_split[2].substring(1);
        int rs2_int = Integer.parseInt(rs2_string);
                
        //getting the label
        String label = assembly_line_split[3];
                
        // doing the comparison 
        int value_rs1_absolute = Math.abs(reg.get(rs1_int));
        int value_rs2_absolute = Math.abs(reg.get(rs2_int));
        
        if ((value_rs1_absolute == value_rs2_absolute) || (value_rs1_absolute > value_rs2_absolute)){
            // go to label
            System.out.println("Go to label: " + label);
        }
        else
            System.out.println("continued without branching");
    }
   
   // 11
   public  void LB (String instr){
   String[] parts = instr.split("[,\\s]+");
        
        String rd_string = parts[1].substring(1);
        int rd_int = Integer.parseInt(rd_string);
        
        
        String off_set_string = parts[2];
        int off_set = Integer.parseInt(off_set_string);
        
        int length_temp = parts[3].length();
        String base_reg_string = parts[3].substring(2,length_temp-1);
        int base_addr_reg = Integer.parseInt(base_reg_string);
        int base_addr = reg.get(base_addr_reg);
        System.out.println("BASE addr  " + base_addr + "\n");
        
        int value = Memory.get(base_addr + off_set);
        
        reg.set(rd_int,value);
    }
   
   // 12
   public  void LH (String instr){
   String[] parts = instr.split("[,\\s]+");
        
        String rd_string = parts[1].substring(1);
        int rd_int = Integer.parseInt(rd_string);
        
        
        String off_set_string = parts[2];
        int off_set = Integer.parseInt(off_set_string);
        
        int length_temp = parts[3].length();
        String base_reg_string = parts[3].substring(2,length_temp-1);
        int base_addr_reg = Integer.parseInt(base_reg_string);
        int base_addr = reg.get(base_addr_reg);
        System.out.println("BASE addr  " + base_addr + "\n");
        
        int value = Memory.get(base_addr + off_set);
        
        reg.set(rd_int,value);
    }
   
   // 13
   public  void LW (String instr){
   String[] parts = instr.split("[,\\s]+");
        
        String rd_string = parts[1].substring(1);
        int rd_int = Integer.parseInt(rd_string);
        
        
        String off_set_string = parts[2];
        int off_set = Integer.parseInt(off_set_string);
        
        int length_temp = parts[3].length();
        String base_reg_string = parts[3].substring(2,length_temp-1);
        int base_addr_reg = Integer.parseInt(base_reg_string);
        int base_addr = reg.get(base_addr_reg);
        System.out.println("BASE addr  " + base_addr + "\n");
        
        int value = Memory.get(base_addr + off_set);
        int value_unsinged = Math.abs(value);
        
        reg.set(rd_int,value_unsinged);
    }
   
   // 14
   public  void LBU (String instr){
   String[] parts = instr.split("[,\\s]+");
        
        String rd_string = parts[1].substring(1);
        int rd_int = Integer.parseInt(rd_string);
        
        
        String off_set_string = parts[2];
        int off_set = Integer.parseInt(off_set_string);
        
        int length_temp = parts[3].length();
        String base_reg_string = parts[3].substring(2,length_temp-1);
        int base_addr_reg = Integer.parseInt(base_reg_string);
        int base_addr = reg.get(base_addr_reg);
        System.out.println("BASE addr  " + base_addr + "\n");
        
        int value = Memory.get(base_addr + off_set);
        int value_unsinged = Math.abs(value);
        reg.set(rd_int,value_unsinged);
    }
   
   // 15
   public  void LHU (String instr){
   String[] parts = instr.split("[,\\s]+");
        
        String rd_string = parts[1].substring(1);
        int rd_int = Integer.parseInt(rd_string);
        
        
        String off_set_string = parts[2];
        int off_set = Integer.parseInt(off_set_string);
        
        int length_temp = parts[3].length();
        String base_reg_string = parts[3].substring(2,length_temp-1);
        int base_addr_reg = Integer.parseInt(base_reg_string);
        int base_addr = reg.get(base_addr_reg);
        System.out.println("BASE addr  " + base_addr + "\n");
        
        int value = Memory.get(base_addr + off_set);
        int value_unsinged = Math.abs(value);
        reg.set(rd_int,value_unsinged);
    }
   
   // 16
   public  void SH (String instr){
   String[] parts = instr.split("[,\\s]+");
        
        String value_reg = parts[1].substring(1);
        int value_reg_int = Integer.parseInt(value_reg);
        int value = reg.get(value_reg_int);
        System.out.println("VALUE IN SOURCE REG " + value + "\n" );
        
        
        String off_set_string = parts[2];
        int off_set = Integer.parseInt(off_set_string);
        System.out.println("OFFset " + off_set+ "\n");
        
        int length_temp = parts[3].length();
        String base_reg_string = parts[3].substring(2,length_temp-1);
        int base_addr_reg = Integer.parseInt(base_reg_string);
        int base_addr = reg.get(base_addr_reg);
        System.out.println("BASE addr  " + base_addr + "\n");
        
        Memory.put(base_addr + off_set , value);
        
        System.out.println("Memory location: " + Memory);
    }
   
   // 17
   public  void SB (String instr){
   String[] parts = instr.split("[,\\s]+");
        
        String value_reg = parts[1].substring(1);
        int value_reg_int = Integer.parseInt(value_reg);
        int value = reg.get(value_reg_int);
        
        
        String off_set_string = parts[2];
        int off_set = Integer.parseInt(off_set_string);
        
        int length_temp = parts[3].length();
        String base_reg_string = parts[3].substring(2,length_temp-1);
        int base_addr_reg = Integer.parseInt(base_reg_string);
        int base_addr = reg.get(base_addr_reg);
        
        Memory.put(base_addr + off_set , value);
        System.out.println("Memory location: " + Memory);
    }
   // 18
   public  void SW (String instr){
   String[] parts = instr.split("[,\\s]+");
        
        String value_reg = parts[1].substring(1);
        int value_reg_int = Integer.parseInt(value_reg);
        int value = reg.get(value_reg_int);
        
        
        String off_set_string = parts[2];
        int off_set = Integer.parseInt(off_set_string);
        
        int length_temp = parts[3].length();
        String base_reg_string = parts[3].substring(2,length_temp-1);
        int base_addr_reg = Integer.parseInt(base_reg_string);
        int base_addr = reg.get(base_addr_reg);
        
        Memory.put(base_addr + off_set , value);
       System.out.println("Memory location: " + Memory);
    }
   
   //19
   public void addi(String instr) {
    String[] assembly_line_split = instr.split("[\\s,]+");
        
        //getting the destination register number
        String rd_num_string = assembly_line_split[1].substring(1);
        int rd_num_int = Integer.parseInt(rd_num_string);
        
        // getting the source register number
        String rs_num_string = assembly_line_split[2].substring(1);
        int rs_num_int = Integer.parseInt(rs_num_string);
                
        //getting the immidate value 
        int imm = Integer.parseInt(assembly_line_split[3]);
                
        // doing the operation and saving in the reg 
        
         reg.set(rd_num_int,reg.get(rs_num_int)+imm);
        
        for(int i = 0; i<32;i++){    // populate Registers  
        
        System.out.println("ADDI FUNCTION OUTPUT : "+"x" + i + ": " + reg.get(i)); //Test
        }
            System.out.println("------------------------------------------------------"); //Test 
}
   
  // 20
    public  void SLLI (String instr){
        String[] assembly_line_split = instr.split("[\\s,]+");
        
        //getting the destination register number
        String rd_num_string = assembly_line_split[1].substring(1);
        int rd_num_int = Integer.parseInt(rd_num_string);
        
        // getting the source register number
        String rs_num_string = assembly_line_split[2].substring(1);
        int rs_num_int = Integer.parseInt(rs_num_string);
                
        //getting the immidate value 
        int imm = Integer.parseInt(assembly_line_split[3]);
                
        // doing the operation and saving in the reg 
        
        reg.set(rd_num_int,reg.get(rs_num_int) << imm);
        
    }
    
    //28
    public void add(String instr) {
        String[] parts = instr.split("[,\\s]+");
        int regd = 0, regs1 = 0, regs2 = 0;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("x")) {
                if (regd == 0) {
                    regd = Integer.parseInt(part.substring(1));
                } else if (regs1 == 0) {
                    regs1 = Integer.parseInt(part.substring(1));
                } else {
                    regs2 = Integer.parseInt(part.substring(1));
                }
            }
        }
        reg.set(regd, reg.get(regs1) + reg.get(regs2));
    }
    //29
    public void sub(String instr) {
        String[] parts = instr.split("[,\\s]+");
        int regd = 0, regs1 = 0, regs2 = 0;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("x")) {
                if (regd == 0) {
                    regd = Integer.parseInt(part.substring(1));
                } else if (regs1 == 0) {
                    regs1 = Integer.parseInt(part.substring(1));
                } else {
                    regs2 = Integer.parseInt(part.substring(1));
                }
            }
        }
        reg.set(regd, reg.get(regs1) - reg.get(regs2));
    }
    //36
    public void or(String instr) {
        String[] parts = instr.split("[,\\s]+");
        int regd = 0, regs1 = 0, regs2 = 0;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("x")) {
                if (regd == 0) {
                    regd = Integer.parseInt(part.substring(1));
                } else if (regs1 == 0) {
                    regs1 = Integer.parseInt(part.substring(1));
                } else {
                    regs2 = Integer.parseInt(part.substring(1));
                }
            }
        }
        reg.set(regd, reg.get(regs1) | reg.get(regs2));
    }
    //30
    public void sll(String instr) {
        String[] parts = instr.split("[,\\s]+");
        int regd = 0, regs = 0, shamt = 0;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("x")) {
                if (regd == 0) {
                    regd = Integer.parseInt(part.substring(1));
                } else {
                    regs = Integer.parseInt(part.substring(1));
                }
            } else {
                shamt = Integer.parseInt(part);
            }
        }
        reg.set(regd, reg.get(regs) << shamt);
    }
    //31
    public void slt(String instr) {
        String[] parts = instr.split("[,\\s]+");
        int regd = 0, regs1 = 0, regs2 = 0;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("x")) {
                if (regd == 0) {
                    regd = Integer.parseInt(part.substring(1));
                } else if (regs1 == 0) {
                    regs1 = Integer.parseInt(part.substring(1));
                } else {
                    regs2 = Integer.parseInt(part.substring(1));
                }
            }
        }
        reg.set(regd, reg.get(regs1) < reg.get(regs2) ? 1 : 0);
    }
    //32
    public void sltu(String instr) {
        String[] parts = instr.split("[,\\s]+");
        int regd = 0, regs1 = 0, regs2 = 0;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("x")) {
                if (regd == 0) {
                    regd = Integer.parseInt(part.substring(1));
                } else if (regs1 == 0) {
                    regs1 = Integer.parseInt(part.substring(1));
                } else {
                    regs2 = Integer.parseInt(part.substring(1));
                }
            }
        }
        reg.set(regd, Integer.compareUnsigned(reg.get(regs1), reg.get(regs2)) < 0 ? 1 : 0);
    }
    //33
    public void xor(String instr) {
        String[] parts = instr.split("[,\\s]+");
        int regd = 0, regs1 = 0, regs2 = 0;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("x")) {
                if (regd == 0) {
                    regd = Integer.parseInt(part.substring(1));
                } else if (regs1 == 0) {
                    regs1 = Integer.parseInt(part.substring(1));
                } else {
                    regs2 = Integer.parseInt(part.substring(1));
                }
            }
        }
        reg.set(regd, reg.get(regs1) ^ reg.get(regs2));
    }
    //34
    public void srl(String instr) {
        String[] parts = instr.split("[,\\s]+");
        int regd = 0, regs = 0, shamt = 0;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("x")) {
                if (regd == 0) {
                    regd = Integer.parseInt(part.substring(1));
                } else {
                    regs = Integer.parseInt(part.substring(1));
                }
            } else {
                shamt = Integer.parseInt(part);
            }
        }
        reg.set(regd, reg.get(regs) >>> shamt);
    }
    //35
    public void sra(String instr) {
        String[] parts = instr.split("[,\\s]+");
        int regd = 0, regs = 0, shamt = 0;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("x")) {
                if (regd == 0) {
                    regd = Integer.parseInt(part.substring(1));
                } else {
                    regs = Integer.parseInt(part.substring(1));
                }
            } else {
                shamt = Integer.parseInt(part);
            }
        }
        reg.set(regd, reg.get(regs) >> shamt);
    }
    //37
    public void and(String instr) {
        String[] parts = instr.split("[,\\s]+");
        int regd = 0, regs1 = 0, regs2 = 0;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("x")) {
                if (regd == 0) {
                    regd = Integer.parseInt(part.substring(1));
                } else if (regs1 == 0) {
                    regs1 = Integer.parseInt(part.substring(1));
                } else {
                    regs2 = Integer.parseInt(part.substring(1));
                }
            }
        }
        reg.set(regd, reg.get(regs1) & reg.get(regs2));
    }

    //EXTRA INSTRUCTIONS MUL AND DIV
    //m1
    public void mul(String instr) {
        String[] parts = instr.split("[,\\s]+");
        int regd = 0, regs1 = 0, regs2 = 0;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("x")) {
                if (regd == 0) {
                    regd = Integer.parseInt(part.substring(1));
                } else if (regs1 == 0) {
                    regs1 = Integer.parseInt(part.substring(1));
                } else {
                    regs2 = Integer.parseInt(part.substring(1));
                }
            }
        }
        reg.set(regd, reg.get(regs1) * reg.get(regs2));
    }
    //m2
    public void mulh(String instr) {
        String[] parts = instr.split("[,\\s]+");
        int regd = 0, regs1 = 0, regs2 = 0;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("x")) {
                if (regd == 0) {
                    regd = Integer.parseInt(part.substring(1));
                } else if (regs1 == 0) {
                    regs1 = Integer.parseInt(part.substring(1));
                } else {
                    regs2 = Integer.parseInt(part.substring(1));
                }
            }
        }
        // Perform MULH operation
        long result = (long) reg.get(regs1) * (long) reg.get(regs2);
        reg.set(regd, (int) (result >> 32)); // Store the high 32 bits of the result
    }
    //m3
    public void mulhsu(String instr) {
        String[] parts = instr.split("[,\\s]+");
        int regd = 0, regs1 = 0, regs2 = 0;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("x")) {
                if (regd == 0) {
                    regd = Integer.parseInt(part.substring(1));
                } else if (regs1 == 0) {
                    regs1 = Integer.parseInt(part.substring(1));
                } else {
                    regs2 = Integer.parseInt(part.substring(1));
                }
            }
        }
        // Perform MULHSU operation
        long result = (long) reg.get(regs1) * (long) (reg.get(regs2) & 0xFFFFFFFFL);
        reg.set(regd, (int) (result >> 32)); // Store the high 32 bits of the result
    }
    //m4
    public void mulhu(String instr) {
        String[] parts = instr.split("[,\\s]+");
        int regd = 0, regs1 = 0, regs2 = 0;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("x")) {
                if (regd == 0) {
                    regd = Integer.parseInt(part.substring(1));
                } else if (regs1 == 0) {
                    regs1 = Integer.parseInt(part.substring(1));
                } else {
                    regs2 = Integer.parseInt(part.substring(1));
                }
            }
        }
        // Perform MULHU operation
        long result = (long) (reg.get(regs1) & 0xFFFFFFFFL) * (long) (reg.get(regs2) & 0xFFFFFFFFL);
        reg.set(regd, (int) (result >>> 32)); // Store the high 32 bits of the result
    }   
    //m5         
    public void div(String instr) {
        String[] parts = instr.split("[,\\s]+");
        int regd = 0, regs1 = 0, regs2 = 0;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("x")) {
                if (regd == 0) {
                    regd = Integer.parseInt(part.substring(1));
                } else if (regs1 == 0) {
                    regs1 = Integer.parseInt(part.substring(1));
                } else {
                    regs2 = Integer.parseInt(part.substring(1));
                }
            }
        }
        if (reg.get(regs2) != 0) {
            reg.set(regd, reg.get(regs1) / reg.get(regs2));
        } else {
            System.err.println("Error: Division by zero.");
        }
    }
    //m6
    public void divu(String instr) {
        String[] parts = instr.split("[,\\s]+");
        int regd = 0, regs1 = 0, regs2 = 0;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("x")) {
                if (regd == 0) {
                    regd = Integer.parseInt(part.substring(1));
                } else if (regs1 == 0) {
                    regs1 = Integer.parseInt(part.substring(1));
                } else {
                    regs2 = Integer.parseInt(part.substring(1));
                }
            }
        }
        // Perform DIVU operation
        int dividend = reg.get(regs1);
        int divisor = reg.get(regs2);
        if (divisor != 0) {
            reg.set(regd, Integer.divideUnsigned(dividend, divisor));
        } else {
            System.err.println("Error: Division by zero.");
        }
    }
    //m7
    public void rem(String instr) {
        String[] parts = instr.split("[,\\s]+");
        int regd = 0, regs1 = 0, regs2 = 0;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("x")) {
                if (regd == 0) {
                    regd = Integer.parseInt(part.substring(1));
                } else if (regs1 == 0) {
                    regs1 = Integer.parseInt(part.substring(1));
                } else {
                    regs2 = Integer.parseInt(part.substring(1));
                }
            }
        }
        // Perform REM operation
        int dividend = reg.get(regs1);
        int divisor = reg.get(regs2);
        if (divisor != 0) {
            reg.set(regd, dividend % divisor);
        } else {
            System.err.println("Error: Division by zero.");
        }
    }
    //m8
    public void remu(String instr) {
        String[] parts = instr.split("[,\\s]+");
        int regd = 0, regs1 = 0, regs2 = 0;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("x")) {
                if (regd == 0) {
                    regd = Integer.parseInt(part.substring(1));
                } else if (regs1 == 0) {
                    regs1 = Integer.parseInt(part.substring(1));
                } else {
                    regs2 = Integer.parseInt(part.substring(1));
                }
            }
        }
        // Perform REMU operation
        int dividend = reg.get(regs1);
        int divisor = reg.get(regs2);
        if (divisor != 0) {
            reg.set(regd, Integer.remainderUnsigned(dividend, divisor));
        } else {
            System.err.println("Error: Division by zero.");
        }
    }
            

//Processing Instructions
public void ProcessInstruction(String instruction){

String opcode = extractOpcode(instruction);

System.out.println("OpCode : "+ opcode); // Test

switch(opcode){
    //1
    case "lui":{ lui(instruction); }
    break;
    
    //10
    case "bgeu":{ BGEU(instruction); }
    break;
    
    //11
    case "lb":{ LB(instruction); }
    break;
    
    //12
    case "lh":{ LH(instruction); }
    break;
    
    //13
    case "lw":{ LW(instruction); }
    break;
    
    //14
    case "lbu":{ LHU(instruction); }
    break;
    
    //15
    case "lhu":{ LHU(instruction); }
    break;
    
    //16
    case "sb":{ SB(instruction); }
    break;
    
    //17
    case "sh":{ SH(instruction); }
    break;
    
    //18
    case "sw":{ SW(instruction); }
    break;
    
    // 19
    case "addi":{ addi(instruction); }
    break;
    
    // 20
    case "slli":{ SLLI(instruction); }
    break; 
    
    // 28
    case "add": {
        add(instruction);
    }
    break;
     // 29
    case "sub": {
        sub(instruction);
    }
    break;
    // 36
    case "or": {
        or(instruction);
    }
    break;
    //30
    case "sll": {
        sll(instruction);
    }
    break;
    //31
    case "slt": {
        slt(instruction);
    }
    break;
    // 32
    case "sltu": {
        sltu(instruction);
    }
    break;
    //33
    case "xor": {
        xor(instruction);
    }
    break;
    //34
    case "srl": {
        srl(instruction);
    }
    break;
    //35
    case "sra": {
        sra(instruction);
    }
    break;
    //37
    case "and": {
        and(instruction);
    }
    break;
    //m1
    case "mul": {
        mul(instruction);
        break;
    }
    //m2
    case "mulh": {
        mulh(instruction);
        break;
    }
    //m3
    case "mulhsu": {
        mulhsu(instruction);
        break;
    }
    //m4
    case "mulhu": {
        mulhu(instruction);
        break;
    }
    //m5
    case "div": {
        div(instruction);
        break;
    }
    //m6
    case "divu": {
        divu(instruction);
        break;
    }
    //m7
    case "rem": {
        rem(instruction);
        break;
    }
    //m8
    case "remu": {
        remu(instruction);
        break;
    }

}
}
String[] Instruction;
int counter;

public void PrintRegisters() {
    
    Registers.setText("");
  
    
    
    // Assuming RS provides a method to retrieve register values
    // Ensure the register list is valid and has enough elements
        for (int i = 0; i < 32; i++) {
           Registers.append("x" + i + ": " + reg.get(i) + "\n");
           // System.out.println("PrintReg FUNCTION OUTPUT : " + "x" + i + ": " + RS.reg[i]); //Test
        }
    }

// print binary regs
public void Print_bin_Registers() {
    Registers.setText("");

    // Ensure the register list is valid and has enough elements
    for (int i = 0; i < 32; i++) {
        // Convert the decimal register value to binary
        String binaryValue = decimalToBinary(reg.get(i));
        Registers.append("x" + i + ": " + binaryValue + "\n");
    }
}
// print hexa regs
public void Print_hexa_Registers() {
    Registers.setText("");

    // Ensure the register list is valid and has enough elements
    for (int i = 0; i < 32; i++) {
        // Convert the decimal register value to hexadecimal
        String hexadecimalValue = decimalToHexadecimal(reg.get(i));
        Registers.append("x" + i + ": " + hexadecimalValue + "\n");
    }
}


public void PrintMemory(){
    Memory1.setText("");
if(!Memory.isEmpty()){
    
    for (var entry : Memory.entrySet()) {
    Memory1.append(entry.getKey() + " / " + entry.getValue() + "\n");
    }
}
    else{
             Memory1.append("...");
            
          }
}



String Assembly_CodeCpy; int Program_CounterCpy;
public Viewer(String Assembly_Code, int Program_Counter)   {
      initComponents(); // initializes the GUI must always be at top
      Assembly_CodeCpy = Assembly_Code;
      Program_CounterCpy = Program_Counter;
      counter = 0;
      PrintRegisters();
      PrintMemory();
      AssemblyCode.setText(Assembly_Code); // Set the Assmblycode Compoent to the code entered in the Index
      Instruction = Assembly_Code.split("\n"); // Splits the Assembly Code instructions and puts in an array
      ProgressBar.setMaximum(Instruction.length); // sets the maximum value of the progressbar component to the length of the Instruction Array 
      Complete.setVisible(false);// need to know how to make the progressBar contain Text

    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        NextBttn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        AssemblyCode = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CurrentInstruction = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ProgressBar = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        Registers = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Memory1 = new javax.swing.JTextArea();
        Complete = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Registers ");

        jPanel1.setBackground(new java.awt.Color(48, 52, 112));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("RISC-V SIMULATOR");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/10872782.png"))); // NOI18N

        NextBttn.setBackground(new java.awt.Color(204, 204, 204));
        NextBttn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NextBttn.setForeground(new java.awt.Color(0, 0, 0));
        NextBttn.setText("Next Instruction");
        NextBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextBttnActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Restart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NextBttn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NextBttn)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Memory");

        AssemblyCode.setEditable(false);
        AssemblyCode.setColumns(20);
        AssemblyCode.setRows(5);
        jScrollPane3.setViewportView(AssemblyCode);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Assembly Code");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Program Counter :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Current Instruction");

        CurrentInstruction.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Progress");

        ProgressBar.setBackground(new java.awt.Color(255, 153, 0));
        ProgressBar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ProgressBar.setForeground(new java.awt.Color(0, 0, 0));

        Registers.setColumns(20);
        Registers.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Registers.setRows(5);
        jScrollPane1.setViewportView(Registers);

        Memory1.setColumns(20);
        Memory1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Memory1.setRows(5);
        jScrollPane2.setViewportView(Memory1);

        Complete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Complete.setForeground(new java.awt.Color(0, 102, 0));
        Complete.setText("SIMULATOR COMPLETE!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CurrentInstruction)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Complete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addComponent(CurrentInstruction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Complete))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NextBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextBttnActionPerformed
        // TODO add your handling code here:
        System.out.println("Instruction Length : "+Instruction.length);
        if(counter==Instruction.length-1){
        NextBttn.setVisible(false);
        Complete.setVisible(true);
        }
        CurrentInstruction.setText(Instruction[counter]);
        System.out.println("Instruction : "+Instruction[counter]); //Test
        System.out.println("Counter : "+ counter); //Test
        ProcessInstruction(Instruction[counter]);
        PrintRegisters();
        PrintMemory();
        ProgressBar.setValue(counter+1);
        
        counter++;
        
        
    }//GEN-LAST:event_NextBttnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Index i = new Index();
        i.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Viewer v = new Viewer(Assembly_CodeCpy, Program_CounterCpy) {
          
        };
        v.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Viewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Viewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Viewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Viewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AssemblyCode;
    private javax.swing.JLabel Complete;
    private javax.swing.JTextField CurrentInstruction;
    private javax.swing.JTextArea Memory1;
    private javax.swing.JButton NextBttn;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JTextArea Registers;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}

