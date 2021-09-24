/*
* Recursion.java
*
* Starter code for the recursion lab.
*
*/
import structure5.*;

public class Recursion {

	/***** Warmup 0.1 *********************************************/
	public static int digitSum(int n){
		if (String.valueOf(n).length() <= 1) {
			return n;
		} else {
			return ((n % 10) + digitSum(n/10));
		}
	}

	/***** Warmup 0.2 ********************************************/

	// Note: Warmup questions are not graded, but you may wish to
	// complete & test this method since the last question builds
	// upon it.

	/**
	* Given a set of integers and a target number, determines
	* whethere there is a subset of those numbers that sum to the
	* target number.
	*
	* @param setOfNums a set of numbers that may appear in the subset
	* @param targetSum the target value for the subset
	* @return true if some subset of numbers in setOfNums sums to targetSum
	*/
	public static boolean canMakeSum(int[] setOfNums, int targetSum) {
		//if (setOfNums.length < 1) {
		//return false;
		//} else {
		//	if canMakeSum(setOfNums, targetSum) == false {
		//		return canMakesSum(setOfNums - 1, targetSum);
		//	} else {
		return true;
		//	}
		//	}
	}


	/*****  1  ***************************************************/

	/**
	* Return number of cannoballs in pyramid with the given `height`.
	*
	* @param height the height of the cannonball tower
	* @return the number of cannonballs in the entire tower
	* @pre height must be non-negative int
	* @post
	*/
	public static int countCannonballs(int height) {
		Assert.pre(height >= 0, "Please provide a non-negative height");
		// here we assume there is no pyramid, in which case there are no cannonballs
		if (height == 0) {
			return 0;
		} else {
			return height * height + countCannonballs(height - 1);
			// countCannonballs returns an int, which can be added to height * height
		}
	}

	/*****  2  ***************************************************/

	/**
	* A method that determines if a string reads the same forwards
	* and backwards.
	*
	* @param str the string to check
	* @return true if `str` is a palindrome.
	* @pre str must be of type String
	*/
	public static boolean isPalindrome(String str) {
		Assert.pre(str.length() >= 0, "Please prove a valid string");
		//we assume that the empty string is a palindrome
		//we assume that captialization matters, "Mom" is not a palindrome, "mOm" is
		if (str.length() == 0 || str.length() == 1) { // O(1)
			// empty strings and 1 letter strings are palindromes
			return true; // O(1)
		}
		if (str.charAt(0) == str.charAt(str.length()-1)) { //O(1)
			// verify the first and last letters are equal
			return isPalindrome(str.substring(1, str.length()-1)); // O(n)
			// remove the first and last letters of the string and cut down workload
		}
		return false; // O(1)
		// if method does not pass above conditional statements, str is not palindrome
	}


	/*****  3  ***************************************************/

	/**
	* Checks whether `str` is a string of properly nested and matched
	* parens, brackets, and braces.
	*
	* @param str a string of parens, brackets, and braces
	* @return true if str is properly nested and matched
	* @pre str contains at least one of the following: {}, [], () and cannot contain other chars
	*/
	public static boolean isBalanced(String str) {
		if (str.equals("")) { //O(1)
			return true; // O(1)
		}
		int pIndex = str.indexOf("()"); // O(n)
		int cIndex = str.indexOf("{}"); // O(n)
		int sIndex = str.indexOf("[]"); // O(n)
		// create variables locating indices of braces
		if (pIndex != -1) { // O(1)
			// str contains ()
			return isBalanced(str.substring(0, pIndex) + str.substring(pIndex + 2)); // O(n^2)
		} else if (cIndex != -1) { // O(1)
			// str contains {}
			return isBalanced(str.substring(0, cIndex) + str.substring(cIndex + 2)); // O(n^2)
		} else if (sIndex != -1) { // O(1)
			// str contains []
			return isBalanced(str.substring(0, sIndex) + str.substring(sIndex + 2)); // O(n^2)
		}
		return false;
	}
	/*****  4  ***************************************************/

	/**
	* A method to print all subsequences of str (order does not matter).
	*
	* @param str string to print all subsequences of
	* @pre length of string greater than or equal to 0
	*/
	public static void subsequences(String str) {
		Assert.pre(str.length() >= 0, "Please provide a valid string");
		subsequenceHelper(str, ""); // 0(1)
	}

	/**
	* Helper method for subsequences()
	* `soFar` keeps track of the characters currently in the substring
	*   being built
	*/
	protected static void subsequenceHelper(String str, String soFar) {
		if (str.length() == 0) { // O(1)
			System.out.println(soFar); // O(1)
		} else {
			//here, we find all sequences containing the first character
			subsequenceHelper(str.substring(1), soFar + str.charAt(0)); // O(n)
			// here, we find all sequences not containing the first character in str
			subsequenceHelper(str.substring(1), soFar); // O(n)
		}
	}
	/*****  5  ***************************************************/

	/**
	* A method to print the binary digits of a number.
	*
	* @param number the number to print in binary
	* @pre number must be non-negative
	*/
	public static void printInBinary(int number) {
		Assert.pre(number >= 0, "Please provide a non-negative int");
		//base case 1
		if (number == 0) { // O(1)
			//0 has a binary value of 0, so we print 0
			System.out.print(0); // O(1)
			//base case 2
		} else if (number == 1) { // O(1)
			//1 has a binary value of 1, so we print 1
			System.out.print(1); // O(1)
		} else {
			printInBinary(number/2); // O(n)
			System.out.print(number % 2); // O(1)
		}
	}


	/*****  6a  ***************************************************/

	public static boolean subsetHelper(int[] nums, int targetSum, int index){
		if (index == nums.length) { // O(1)
			// we arrive at end of all possible combinations
			if (targetSum == 0) { // O(1)
				// we found a subsetSum
				return true; // O(1)
			} else { // O(1)
				// we did not find a subsetSum
				return false; //O(1)
			}
			//if we use the element at the index, then we print out the element, and return true
		} else if (subsetHelper(nums, (targetSum - nums[index]), index + 1)) { // O(n)
			// in this branch, we use nums[index] in our sum
			System.out.print(nums[index] + " "); // O(1)
			return true; // O(1)
			//if we dont use the element at the index, then we move on with the targetSum, but increment the index
		} else { // O(1)
			// in this branch, we check other sums using nums[index + 1]
			return subsetHelper(nums, targetSum, index + 1); //O(n)
		}
	}

	/**
	* Return whether a subset of the numbers in nums add up to sum,
	* and print them out.
	*
	* @pre nums must only contain type int
	* @post if subsetHelper returns true, print ONE possible subset. Otherwise,
	* return false and don't print
	* Big-O runtime: 2^n
	*/
	public static boolean printSubsetSum(int[] nums, int targetSum) {
		Assert.pre(targetSum >= 0, "Please provide a non-negative target");
		return subsetHelper(nums, targetSum, 0);
	}

	/*****  6b  ***************************************************/


	public static int countSubsetHelper(int[] nums, int targetSum, int index) {
		//we check if we have used all of the elements in the index
		if (index == nums.length) {
			//we check if there is a solution based on if targetSum has reached 0
			if (targetSum == 0) {
				//if there is a solution we return 1
				return 1;
			} else {
				//if there is no solution, we return 0
				return 0;
			}
		} else {
			//we just return the sum of our recursive calls on the method
			//our first recursive call is if we use the element at the given index
			//our second recurive call is when we do not use the elemet at the given index
			return countSubsetHelper(nums, (targetSum - nums[index]), index + 1)
			+ countSubsetHelper(nums, targetSum, index + 1);
		}
	}

	/**
	* return the number of different ways elements in nums can be
	* added together to equal sum (you do not need to print them all).
	*
	* @pre targetSum must be non-negative
	* @post returns a non-negative integer
	* Big-O runtime: n^2
	*/
	public static int countSubsetSumSolutions(int[] nums, int targetSum) {
		Assert.pre(targetSum >= 0, "Please provide a non-negative targetSum");
		return countSubsetHelper(nums, targetSum, 0);
	}


	/***********************************************************/

	/**
	* Add testing code to main to demonstrate that each of your
	* recursive methods works properly.
	*
	* Think about the so-called corner cases!
	*
	* Remember the informal contract we are making: as long as all
	* predconditions are met, a method should return with all
	* postconditions met.
	*/

	protected static void testCannonballs() {
		System.out.println("Testing cannonballs: ....");
		System.out.println(countCannonballs(3));
		System.out.println(countCannonballs(10));
	}

	protected static void testPalindrome() {
		System.out.println("Testing isPalindrome: ....");
		System.out.println(isPalindrome("mom"));
		System.out.println(isPalindrome("deeded"));
		System.out.println(isPalindrome("ablewasIereIsawelba"));
	}

	protected static void testBalanced() {
		System.out.println("Testing isBalanced: ....");
		System.out.println(isBalanced("[{[()()]}]"));
		System.out.println(isBalanced("[{[()()]}][{[()()]}]"));
		System.out.println(isBalanced("[{[()()]}{]{[()()]}]"));
	}

	protected static void testSubsequence() {
		System.out.println("Testing subsequences: ....");
		subsequences("abc");
		System.out.println();
		subsequences("CSCI136");
		System.out.println();
		subsequences("a");
		System.out.println();
		subsequences("");
		System.out.println();
	}

	protected static void testBinary() {
		System.out.println("Testing printInBinary: ....");
		printInBinary(0);
		System.out.println();
		printInBinary(30);
		System.out.println();
		printInBinary(1);
		System.out.println();
		printInBinary(110);
		System.out.println();
		printInBinary(2048);
		System.out.println();
		printInBinary(43);
		System.out.println();
	}

	protected static void testCanMakeSum() {
		System.out.println("Testing canMakeSum: ....");
		int[] numSet = {2, 5, 7, 12, 16, 21, 30};
		System.out.println(canMakeSum(numSet, 21));
		System.out.println(canMakeSum(numSet, 22));
		System.out.println(canMakeSum(numSet, 3));
		System.out.println(canMakeSum(numSet, 30));
	}

	protected static void testPrintSubsetSum() {
		System.out.println("Testing printSubsetSum: ....");
		int[] numSet = {2, 5, 7, 12, 16, 21, 30};
		System.out.println(printSubsetSum(numSet, 21));
		System.out.println(printSubsetSum(numSet, 22));
		System.out.println(printSubsetSum(numSet, 3));
		System.out.println(printSubsetSum(numSet, 30));
	}

	protected static void testCountSubsetSum() {
		System.out.println("Testing countSubsetSumSolutions: ....");
		int[] numSet = {2, 5, 7, 12, 16, 21, 30};
		System.out.println(countSubsetSumSolutions(numSet, 21));
		System.out.println(countSubsetSumSolutions(numSet, 22));
		System.out.println(countSubsetSumSolutions(numSet, 3));
		System.out.println(countSubsetSumSolutions(numSet, 30));
	}

	/**
	* Main method that calls testing methods to verify
	* the functionality of each lab exercise.
	*
	* Please supplement the testing code with additional
	* correctness tests as needed.
	*/
	public static void main(String[] args) {
		testCannonballs();
		testPalindrome();
		testBalanced();
		testSubsequence();
		testBinary();
		testCanMakeSum();
		testPrintSubsetSum();
		testCountSubsetSum();
	}
}
