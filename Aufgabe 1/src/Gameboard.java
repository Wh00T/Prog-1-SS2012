
public class Gameboard {
	
	private static char[][] gameboard;
	private static int columns;
	private static int rows;
	
	public static int getRows() {
		return rows;
	}

	public static void setRows() {
		while (true) {
			System.out.println("Bitte geben Sie die Höhe des Spielfeldes ein: ");
			try {
				rows = Integer.parseInt(Input.input());
			} catch (NumberFormatException E) {
				System.out.println("Bitte geben Sie eine Zahl ein!");
				continue;
			}
			if (rows < 4) {
				System.out.println("Das Spielfeld muss mindestens 4 Felder hoch sein.");
				continue;
			}
			if (rows > 9) {
				System.out.println("Das Spielfeld darf maximal 9 Felder hoch sein.");
				continue;
			}
			break;
		}
	}

	public static int getColumns() {
		return columns;
	}

	public static void setColumns() {
		while (true) {
			System.out.println("Bitte geben Sie die Breite des Spielfeldes ein: ");
			try {
				columns = Integer.parseInt(Input.input());
			} catch (NumberFormatException E) {
				System.out.println("Bitte geben Sie eine Zahl ein!");
				continue;
			}
			if (columns < 4) {
				System.out.println("Das Spielfeld muss mindestens 4 Felder breit sein.");
				continue;
			}
			if (columns > 9) {
				System.out.println("Das Spielfeld darf maximal 9 Felder breit sein.");
				continue;
			}
			break;
		}
	}

	public static char[][] getGameboard() {
		return gameboard;
	}

	public static void setGameboard() {
		gameboard = new char[rows][columns];
	}

	public static void showgameboard(char[][] gameboard) {
		StringBuffer Geruest = new StringBuffer(); 
		StringBuffer row_start = new StringBuffer(" ");
		StringBuffer row_divide = new StringBuffer("|");
		StringBuffer row_end = new StringBuffer("-");
 
		if (gameboard[0].length > 9) {
			for (int i = 1; i <= gameboard[0].length; i++)
				row_start.append((i / 10 == 0) ? " " : i / 10).append(" ");
			row_start.append("\n ");
		}
		for (int i = 1; i <= gameboard[0].length; i++) {
			row_start.append(i % 10).append(" ");
			row_divide.append((i==gameboard[0].length)? "-|" : "--");
			row_end.append("--");
		}
		System.out.println(row_start);
		System.out.println(row_divide);
 
		for (char[] arrZeile : gameboard) {
			for (char arrSpalte : arrZeile) {
				Geruest.append("|");
				Geruest.append((arrSpalte == '\0') ? ' ' : arrSpalte);
			}
			Geruest.append("|\n");
		}
		Geruest.append(row_end).append("\n");
		System.out.println(Geruest);
	}
}