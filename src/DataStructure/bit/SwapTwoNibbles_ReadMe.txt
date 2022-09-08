https://www.geeksforgeeks.org/swap-two-nibbles-byte/
Swap two nibbles in a byte


A nibble is a 4-bit aggregation
There are two nibbles in a byte
Given a byte, swap the two nibbles in it.

For example 100 is be represented as 01100100 in a byte (or 8 bits).
The two nibbles are (0110) and (0100).
If we swap the two nibbles, we get 01000110 which is 70 in decimal.

Approach:
Step 1: Take & of 00001111 with number to get right nibble i.e. 0b00001111 & N

Step 2: Take & of 11110000 with number to get left nibble i.e. 0b11110000 & N

Step 3: Left shift the right nibble obtained in step 1 by 4 positions to get it as left nibble in the final answer i.e. <<4

Step 4: Right shift the left nibble obtained in step 2 by 4 positions to get it as right nibble in final answer >>4

Step 5: Do or( | ) operation between values obtained in step 3 & 4 to get the answer