import java.util.Scanner; //imports scanner module

public class LastBiscuit {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		final int PILE1VAL = 6;
		final int PILE2VAL = 8;

		int pile1 = PILE1VAL;
		int pile2 = PILE2VAL;

		int playerTurn = 0;

		String choice;


		boolean game = true;

		while (game) {
			playerTurn++;

			if (playerTurn % 2 == 0) {
				playerTurn = 2;

			} else {
				playerTurn = 1;
			}

			choice = "";

			System.out.println("Biscuits Left - Barrel 1: " + pile1);
			System.out.println("Biscuits Left - Barrel 2: " + pile2);
			System.out.println("Player Turn: " + playerTurn);

			

			boolean choiceValid = false;
			outer:
			while (!choiceValid) {
				do {
					System.out.print("Choose a barrel: "
						+ "barrel1 (one), barrel2 (two), or both "
						+ "(both), or skip turn (skip)? ");
					choice = in.next();
				} while (!choice.equals("one")
						&&!choice.equals("two")
						&&!choice.equals("both")
						&&!choice.equals("skip"));
				
				int biscuit = 0;

				switch (choice) {
				case "one":
					System.out.print("How many biscuits are you "
							+ "taking? ");
					do {
						if (in.hasNextInt()) {
							biscuit = in.nextInt();
						} else {
							System.out.print("Please input an "
									+ "integer: ");
							in.next();
						
						}
						if (biscuit<0||biscuit>pile1) {
							System.out.println("Sorry, "
								+"that's not a legal number "
								+"of biscuits for that/those "
								+"barrel(s)");
							continue outer;
						} 

					} while (biscuit<= 0||biscuit>pile1);

					pile1 = pile1 - biscuit;
					choiceValid = true;
					break;

				case "two":
					System.out.print("How many biscuits"
							+ " are you taking? ");
					do {
						
						if (in.hasNextInt()) {
							biscuit = in.nextInt();
						} else {
							System.out.print("Please input "
									+ "an integer: ");
							in.next();
						}
						if (biscuit<0||biscuit>pile2) {
							System.out.println("Sorry, "
								+"that's not a legal number "
								+"of biscuits for that/those "
								+"barrel(s)");
							continue outer;
						} 
						
					} while (biscuit<=0||biscuit>pile2);
					pile2 = pile2 - biscuit;
					choiceValid = true;
					break;

				case "both":
					System.out.print("How many biscuits"
							+ " are you taking? ");
					do {
						
						if (in.hasNextInt()) {
							biscuit = in.nextInt();
						} else {
							System.out.print("Please input an "
									+ "integer: ");
							in.next();
						}
						if (biscuit<0||biscuit>pile1||biscuit>pile2) {
							System.out.println("Sorry, "
								+"that's not a legal number "
								+"of biscuits for that/those "
								+"barrel(s)");
							continue outer;
						} 
						
					} while (biscuit<= 0||biscuit>pile1||biscuit>pile2);
					pile1 = pile1 - biscuit;
					pile2 = pile2 - biscuit;
					choiceValid = true;
					break;

				case "skip":
					System.out.println("You have chosen to skip");
					break;

				default:
					System.out.print("Choose a barrel: "
							+ "barrel1 (one), barrel2 (two), or both "
							+ "(both), or skip turn (skip)? ");
					continue;
				}

			} 

			if (pile1 + pile2 == 0) {
				break;
			}
		}

		System.out.println("Biscuits Left - Barrel 1: " + pile1);
		System.out.println("Biscuits Left - Barrel 2: " + pile2);
		System.out.println("Winner is player " + playerTurn);

	}
}
