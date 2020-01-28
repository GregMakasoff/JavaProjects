package ca.bcit.COMP2522.A2c;
/**
 * @author gregm
 *
 */
public class Queen extends Piece {
    public Queen(Player newPiece, String str)
    {
        super(newPiece, str);
    }
    
    public boolean isValidMove(Square initialSquare, Square nextSquare, Game chess){
        
        if (Bishop.isValid(initialSquare, nextSquare, chess) || Rook.isValid(initialSquare, nextSquare, chess))
            return true;
        else
            return false;
    }
}
