import java.util.Random;

public class setSquare {

	private static char[][] gameboard = Gameboard.getGameboard();

	public static void placeSquare() throws Exception {
		while (true) {
			int column = 0;
			if (Gamemode.getGamemode().equals("MP")) {
				while (true) {
					System.out.println("Bitte geben Sie die Spalte ein: ");
					try {
						column = Integer.parseInt(Input.input());
						if (column > Gameboard.getColumns()) {
							System.out
									.println("Diese Spalte existiert nicht. Bitte wählen Sie eine Spalte bis maximal "
											+ Gameboard.getColumns() + ".");
							continue;
						}
					} catch (Exception E) {
						System.out.println("Bitte geben Sie eine Zahl ein!");
						continue;
					}
					break;
				}
			}
			if (Gamemode.getGamemode().equals("SP")) {
				while (true) {
					if (Player.getCurrentPlayer() == Player.getPlayer1()) {
						System.out.println("Bitte geben Sie die Spalte ein: ");
						try {
							column = Integer.parseInt(Input.input());
							if (column > Gameboard.getColumns()) {
								System.out
										.println("Diese Spalte existiert nicht. Bitte wählen Sie eine Spalte bis maximal "
												+ Gameboard.getColumns() + ".");
								continue;
							}
						} catch (Exception E) {
							System.out
									.println("Bitte geben Sie eine Zahl ein!");
							continue;
						}
						break;
					}
					if (Player.getCurrentPlayer() == Player.getPlayer2()) {
						// column = random blabla
						Random r = new Random();
						column = (r.nextInt(Gameboard.getColumns() - 1) + 1);
						// -1 verhindert ArrayOutOfBounds, +1 wandelt es ins
						// menschliche Format
						// System.out.println("Der Computer setzt in die Spalte "
						// + column + ".");
						break;
					}
				}
			}
			column--; // Array 0
			int poscheck;
			if (gameboard[0][column] != '\0') {
				if (Player.getCurrentPlayer() == Player.getPlayer1()) {
					System.err
							.println("Die Reihe ist bereits voll. Bitte eine andere Reihe wählen.");
					continue;
				} else if (Gamemode.getGamemode().equals("MP")) {
					System.err
							.println("Die Reihe ist bereits voll. Bitte eine andere Reihe wählen.");
					continue;
				} else if (Gamemode.getGamemode().equals("SP")) {
					continue;
				}
			} else {
				if (Player.getCurrentPlayer() == Player.getPlayer2()) {
					if (Gamemode.getGamemode().equals("SP")) {
						System.out.println("Der Computer setzt in die Spalte "
								+ (column + 1) + ".");
					}
				}
				for (int i = 0; i < gameboard.length; i++) { // Iteriere durch
																// die Zeilen
					if (i + 1 == gameboard.length) {
						// Nach der letzten Zeile kommt nichts mehr,
						// also darf in das aktuelle Kästchen geschrieben
						// werden, obwohl im
						// nächsten nichts steht
						poscheck = i;
						if (gameboard[poscheck][column] == '\0') {
							gameboard[i][column] = Player.getCurrentSign();
							if (Ruleset.IsGameOver(i, column)) {
								Gameboard.showgameboard(gameboard);
								System.out.println(Player.getCurrentPlayer()
										+ " mit " + Player.getCurrentSign()
										+ " hat gewonnen");
								System.exit(0);
							} else if (Ruleset.IsGameOverNoWinner()) {
								System.out
										.println("Es gibt keinen Gewinner. Das Match endet unentschieden.");
								Gameboard.showgameboard(gameboard);
								System.exit(0);
							}
							break;
						}

					} else {
						// Überprüfe immer das folgende Feld
						poscheck = i + 1;
						if (gameboard[poscheck][column] != '\0') {
							gameboard[i][column] = Player.getCurrentSign();
							if (Ruleset.IsGameOver(i, column)) {
								Gameboard.showgameboard(gameboard);
								System.out.println(Player.getCurrentPlayer()
										+ " mit " + Player.getCurrentSign()
										+ " hat gewonnen");
								System.exit(0);
							} else if (Ruleset.IsGameOverNoWinner()) {
								System.out
										.println("Es gibt keinen Gewinner. Das Match endet unentschieden.");
								Gameboard.showgameboard(gameboard);
								System.exit(0);
							}
							break;
						}
					}
				}
			}
			break;
		}
	}

}
