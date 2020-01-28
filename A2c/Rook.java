package ca.bcit.COMP2522.A2c;
/**
 * @author gregm
 *
 */
public class Rook extends Piece {
    public Rook(Player newPiece, String str)
    {
        super(newPiece, str);
    }
    
    public boolean isValidMove(Square initialSquare, Square nextSquare, Game chess) {
        int inCol = initialSquare.getCol(); 
        int inRow = initialSquare.getRow();
        int nextCol = nextSquare.getCol();
        int nextRow = nextSquare.getRow();
        
        if(inRow == nextRow) {
            int yDir = nextCol > inCol ? 1 : -1;
            int length = Math.abs(nextCol - inCol);
            for(int i = 1; i < length; i++) {
                if(chess.getBoard().getSquare(inRow, inCol + i * yDir).hasPiece())
                    return false;
            }
        }
        if(inCol == nextCol) {
            int xDir = nextRow > inRow ? 1 : -1;
            int length = Math.abs(nextRow - inRow);
            for(int i = 1; i < length; i++) {
                if(chess.getBoard().getSquare(inRow + i * xDir, inCol).hasPiece())
                    return false;
            }
        }
        if((nextCol != inCol) && nextRow != inRow)
            return false;
        else 
            return true;
    }
    
    public static boolean isValid(Square initialSquare, Square nextSquare, Game chess) {
        int inCol = initialSquare.getCol(); 
        int inRow = initialSquare.getRow();
        int nextCol = nextSquare.getCol();
        int nextRow = nextSquare.getRow();
        
        if(inRow == nextRow) {
            int yDir = nextCol > inCol ? 1 : -1;
            int length = Math.abs(nextCol - inCol);
            for(int i = 1; i < length; i++) {
                if(chess.getBoard().getSquare(inRow, inCol + i * yDir).hasPiece())
                    return false;
            }
        }
        if(inCol == nextCol) {
            int xDir = nextRow > inRow ? 1 : -1;
            int length = Math.abs(nextRow - inRow);
            for(int i = 1; i < length; i++) {
                if(chess.getBoard().getSquare(inRow + i * xDir, inCol).hasPiece())
                    return false;
            }
        }
        if((nextCol != inCol) && nextRow != inRow)
            return false;
        else 
            return true;
    }
}
