package ca.bcit.COMP2522.A2c;

import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**

 * @author gregm
 *
 */

public class Board extends ChessBoard {
    /**
     * 
     */
    private final Square[][] squares;  
    private final Color lGray = Color.LIGHT_GRAY;  
    private final Color dGray = Color.DARK_GRAY;

    public Board(int row, int col) {
        this.squares = new Square[row][col];
        this.curBoard = this;
    }

    public void setBoard(EventListener e) {
        setLayout(new GridLayout(this.squares.length, this.squares[0].length));
        for (int i = 0; i < this.squares.length; i++) {
            for (int j = 0; j < this.squares[i].length; j++) {
                if ((i + j) % 2 == 0) {
                    this.squares[i][j] = new Square(i, j, dGray);
                } else {
                    this.squares[i][j] = new Square(i, j, lGray);
                }
                add(this.squares[i][j]);
                this.squares[i][j].addMouseListener(e);
            }
        }
    }

    public Square getSquare(int row, int col) {
        return this.squares[row][col];
    }

    public int getNumRows() {
        return this.squares.length;
    }

    public int getNumCols(int col) {
        return this.squares[col].length;
    }

    @Override
    public boolean isVertPathEmpty(Square paramSquare1, Square paramSquare2) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isHorzPathEmpty(Square paramSquare1, Square paramSquare2) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isLeftDiagPathEmpty(Square paramSquare1, Square paramSquare2) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isLeftDownDiagPathEmpty(Square paramSquare1, Square paramSquare2) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isRightDiagPathEmpty(Square paramSquare1, Square paramSquare2) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isRightDownDiagPathEmpty(Square paramSquare1, Square paramSquare2) {
        // TODO Auto-generated method stub
        return false;
    }

}
