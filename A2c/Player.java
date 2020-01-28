package ca.bcit.COMP2522.A2c;

import java.awt.Color;

/**
 * @author gregm
 *
 */
public class Player {
    public final Color colour;
    
    public Player(Color newColour)
    {
      this.colour = newColour;
    }
    
    public Color getColour() {
        return this.colour;
    }
}
