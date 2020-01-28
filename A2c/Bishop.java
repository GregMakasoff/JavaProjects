/**
 * 
 */
package ca.bcit.COMP2522.A2c;
/**
 * @author gregm
 *
 */
public class Bishop extends Piece {
    public Bishop(Player newPiece, String str)
    {
      super(newPiece, str);
    }
    
    public boolean isValidMove(Square initialSquare, Square nextSquare, Game chess) {
        int inCol = initialSquare.getCol(); 
        int inRow = initialSquare.getRow();
        int nextCol = nextSquare.getCol();
        int nextRow = nextSquare.getRow();
        
        if(Math.abs(nextCol - inCol) == Math.abs(nextRow - inRow)) {
            int xDir = nextRow > inRow ? 1 : -1;
            int yDir = nextCol > inCol ? 1 : -1;
            int length = Math.abs(nextRow - inRow);
            for(int i = 1; i < length; i++) {
                if(chess.getBoard().getSquare(inRow+i*xDir, inCol + i * yDir).hasPiece())
                    return false;
            }
            return true;
        }
        else
            return false;
    }
    
    public static boolean isValid(Square initialSquare, Square nextSquare, Game chess) {
        int inCol = initialSquare.getCol(); 
        int inRow = initialSquare.getRow();
        int nextCol = nextSquare.getCol();
        int nextRow = nextSquare.getRow();
        
        if(Math.abs(nextCol - inCol) == Math.abs(nextRow - inRow)) {
            int xDir = nextRow > inRow ? 1 : -1;
            int yDir = nextCol > inCol ? 1 : -1;
            int length = Math.abs(nextRow - inRow);
            for(int i = 1; i < length; i++) {
                if(chess.getBoard().getSquare(inRow+i*xDir, inCol + i * yDir).hasPiece())
                    return false;
            }
            return true;
        }
        else
            return false;
    }
}
