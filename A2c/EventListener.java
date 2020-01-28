package ca.bcit.COMP2522.A2c;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventListener extends MouseAdapter {
    private final Game game;
    private Square startSquare;

    public EventListener(Game paramChess) {
        this.game = paramChess;
    }
    
    public void changeSquare(MouseEvent mouse) {
        Square localSquare = (Square) mouse.getSource();
        localSquare.changeColor();
    }

    public void mouseClicked(MouseEvent mouse) {
        Square localSquare = (Square) mouse.getSource();
        Piece localPiece1;
        if (this.startSquare == null) {
            localPiece1 = localSquare.getPiece();
            if ((localPiece1 != null) && (localPiece1.getOwner() == this.game.getCurrentPlayer())) {
                this.startSquare = localSquare;
                this.startSquare.setActive(true);
                this.startSquare.changeColor();
                this.startSquare.repaint();
            }
        } else {
            localPiece1 = localSquare.getPiece();
            Piece localPiece2 = this.startSquare.getPiece();
            if ((localPiece1 != null) && (localPiece2.getOwner() == localPiece1.getOwner())) {
                this.startSquare.setActive(false);
                this.startSquare.repaint();
                this.startSquare = localSquare;
                this.startSquare.setActive(true);
                this.startSquare.repaint();
            } else if (localPiece2.isValidMove(startSquare, localSquare, this.game)) {
                this.game.move(this.startSquare, localSquare);
                this.startSquare.setActive(false);
                this.startSquare.repaint();
                this.startSquare = null;
                this.game.switchPlayers();
            }
        }
        localSquare.changeColor();
    }
}
