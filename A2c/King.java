package ca.bcit.COMP2522.A2c;
/**
 * @author gregm
 *
 */
public class King extends Piece {
    public King(Player newPiece, String str)
    {
        super(newPiece, str);
    }
    
    public boolean isValidMove(Square initialSquare, Square nextSquare, Game chess) {
        int inCol = initialSquare.getCol(); 
        int inRow = initialSquare.getRow();
        int nextCol = nextSquare.getCol();
        int nextRow = nextSquare.getRow();
        
        if(Math.abs(inRow - nextRow) > 1 || Math.abs(inCol - nextCol) > 1)
            return false;
        if(inRow == nextRow) {
            int yDir = nextCol > inCol ? 1 : -1;
            if(chess.getBoard().getSquare(inRow, inCol + 1 * yDir).hasPiece())
                return false;
        }
        if(inCol == nextCol) {
            int xDir = nextRow > inRow ? 1 : -1;
                if(chess.getBoard().getSquare(inRow + 1 * xDir, inCol).hasPiece())
                    return false;
        }
        return true;
    }
}
