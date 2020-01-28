package ca.bcit.COMP2522.A2c;
/**
 * @author gregm
 *
 */
public class Knight extends Piece {
    public Knight(Player newPiece, String str) {
        super(newPiece, str);
    }
    
    public boolean isValidMove(Square initialSquare, Square nextSquare, Game chess) {
        int inCol = initialSquare.getCol(); 
        int inRow = initialSquare.getRow();
        int nextCol = nextSquare.getCol();
        int nextRow = nextSquare.getRow();
        
        if(Math.abs(nextRow - inRow) == 2 && Math.abs(nextCol - inCol) == 1)
            return true;
        
        if(Math.abs(nextRow - inRow) == 1 && Math.abs(nextCol - inCol) == 2)
            return true;
        
        return false;
    }
}
