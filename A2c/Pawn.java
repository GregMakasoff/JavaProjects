package ca.bcit.COMP2522.A2c;

import java.awt.Color;

/**
 * @author gregm
 *
 */
public class Pawn extends Piece {
    private boolean firstMove;

    public Pawn(Player newPiece, String str) {
        super(newPiece, str);
        this.firstMove = true;
    }

    public boolean isValidMove(Square initialSquare, Square nextSquare, Game chess) {
        int inCol = initialSquare.getCol(); 
        int inRow = initialSquare.getRow();
        int nextCol = nextSquare.getCol();
        int nextRow = nextSquare.getRow();

        if (inCol != nextCol)
            return false;
        int firstDir = initialSquare.getPiece().getOwner().getColour() == Color.BLACK ? -1 : 1;
        int secDir = (inRow - nextRow) > 0 ? -1 : 1;
        if(firstDir != secDir)
            return false;
        if (firstMove) {
            int length = Math.abs(nextRow - inRow);
            if (length > 2)
                return false;
            for(int i = 1; i < length; i++) {
                if(chess.getBoard().getSquare(inRow + i * firstDir, inCol).hasPiece())
                    return false;
            }
        }
        if (!firstMove) {
            if((Math.abs(inRow - nextRow) != 1))
                return false;
        }
        this.firstMove = false;
        return true;
    }
}
