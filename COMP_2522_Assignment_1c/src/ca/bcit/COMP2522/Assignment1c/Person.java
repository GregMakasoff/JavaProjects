/**
 * 
 */
package ca.bcit.COMP2522.Assignment1c;

/**
 * @author gregm
 *
 */
public class Person {
    private final String name;
    private final String phone;

    public Person(final String nm, final String ph) {
        name = nm;
        phone = ph;
    }

    public String getName() {
        return (name);
    }

    public String getPhoneNumber() {
        return (phone);
    }
}
