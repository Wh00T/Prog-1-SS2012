
public class print {
	
	
	public static void printer(int[][] gameboardsize) throws Exception {
		StringBuffer construct = new StringBuffer(); 
		StringBuffer row_start = new StringBuffer(" ");
		StringBuffer row_divide = new StringBuffer("|");
		StringBuffer row_end = new StringBuffer("-");
		
		char[][] gameboardchar = new char[gameboardsize[0].length][gameboardsize[0].length];
		for (int i = 0; i < gameboardsize[0].length; i++) {
			gameboardchar[i][i] = (char) gameboardchar[i][i];
		}
		
//		char[] charArr = new char[intArr.size];
//		for(int i=0; i < intArr.size; i++) charArr[i] = (char) intArr[i];
		
//		if (gameboardsize[0].length > 9) {
//			for (int i = 1; i <= gameboardsize[0].length; i++)
//				row_start.append((i / 10 == 0) ? " " : i / 10).append(" ");
//			row_start.append("\n ");
//		}
		
		for (int i = 1; i <= gameboardsize[0].length; i++) {
			row_start.append(i % 10).append(" ");
			row_divide.append((i == gameboardsize[0].length) ? "-|" : "--");
			row_end.append("--");
		}
		System.out.println(row_start);
		System.out.println(row_divide);
 
		for (char[] arrZeile : gameboardchar) {
			for (char arrSpalte : arrZeile) {
				construct.append("|");
				construct.append((arrSpalte == '\0') ? ' ' : arrSpalte);
			}
			construct.append("|\n");
		}
		construct.append(row_end).append("\n");
		System.out.println(construct);
	}
}
