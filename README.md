# CS136 Recursion Lab

## Counting Cannonball 
Spherical objects, such as cannonballs, can be stacked to form a pyramid with one cannonball at the top, sitting on top of a square composed of four cannonballs, sitting on top of a square composed of nine cannonballs, sitting on top of a square composed of sixteen cannonballs, and so forth. We will write a recursive method countCannonballs that takes as its argument the height of a pyramid of cannonballs and returns the number of cannonballs it contains.

## Palindromes
Write a recursive method isPalindrome that takes a string and returns true if it is the same when read forwards or backwards.

## Balancing Parentheses
In the syntax of most programming languages, there are characters that occur only in nested pairs, called bracketing operators. Java, for example, has these bracketing operators (i.e (), [], {})
In a properly formed program, these characters will be properly "nested" and "matched". To determine whether this condition holds for a particular program, you can ignore all the other characters and look simply at the pattern formed by the parentheses, brackets, and braces.
We will write a recursive method that returns true if the bracketing operators in str are balanced, which means that they are correctly nested and matched. If the string is not balanced, the method returns false.

## Subsequences
We will write a recursive method that prints out all subsequences of letters in str. In our implementation, we write a helper method called subseqHelper(str, ""). We use the variable soFar to keep track of the characters that currently in the subsequence we are building.

## Print In Binary
Although we are used to referring to numbers in decimal computers represent integers as sequences of bits. A bit is a single digit in the binary number system and can therefore have only the value 0 or 1.
We will write a recursive method that prints the binary representation for a given integer.

## Extending Subset Sum
Given a set of integers and a target number, your goal is to find a subset of those numbers that sum to the target number. For example, given the set {3, 7, 1, 8, -3} and the target sum 4, the subset {3, 1} sums to 4. On the other hand, if the target sum were 2, we have a problem: there is no subset that sums to 2.

We will write a recursive method that returns the number of subsets that sum to our target number
