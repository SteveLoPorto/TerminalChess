package chess;

/**
 * Steven Loporto
 *
 */

public class Bishop extends Piece {
	/**
	 * @param identifier the symbol of the Piece
	 * @param color      color of the Piece
	 * @param currentI   the I coordinate
	 * @param currentJ   the J coordinate
	 */
	public Bishop(String identifier, String color, int currentI, int currentJ) {
		super(identifier, color, currentI, currentJ);
		// TODO Auto-generated constructor stub
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
		if (distanceI != distanceJ) {
			return false;
		}
		if (Board.board[destinationI][destinationJ] instanceof Piece
				&& Board.board[destinationI][destinationJ].color.equals(color)) {
			return false;
		}
		int i = currentI;
		int j = currentJ;
		while (i != destinationI || j != destinationJ) {
			if (currentI < destinationI) {
				i++;
			} else if (currentI > destinationI) {
				i--;
			}
			if (currentJ < destinationJ) {
				j++;
			} else if (currentJ > destinationJ) {
				j--;
			}
			if ((i != destinationI || j != destinationJ) && Board.board[i][j] instanceof Piece) {
				return false;
			}
		}

		return true;
	}

}
