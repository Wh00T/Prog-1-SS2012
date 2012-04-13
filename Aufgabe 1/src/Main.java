public class Main {
	
	public static void main(String[] args) throws Exception {
			
//		int gameboard[][] = new int[5][6];
//		System.out.println(gameboard[0].length);
		
		Gamemode.Choice();
		Gameboard.setRows();
		Gameboard.setColumns();
		Gameboard.setGameboard();
		while (true) {
			Player.setCurrentSign();
			Player.setCurrentPlayer();
			Ruleset.setzeFeld(Gameboard.getGameboard());
		}
		

	}
}