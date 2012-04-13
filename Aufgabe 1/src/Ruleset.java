import java.util.Random;

public class Ruleset {

	public static void setzeFeld(char[][] gameboard) {
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
						//-1 verhindert ArrayOutOfBounds, +1 wandelt es ins menschliche Format
//						System.out.println("Der Computer setzt in die Spalte "
//								+ column + ".");
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
							if (Ruleset.IsGameOver(gameboard, i, column,
									Player.getCurrentSign())) {
								Gameboard.showgameboard(gameboard);
								System.out.println(Player.getCurrentPlayer()
										+ " mit " + Player.getCurrentSign()
										+ " hat gewonnen");
								System.exit(0);
							}
							break;
						}

					} else {
						// Überprüfe immer das folgende Feld
						poscheck = i + 1;
						if (gameboard[poscheck][column] != '\0') {
							gameboard[i][column] = Player.getCurrentSign();
							if (Ruleset.IsGameOver(gameboard, i, column,
									Player.getCurrentSign())) {
								Gameboard.showgameboard(gameboard);
								System.out.println(Player.getCurrentPlayer()
										+ " mit " + Player.getCurrentSign()
										+ " hat gewonnen");
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
	
//	private static boolean IsGameOverNoWinner(char[][] gameboard, int column, int row) {
//		for (int i = 0; i < Gameboard.getColumns(); i++) {
//			
//			// noch nix
//		}
//		
//		for (int i = 0; i < Gameboard.getRows(); i++) {
//			//auch noch nix
//		}
//	}

	private static boolean IsGameOver(char[][] gameboard, int column, int row,
			char sign) {
		boolean b1 = GameIsOver_row(gameboard, column, row, sign);
		boolean b2 = GameIsOver_column(gameboard, column, row, sign);
		boolean b3 = GameIsOver_straight1(gameboard, column, row, sign);
		boolean b4 = GameIsOver_straight2(gameboard, column, row, sign);

		return (b1 || b2 || b3 || b4);
	}

	private static boolean GameIsOver_row(char[][] gameboard, int column,
			int row, char sign) {
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
			int row, char sign) {
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
			int row, char sign) {
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
			int row, char sign) {
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
