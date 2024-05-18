package game;

public class Dice {
	
	/*
	 * getDice method:
	 * 
	 * This method generates two random numbers between 1 and 6, then adds them
	 * to get a final roll. Next it returns the value to be displayed on the
	 * screen.
	 */
	public static int getDice(int diceRoll, int diceRoll2) {// start getDies
															// class
		diceRoll = (int) (Math.random() * 6) + 1; // creates dice roll number 1
		diceRoll2 = (int) (Math.random() * 6) + 1; // creates dice roll number 2
		System.out.println("diceRoll : " + diceRoll + " diceRoll2 : " + diceRoll2);
		int move = diceRoll + diceRoll2; // adds the two dice rolls to get a final move
		return move; // return parameter move: this will give the final dice roll back to startGame
	}// end getDice class

	public static void main(String[] args) {
		System.out.println("Dice : " + getDice(10, 11));

	}

}
