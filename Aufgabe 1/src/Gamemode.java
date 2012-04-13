public class Gamemode {

	private static String gamemode;

	public static void Choice() {

		while (true) {
			System.out.println("Möchten Sie Singleplayer (SP) oder Multiplayer (MP) spielen?");
			String input1 = Input.input();
			if (input1.equals("MP")) {
				Gamemode.setGamemode("MP");
				Player.setPlayer1();
				do {
					Player.setPlayer2();
				} while (Player.getPlayer1().equals(Player.getPlayer2()));
				break;
			} else if (input1.equals("SP")) {
				Gamemode.setGamemode("SP");
				Player.setPlayer1();
				Player.setPlayer2();
				break;
			} else {
				System.err.println("Sie müssen sich entweder für den Singleplayer (SP) oder Multiplayer (MP) entscheiden.");
				continue;
			}
		}
	}

	public static String getGamemode() {
		return gamemode;
	}

	private static void setGamemode(String gamemode) {
		if (gamemode == "SP") {
			Gamemode.gamemode = gamemode;
		} else if (gamemode == "MP") {
			Gamemode.gamemode = gamemode;
		} else {
			System.err.println("Sie haben keinen gültigen Spielmodus gewählt.");
			System.exit(0);
		}
	}
}
