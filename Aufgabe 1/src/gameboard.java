import java.io.*;

public class gameboard {
	
	public static String CurrentPlayer;

	public static int[][] gameboardsize() throws Exception {
		String columnsS = null, rowsS = null;
		int counter = 0, rows = 0, columns = 0, input;
		char sign;
		int[][] gameboardsize;
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

		
		do {
			System.out.print("Bitte geben Sie die Höhe des Spielfeldes ein: ");
			rowsS = console.readLine();
			try {
				rows = Integer.parseInt(rowsS);
			} catch (Exception E) {
				System.out.println("Bitte geben Sie eine Zahl ein!");
			}
			if (rows < 4) {
				System.out.println("Das Spielfeld muss mindestens 4 Felder hoch sein.");
			}
			if (rows > 9) {
				System.out.println("Das Spielfeld darf maximal 9 Felder hoch sein.");
			}
			//System.err.println verschiebt alles?
			//Eingabe = A : HowTo?
		} while ((rows < 4) || (rows > 9));
		
		do {
			System.out.print("Bitte geben Sie die Breite des Spielfeldes ein: ");
			columnsS = console.readLine();
			try { 
				columns = Integer.parseInt(columnsS);
			} catch (Exception E) {
				System.out.println("Bitte geben Sie eine Zahl ein!");
			}
			if (columns < 4) {
				System.out.println("Das Spielfeld muss mindestens 4 Felder breit sein.");
			}
			if (columns > 9) {
				System.out.println("Das Spielfeld darf maximal 9 Felder breit sein.");
			}
		} while ((columns < 4) || (columns > 9));
						
		gameboardsize = new int[rows][columns];
		return gameboardsize;
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
