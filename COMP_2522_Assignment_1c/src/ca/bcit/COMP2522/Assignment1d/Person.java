/**
 * 
 */
package ca.bcit.COMP2522.Assignment1d;

/**
 * @author gregm
 *
 */
public class Person {
    
    /**Instance variable.*/
    private String name;
    /**Instance variable.*/
    private String number;
    
    /**
     * Constructor.
     * @param newName used
     * @param newNum used
     */
    public Person(String newName, String newNum) {
        
        name = newName;      
        number = newNum;
    }   
    /**
     * Getter.
     * @return name
     */
    public String getName() {
        
        return name;
    }
    /**
     * Getter.
     * @return number
     */
    public String getNum() {
        
        return number;
    }
    /**
     * toString.
     */
    public String toString() {
        
        String result = name + "\t\t" + number;
        
        return result;
    }
}

