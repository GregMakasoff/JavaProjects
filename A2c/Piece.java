package ca.bcit.COMP2522.A2c;
/**
 * @author gregm
 *
 */
public abstract class Piece {

    private final String image;
    protected final Player owner;
    protected Square square;
    
    protected Piece(Player paramPlayer, String paramString)
    {
      this.owner = paramPlayer;
      this.image = paramString;
    }
    
    public String getImage()
    {
      return this.image;
    }
    
    public Player getOwner()
    {
      return this.owner;
    }
    
    public void setSquare(Square paramSquare)
    {
      this.square = paramSquare;
    }
    
    public Square getSquare()
    {
      return this.square;
    }
    
    public abstract boolean isValidMove(Square paramSquare, Square nextSquare, Game chess);
}
