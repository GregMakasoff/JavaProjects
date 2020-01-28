package ca.bcit.COMP2522.A2c;
/*
/**
 * @author gregm
 *
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Game extends JFrame {
    private Board board = new Board(8, 8);
    private final Player whitePlayer = new Player(Color.WHITE);
    private final Player blackPlayer = new Player(Color.BLACK);
    private Player currentPlayer;

    public static void main(String[] args) {
        Game chess = new Game();
        chess.startGame();
        chess.centre();
        chess.setVisible(true);
    }

    public Game() {
        super("Chess");
    }

    private void startGame() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent newWindow) {
                Game.this.shutdown(0);
            }
        });
        this.board.setBoard(new EventListener(this));
        setPieces();
        this.currentPlayer = this.whitePlayer;
        getContentPane().setLayout(new GridLayout(1, 1));
        getContentPane().add(this.board);
    }

    private void setPieces() {
        setPiece(0, 0, new Rook(this.whitePlayer, "\u2656"));
        setPiece(0, 1, new Knight(this.whitePlayer, "\u2658"));
        setPiece(0, 2, new Bishop(this.whitePlayer, "\u2657"));
        setPiece(0, 3, new King(this.whitePlayer, "\u2654"));
        setPiece(0, 4, new Queen(this.whitePlayer, "\u2655"));
        setPiece(0, 5, new Bishop(this.whitePlayer, "\u2657"));
        setPiece(0, 6, new Knight(this.whitePlayer, "\u2658"));
        setPiece(0, 7, new Rook(this.whitePlayer, "\u2656"));
        for (int i = 0; i < 8; i++) {
            setPiece(1, i, new Pawn(this.whitePlayer, "\u2659"));
        }
        for (int i = 0; i < 8; i++) {
            setPiece(6, i, new Pawn(this.blackPlayer, "\u265F"));
        }
        setPiece(7, 0, new Rook(this.blackPlayer, "\u265C"));
        setPiece(7, 1, new Knight(this.blackPlayer, "\u265E"));
        setPiece(7, 2, new Bishop(this.blackPlayer, "\u265D"));
        setPiece(7, 3, new King(this.blackPlayer, "\u265A"));
        setPiece(7, 4, new Queen(this.blackPlayer, "\u265B"));
        setPiece(7, 5, new Bishop(this.blackPlayer, "\u265D"));
        setPiece(7, 6, new Knight(this.blackPlayer, "\u265E"));
        setPiece(7, 7, new Rook(this.blackPlayer, "\u265C"));
    }

    private void setPiece(int xCoord, int yCoord, Piece newPiece) {
        this.board.getSquare(xCoord, yCoord).setPiece(newPiece);
    }

    private void shutdown(int x) {
        System.exit(x);
    }

    private void centre() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int i = (int) Math.min(dimension.width * 0.75D, dimension.height * 0.75D);

        Rectangle rectangle = new Rectangle();
        rectangle.width = i;
        rectangle.height = i;
        rectangle.x = ((dimension.width - i) / 2);
        rectangle.y = ((dimension.height - i) / 2);
        setBounds(rectangle);
    }

    public void move(Square paramSquare1, Square paramSquare2) {
        Piece localPiece = paramSquare1.getPiece();
        paramSquare1.setPiece(null);
        paramSquare2.setPiece(localPiece);
        paramSquare1.repaint();
        paramSquare2.repaint();
    }

    public Board getBoard() {
        return this.board;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void switchPlayers() {
        if (this.currentPlayer == this.blackPlayer) {
            this.currentPlayer = this.whitePlayer;
        } else {
            this.currentPlayer = this.blackPlayer;
        }
    }
}
