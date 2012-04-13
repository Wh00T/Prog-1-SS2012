//import java.util.Random;

public class Ruleset {
	
	private static int counter;
	private static char[][] gameboard = Gameboard.getGameboard();

	public static boolean IsGameOverNoWinner() throws Exception {
		counter++;
		if (counter < Gameboard.getColumns() * Gameboard.getRows()) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean IsGameOver(int column, int row) throws Exception {
		char sign = Player.getCurrentSign();
		boolean b1 = GameIsOver_row(gameboard, column, row, sign);
		boolean b2 = GameIsOver_column(gameboard, column, row, sign);
		boolean b3 = GameIsOver_straight1(gameboard, column, row, sign);
		boolean b4 = GameIsOver_straight2(gameboard, column, row, sign);

		return (b1 || b2 || b3 || b4);
	}

	private static boolean GameIsOver_row(char[][] gameboard, int column,
			int row, char sign) throws Exception {
		// nach links
		int go = row - 1; // mit dem Punkt links neben dem gesetzten beginnen
		int i = 1; // der gesetzte Punkt = 1 Treffer
		while (go >= 0) {
			if (gameboard[column][go] != sign)
				break;
			go--;
			i++;
		}

		// nach rechts
		go = row + 1;
		while (go < gameboard.length) {
			if (gameboard[column][go] != sign)
				break;
			go++;
			i++;
		}
		return (i > 3);
	}

	private static boolean GameIsOver_column(char[][] gameboard, int column,
			int row, char sign) throws Exception {
		// nach oben
		int go = column - 1;
		int i = 1;
		while (go >= 0) {
			if (gameboard[go][row] != sign)
				break;
			go--;
			i++;
		}

		// nach unten
		go = column + 1;
		while (go < gameboard.length) {
			if (gameboard[go][row] != sign)
				break;
			go++;
			i++;
		}
		return (i > 3);
	}

	private static boolean GameIsOver_straight1(char[][] gameboard, int column,
			int row, char sign) throws Exception {
		// nach links oben
		int go = row - 1;
		int go2 = column - 1;
		int i = 1;
		while (go >= 0 && go2 >= 0) {
			if (gameboard[go2][go] != sign)
				break;
			go--;
			go2--;
			i++;
		}

		// nach rechts unten
		go = row + 1;
		go2 = column + 1;
		while (go < gameboard[0].length && go2 < gameboard.length) {
			if (gameboard[go2][go] != sign)
				break;
			go++;
			go2++;
			i++;
		}

		return (i > 3);
	}

	private static boolean GameIsOver_straight2(char[][] gameboard, int column,
			int row, char sign) throws Exception {
		// nach links unten
		int go = row - 1;
		int go2 = column + 1;
		int i = 1;
		while (go >= 0 && go2 < gameboard.length) {
			if (gameboard[go2][go] != sign)
				break;
			go--;
			go2++;
			i++;
		}

		// nach rechts oben
		go = row + 1;
		go2 = column - 1;
		while (go < gameboard[0].length && go2 >= 0) {
			if (gameboard[go2][go] != sign)
				break;
			go++;
			go2--;
			i++;
		}
		return (i > 3);
	}
}
