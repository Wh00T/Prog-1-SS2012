
public class Player {

	private static String CurrentPlayer;
	private static char CurrentSign;
	private static String player1;
	private static String player2;
	private static int counter = 0;

	public static String getPlayer1() {
		return player1;
	}

	public static void setPlayer1() {
		System.out.println("Bitte geben Sie den ersten Spielernamen ein: ");
		Player.player1 = Input.input();
	}

	public static String getPlayer2() {
		return player2;
	}

	public static void setPlayer2() {
		if (Gamemode.getGamemode() == "MP") {
			while (true) {
				System.out.println("Bitte geben Sie den zweiten Spielernamen ein: ");
				Player.player2 = Input.input();
				if (Player.getPlayer1().equals(Player.getPlayer2())) {
					System.err.println("Bitte geben Sie einen anderen Namen ein.");
				} else {
					break;
				}
			}
		}
		if (Gamemode.getGamemode() == "SP") {
			Player.player2 = "RandomRobot";
		}
	}

	public static String getCurrentPlayer() {
		return CurrentPlayer;
	}

	public static void setCurrentPlayer() {
		if (counter < (Gameboard.getColumns() * Gameboard.getRows())) {
			CurrentPlayer = ((counter % 2 == 0) ? Player.getPlayer1() : Player.getPlayer2());
			Gameboard.showgameboard(Gameboard.getGameboard());
			System.out.print(getCurrentPlayer() + " ist mit '" + CurrentSign + "' am Zug. ");
			counter++;
		} else {
			Gameboard.showgameboard(Gameboard.getGameboard());
//			System.err.println("Unentschieden!");
		}
	}

	public static char getCurrentSign() {
		return CurrentSign;
	}

	public static void setCurrentSign() {
		CurrentSign = (counter % 2 == 0) ? 'o' : '+';
	}
}