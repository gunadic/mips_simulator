mips_simulator
==============

a mips simulator built from first-principles using java


Description: This is a program designed to emulate a single-cycle MIPS processor. It is built from first principles, meaning that and-gate and or-gate objects are used.

Running the Program:
-The main wanted for this program is located in FrontEnd.Java. FrontEnd.java is located within the src file inside the datapath package. Upon starting up the program, it will query the user for a file. An example file can be seen in the file. It is named Source.txt. This is case sensitive.

What Works:
  ⁃	add, sub, and, or, slt, slti, addi, sw, lw
What Doesn't Work:
	⁃	beq,  j
A note on formatting Source.txt – The simulator only works when instructions are entered in the following pattern:

addi $s1,$t2,4
sw $s1,4($t2)


Note that there are no spaces separating rs, rt, and immediate. Also note that there is no following semicolon. Register numbers and names are not interchangeable.
