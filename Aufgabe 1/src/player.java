import java.io.*;

public class player {
		
	public String name1 (String[] args) throws Exception {
		String player1 = null;
		BufferedReader console1 = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Geben Sie den ersten Spielernamen ein: ");
		try {
			player1 = console1.readLine();
		} catch (IOException e) {
			// Sollte eigentlich nie passieren
			e.printStackTrace();
		}
//		System.out.println("Die Spielernamen lauten: " + player1 + " & " + player2);
		return player1;
	}
	
	public String name2 (String[] args) throws Exception {
		BufferedReader console2 = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Geben Sie den zweiten Spielernamen ein: ");
		String player2 = null;
		try {
			player2 = console2.readLine();
		} catch (IOException e) {
			// Sollte eigentlich nie passieren
			e.printStackTrace();
		}
		return player2;
	}
}
