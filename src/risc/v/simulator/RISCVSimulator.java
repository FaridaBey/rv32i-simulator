/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package risc.v.simulator;

import java.util.*;

/**
 *
 * @author lenovo
 */

public class RISCVSimulator {
    
public static Map <Integer, Integer> Memory = new HashMap<>(); // Memory
public static ArrayList<Integer> reg = new ArrayList<>(Collections.nCopies(32, 0));




//
    /**
     * @param args the command line arguments
     */
//Printing

//Parsing Functions
   public  String extractOpcode(String instruction) {
        // Splitting the instruction by whitespace or comma
        String[] parts = instruction.split("[,\\s]+");
        // Returning the first part, which is the opcode
        return parts[0];
    }
//Instruction Functions 
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
        reg.add(regd, imm);
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
        System.out.println(Memory);
    }
   
   // 17
    public  void SB (String instr){
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
        System.out.println(Memory);
    }
   
   // 18
    public  void SW (String instr){
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
        System.out.println(Memory);
    }
    
   // 19
    public  void addi (String instr){
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
        reg.add(rd_num_int,reg.get(rs_num_int)+imm);
               
        for(int i = 0; i<32;i++){    // populate Registers  
        
        System.out.println("ADDI FUNCTION OUTPUT : "+"x" + i + ": " + reg.get(i)); //Test
        }
            System.out.println("------------------------------------------------------"); //Test
        
    }
    
    
    
//Processing Instructions
public  void ProcessInstruction(String instruction){

String opcode = extractOpcode(instruction);

System.out.println("OpCode : "+ opcode); // Test

switch(opcode){
    //16
    case "sb":{
        SB(instruction);
    }
    //17
    case "sh":{
        SH(instruction);
    }
    //18
    case "sw":{
        SW(instruction);
    }
    //19
    case "addi":{
        addi(instruction);
    }
    case "lui":{
        lui(instruction);
    }


}


}

 
    
    public static void main(String[] args) {
        /*
        // creating a string array for the registers 
        // all elements are automatically initialized to zero

        // need to find a way to make x0 constant at zero 
        
        
        // getting initial data from the user
        // getting the program starting address (program counter)
        int program_counter;
        System.out.println("Enter starting address of the program: ");
        Scanner s = new Scanner(System.in);
        program_counter = s.nextInt();
        System.out.println("Program counter is at " + program_counter+ "\n");// should be printed after each line of assembly code
        
        
        // getting assembly code from the user
        String asembly_line;
        System.out.println("Enter assembly code (1 line only): ");
        s = new Scanner(System.in);
        asembly_line = s.nextLine();
        
        // spliting the line of assembly code into words using spaces or commas
        String[] assembly_line_split = asembly_line.split("[\\s,]+");
        
     
        //giant swich-case statement to know what to do
        switch(assembly_line_split[0]) {
            // 19- addi
            case "addi" :
                
                // getting the destination register number
                String rd_num_string = assembly_line_split[1].substring(1);
                int rd_num_int = Integer.parseInt(rd_num_string);
                
                // getting the source register number
                String rs_num_string = assembly_line_split[2].substring(1);
                int rs_num_int = Integer.parseInt(rs_num_string);
                
                //getting the immidate value 
                int imm = Integer.parseInt(assembly_line_split[3]);
                
                // doing the operation and saving in the reg 
               // reg[rd_num_int] = reg[rd_num_int] + imm;
                
                
                break;
                
            default:
  
        }
        
        
        
        // function that prints all the registers 
    //   for (int i = 0; i < reg.length; i++) {
  //           System.out.println("x" + i+ " : " + reg[i]);
   //     }
        
   

*/
    }
    
    
    
}
