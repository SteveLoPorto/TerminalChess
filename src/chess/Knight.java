package chess;

/**
 * Steven Loporto
 *
 */

public class Knight extends Piece {

	/**
	 * @param identifier the symbol of the Piece
	 * @param color      color of the Piece
	 * @param currentI   the I coordinate
	 * @param currentJ   the J coordinate
	 */
	public Knight(String identifier, String color, int currentI, int currentJ) {
		super(identifier, color, currentI, currentJ);
	}

	/**
	 * determines if a move is valid
	 * 
	 * @param destinationI the I-coordinate of the destination
	 * @param destinationJ the J-coordinate of the destination
	 * @param currentPiece the current Piece
	 * @return a boolean of whether the proposed move is valid
	 */
	@Override
	public boolean isValid(int destinationI, int destinationJ, Piece currentPiece) {
		int distanceI = Math.abs(currentI - destinationI);
		int distanceJ = Math.abs(currentJ - destinationJ);
		if (distanceI == 0 && distanceJ == 0) {
			return false;
		}
		if (Board.board[destinationI][destinationJ] instanceof Piece
				&& Board.board[destinationI][destinationJ].color.equals(color)) {
			return false;
		}

		if (distanceI == 2 && distanceJ == 1)
			return true;
		else if (distanceI == 1 && distanceJ == 2)
			return true;

		return false;
	}
}
