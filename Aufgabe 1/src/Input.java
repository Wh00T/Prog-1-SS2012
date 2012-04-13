import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

	public static String input() {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
//		try {
			try {
				input = console.readLine();
			} catch (IOException e) {
				System.err.println("Leider ist ein Fehler bei der Eingabe aufgetreten. Bitte starten Sie das Spiel erneut.");
			}
//		}
//		catch (Exception E) {
//			System.err.println("Leider ist ein unbekannter Fehler aufgetreten.");
//		}
		return input;
	}
}