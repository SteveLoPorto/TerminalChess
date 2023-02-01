package chess;

/**
 *  Steven Loporto
 *
 */

public class King extends Piece {
	private boolean hasMoved = false;

	/**
	 * @param identifier the symbol of the Piece
	 * @param color      color of the Piece
	 * @param currentI   the I coordinate
	 * @param currentJ   the J coordinate
	 */
	public King(String identifier, String color, int currentI, int currentJ) {
		super(identifier, color, currentI, currentJ);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * determines if a move is valid
	 * 
	 * @param destinationI the I-coordinate of the destination
	 * @param destinationJ the J-coordinate of the destination
	 * @param currentPiece the current Piece
	 * @return a boolean of whether the proposed move is valid
	 */
	public boolean isValid(int destinationI, int destinationJ, Piece currentPiece) {
		// TODO Auto-generated method stub
		int distanceI = Math.abs(destinationI - currentI);
		int distanceJ = Math.abs(destinationJ - currentJ);
		if (Board.board[destinationI][destinationJ] instanceof Piece
				&& Board.board[destinationI][destinationJ].color.equals(color)) {
			return false;
		}
		if (distanceJ == 2 && !hasMoved) {
			if (destinationJ > currentJ && Board.board[currentI][7] instanceof Rook
					&& !((Rook) Board.board[currentI][7]).HasMoved() && Board.board[currentI][6] == null
					&& Board.board[currentI][5] == null)
				return true;
			if (destinationJ < currentJ && Board.board[currentI][0] instanceof Rook
					&& !((Rook) Board.board[currentI][0]).HasMoved() && Board.board[currentI][1] == null
					&& Board.board[currentI][2] == null && Board.board[currentI][3] == null)
				return true;

		}
		if (distanceI == 0 && distanceJ == 0) {
			return false;
		}

		if (distanceI > 1 || distanceJ > 1) {
			return false;
		}

		return true;
	}

	/**
	 * @return the hasMoved
	 */
	public boolean HasMoved() {
		return hasMoved;
	}

	/**
	 * @param hasMoved the hasMoved to set
	 */
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

}
