
public class Gameboardpainting {
	
	static void showgameboard(char[][] gameboard) {
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