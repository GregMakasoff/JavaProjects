/**
 * 
 */
package ca.bcit.COMP2522.A2c;

/**
 * @author gregm
 *
 */
import javax.swing.JPanel;

public abstract class ChessBoard extends JPanel {
  protected ChessBoard curBoard;
  
  public ChessBoard getCurBoard()
  {
    return this.curBoard;
  }
  
  public void setBoard(ChessBoard board)
  {
    this.curBoard = board;
  }
  
  public abstract void setBoard(EventListener paramMoveListener);
  
  public abstract Square getSquare(int paramInt1, int paramInt2);
  
  public abstract int getNumRows();
  
  public abstract boolean isVertPathEmpty(Square paramSquare1, Square paramSquare2);
  
  public abstract boolean isHorzPathEmpty(Square paramSquare1, Square paramSquare2);
  
  public abstract boolean isLeftDiagPathEmpty(Square paramSquare1, Square paramSquare2);
  
  public abstract boolean isLeftDownDiagPathEmpty(Square paramSquare1, Square paramSquare2);
  
  public abstract boolean isRightDiagPathEmpty(Square paramSquare1, Square paramSquare2);
  
  public abstract boolean isRightDownDiagPathEmpty(Square paramSquare1, Square paramSquare2);
  
  public abstract int getNumCols(int paramInt);
}
