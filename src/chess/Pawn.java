package chess;

import java.lang.Math;

/**
 *  Steven Loporto
 *
 */

public class Pawn extends Piece {
	
	public boolean isEmpassantable = false;
	public int moveCounter = 0;

	/**
	 * @param identifier the symbol of the Piece
	 * @param color      color of the Piece
	 * @param currentI   the I coordinate
	 * @param currentJ   the J coordinate
	 */
	public Pawn(String identifier, String color, int currentI, int currentJ) {
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
	public boolean isValid(int destinationI, int destinationJ, Piece currentPiece) {
		// TODO Auto-generated method stub
		int distanceI = Math.abs(destinationI - currentI);
		int distanceJ = Math.abs(destinationJ - currentJ);
		if (distanceI == 0 && distanceJ == 0) {
			return false;
		}
		if (color.equals("white")) {
			
			//pawn does empassant
			if(distanceI == 1 && distanceJ == 1 && currentI > destinationI && destinationI < 7
					&& Board.board[destinationI+1][destinationJ] != null
					&& Board.board[destinationI+1][destinationJ].color == "black") {
				if(Board.board[destinationI+1][destinationJ] instanceof Pawn) {
					Pawn attacked = (Pawn)Board.board[destinationI+1][destinationJ];
					//System.out.println("Attacked Id: " + attacked.identifier + " Attacked Empas: " + attacked.isEmpassantable);
					//System.out.println("attacking move coumter: " + moveCounter);
					if(attacked.isEmpassantable == true && moveCounter >= 3) {
						Board.board[destinationI+1][destinationJ] = null;
						return true;
						
					}
				}
			}
			
			// pawn moves two steps
			if (distanceI == 2 && distanceJ == 0 && currentI > destinationI && currentI == 6
					&& Board.board[currentI - 1][currentJ] == null && Board.board[currentI - 2][currentJ] == null) {
				return true;
			}
			// pawn moves one forward
			if (distanceI == 1 && distanceJ == 0 && currentI > destinationI
					&& Board.board[currentI - 1][currentJ] == null) {

				return true;
			}
			// moves diagonal but is attacking a piece
			if (distanceI == 1 && distanceJ == 1 && currentI > destinationI
					&& Board.board[destinationI][destinationJ] != null
					&& Board.board[destinationI][destinationJ].color == "black") {

				return true;
			}
			return false;

			// Black Piece
		} else {
			
			//pawn does empassant
			if(distanceI == 1 && distanceJ == 1 && currentI < destinationI && destinationI > 1
					&& Board.board[destinationI-1][destinationJ] != null
					&& Board.board[destinationI-1][destinationJ].color == "white") {
				if(Board.board[destinationI-1][destinationJ] instanceof Pawn) {
					Pawn attacked = (Pawn)Board.board[destinationI-1][destinationJ];
					if(attacked.isEmpassantable == true && moveCounter >= 3) {
						Board.board[destinationI-1][destinationJ] = null;
						return true;
						
					}
				}
			}
			
			// pawn moves two steps
			if (distanceI == 2 && distanceJ == 0 && currentI < destinationI && currentI == 1
					&& Board.board[currentI + 1][currentJ] == null && Board.board[currentI + 2][currentJ] == null) {
				return true;
			}
			// pawn moves one forward
			if (distanceI == 1 && distanceJ == 0 && currentI < destinationI
					&& Board.board[currentI + 1][currentJ] == null) {

				return true;

			}
			// moves diagonal but is attacking a piece
			if (distanceI == 1 && distanceJ == 1 && currentI < destinationI
					&& Board.board[destinationI][destinationJ] != null
					&& Board.board[destinationI][destinationJ].color == "white") {

				return true;
			}

		}
		return false;
	}

	public void upgradePawn(String upgradedPiece) {

		switch (upgradedPiece) {

		case "N":
			if (color == "white") {
				Board.board[currentI][currentJ] = new Knight("wN", "white", currentI, currentJ);
			} else if (color == "black") {
				Board.board[currentI][currentJ] = new Knight("bN", "black", currentI, currentJ);
			}
			break;

		case "Q":
			if (color == "white") {
				Board.board[currentI][currentJ] = new Queen("wQ", "white", currentI, currentJ);
			} else if (color == "black") {
				Board.board[currentI][currentJ] = new Queen("bQ", "black", currentI, currentJ);
			}
			break;

		case "B":
			if (color == "white") {
				Board.board[currentI][currentJ] = new Bishop("wB", "white", currentI, currentJ);
			} else if (color == "black") {
				Board.board[currentI][currentJ] = new Bishop("bB", "black", currentI, currentJ);
			}
			break;

		case "R":
			if (color == "white") {
				Board.board[currentI][currentJ] = new Rook("wR", "white", currentI, currentJ);
			} else if (color == "black") {
				Board.board[currentI][currentJ] = new Rook("bR", "black", currentI, currentJ);
			}
			break;

		}

	}

}
