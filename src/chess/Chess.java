package chess;

/**
 *  Steven Loporto
 *
 */

public class Chess {
	/**
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		Board.initalize();
		Board board = new Board();
		board.execute();
	}
}