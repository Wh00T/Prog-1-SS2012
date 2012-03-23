import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
 
	static String SPIELER;
 
	public static void main(String[] args) throws IOException {
		int columns, columns2, rows, counter = 0;
		String player1;
		String player2;
		char sign;
		char[][] gameboard;
		String columnsS = null, rowsS = null;
 
		player1 = input("Name von Spieler A: ");
 
		do {
			player2 = input("Name von Spieler B: ");
		} while (player1.equals(player2));
 
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			System.out.print("Bitte geben Sie die Höhe des Spielfeldes ein: ");
			rowsS = console.readLine();
			try {
				rows = Integer.parseInt(rowsS);
			} catch (Exception E) {
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
		
		while (true) {
			System.out.print("Bitte geben Sie die Breite des Spielfeldes ein: ");
			columnsS = console.readLine();
			try {
				columns = Integer.parseInt(columnsS);
			} catch (Exception E) {
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
 
		gameboard = new char[rows][columns];
 
		while (counter < (columns * rows)) {
			sign = (counter % 2 == 0) ? 'o' : '+';
			SPIELER = (counter % 2 == 0) ? player1 : player2;
			Gameboardpainting.showgameboard(gameboard);
			while (true) {
				System.out.print(SPIELER + " ist am Zug. Bitte geben Sie die Spalte ein: ");
				columnsS = console.readLine();
				try {
					columns2 = Integer.parseInt(columnsS);
				} catch (Exception E) {
					System.out.println("Bitte geben Sie eine Zahl ein!");
					continue;
				}
				break;
			}
			counter++;
			setzeFeld(gameboard, columns2, sign);
		}
		Gameboardpainting.showgameboard(gameboard);
		System.err.println("Unentschieden!");
	}

	static String input(String text) throws IOException {
		System.out.print(text);
		BufferedReader input = new BufferedReader(new InputStreamReader( System.in));
		String input1 = input.readLine();
		return input1;
	}

	static void setzeFeld(char[][] gameboard, int column2, char sign) {
		column2--; //Array 0
		int poscheck;
		if (gameboard[0][column2] != '\0') {
			System.err.println("Die Reihe ist bereits voll. Bitte eine andere Reihe wählen.");
		} else {
			for (int i = 0; i < gameboard.length; i++) { //Iteriere durch die Zeilen
				if (i + 1 == gameboard.length) {
					// Nach der letzten Zeile kommt nichts mehr..
					// also darf in das aktuelle Kästchen geschrieben werden, obwohl im
					// nächsten nichts steht
					poscheck = i;
					if (gameboard[poscheck][column2] == '\0') {
						gameboard[i][column2] = sign;
						if (Testing.IsGameOver(gameboard, i, column2, sign)) {
							Gameboardpainting.showgameboard(gameboard);
							System.out.println(SPIELER + " mit " + sign + " hat gewonnen");
							System.exit(0);
						}
						break;
					}
 
				} else {
					//Überprüfe immer das folgende Feld
					poscheck = i + 1;
					if (gameboard[poscheck][column2] != '\0') {
						gameboard[i][column2] = sign;
						if (Testing.IsGameOver(gameboard, i, column2, sign)) {
							Gameboardpainting.showgameboard(gameboard);
							System.out.println(SPIELER + " mit " + sign + " hat gewonnen");
							System.exit(0);
						}
						break;
					}
				}
			}
		}
	}
}