package chess;

/**
 *  Steven Loporto
 *
 */

public abstract class Piece {

	public String color;
	public String identifier;
	public int currentI;
	public int currentJ;

	public Piece(String identifier, String color, int currentI, int currentJ) {
		this.color = color;
		this.identifier = identifier;
		this.currentI = currentI;
		this.currentJ = currentJ;
	}

	public void updateLocation(int destinationI, int destinationJ) {
		currentI = destinationI;
		currentJ = destinationJ;
	}

	public void move(int destinationI, int destinationJ, Piece currentPiece) {
		if (currentPiece instanceof King && Math.abs(destinationJ - currentJ) == 2) {
			if (destinationJ > currentPiece.currentJ) {

				Board.board[destinationI][5] = Board.board[destinationI][7];
				Board.board[destinationI][5].updateLocation(destinationI, 5);
				((Rook) Board.board[destinationI][5]).setHasMoved(true);
				Board.board[destinationI][7] = null;
			} else if (destinationJ < currentPiece.currentJ) {
				Board.board[destinationI][3] = Board.board[destinationI][0];
				Board.board[destinationI][3].updateLocation(destinationI, 3);
				((Rook) Board.board[destinationI][3]).setHasMoved(true);
				Board.board[destinationI][0] = null;
			}
		}

		Board.board[currentI][currentJ] = null;
		Board.board[destinationI][destinationJ] = currentPiece;
		currentPiece.updateLocation(destinationI, destinationJ);
		if (currentPiece instanceof Rook) {
			((Rook) currentPiece).setHasMoved(true);
		}
		if (currentPiece instanceof King) {
			((King) currentPiece).setHasMoved(true);
		}

	}

	// check if valid move
	public abstract boolean isValid(int destinationI, int destinationJ, Piece currentPiece);

	// check
	public String toString() {
		return identifier;
	}

}
