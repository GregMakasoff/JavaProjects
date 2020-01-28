/**
 * 
 */
package ca.bcit.COMP2522.A2c;

/**
 * @author gregm
 *
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Square extends Canvas {
    private final int row;
    private final int col;
    private Piece piece;
    private boolean isActive;
    private static Board board;
    private Color colour;

    public Square(int x, int y, Color color) {
        this.row = x;
        this.col = y;
        setBackground(color);
        colour = color;
    }

    public void setActive(boolean bool) {
        this.isActive = bool;
        if(this.isActive == true)
            setBackground(Color.YELLOW);
        if(this.isActive == false) {
            if ((row + col) % 2 == 0)
                this.setBackground(Color.DARK_GRAY);
            else
                this.setBackground(Color.LIGHT_GRAY);
        }
    }
    
    public boolean getActive() {
        return this.isActive;
    }
    
    public void changeColor() {
        if((this.getBackground() == Color.DARK_GRAY) || (this.getBackground() == Color.LIGHT_GRAY))
            this.setBackground(Color.YELLOW);
        if(this.getBackground() == Color.YELLOW) {
            if ((row + col) % 2 == 0)
                this.setBackground(Color.DARK_GRAY);
            else
                this.setBackground(Color.LIGHT_GRAY);
        }
    }
    
    public Color getColor() {
        return this.colour;
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        if (this.piece != null) {
            Font font = graphics.getFont();
            font = font.deriveFont(Font.PLAIN, 40);
            graphics.setFont(font);
            graphics.setColor(this.piece.getOwner().colour);
            graphics.drawString(this.piece.getImage(), getWidth() / 3, getHeight() / 2);
        }
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public void setPiece(Piece newPiece) {
        if (this.piece != null) {
            this.piece.setSquare(null);
        }
        this.piece = newPiece;
        if (this.piece != null) {
            this.piece.setSquare(this);
        }
    }

    public Piece getPiece() {
        return this.piece;
    }
    
    public Square leftSquare() {
        if (col > 0) {
            return board.getSquare(row, col - 1);
        }
        return null;
    }
    
    public Square rightSquare() {
        if (col + 1 < board.getNumCols(row)) {
            return board.getSquare(row, col + 1);
        }
        return null;
    }
    
    public Square aboveSquare() {
        if (row > 0) {
            return board.getSquare(row - 1, col);
        }
        return null;
    }
    
    public Square belowSquare() {
        if (row + 1 < board.getNumRows()) {
            return board.getSquare(row + 1, col);
        }
        return null;
    }
    
    public boolean hasPiece() {
        if (this.getPiece() == null)
            return false;
        else
            return true;          
    }
}
