/**
 * 
 */
package ca.bcit.COMP2522.Assignment1d;

/**
 * @author gregm
 * @version 1.0
 */
public class PhoneBook {
    /**Instance variable.*/
    private Person[] database;
    /**Instance variable.*/
    private static GUI gui;
    /**
     * Constructor.
     */
    public PhoneBook() {
        database = new Person[0];
        gui = new GUI();
    }
    /**
     * Fills a temp array with current array, then increases the old array size by one
     * , then puts the Person objects back and adds the new one.
     * @param person used
     */
    public void add(Person person) {
        Person temp = person;
        Person[] newArray = new Person[database.length + 1];
        for (int i = 0; i < database.length; i++) {
            newArray[i] = database[i];
        }
        database = new Person[newArray.length];
        for (int i = 0; i < database.length; i++) {
            database[i] = newArray[i];
        }
        database[database.length - 1] = temp;
    }
    /**
     * Searches the array and returns a Person.
     * @param name used
     * @return person
     */
    public Person searchPerson(final String name) {

        for (int i = 0; i < database.length; i++) {
            if (name.equals(database[i].getName()))
                return database[i];
        }
        return null;
    }
    /**
     * Searches the array and returns the index of the Person.
     * @param name used
     * @return i
     */
    public int search(final String name) {

        for (int i = 0; i < database.length; i++) {
            if (name.equals(database[i].getName()))
                return i;
        }
        return -1;
    }
    /**
     * Displays all the Person objects in the array.
     */
    public void displayAll() {
        gui.display(database);
    }
    /**
     * Removes a Person object from the array given their name.
     * @param name used
     * @return boolean
     */
    public boolean remove(final String name) {
        int pos = search(name);
        if (pos >= 0) {
            Person[] temp = new Person[database.length - 1];
            System.arraycopy(database, 0, temp, 0, pos);
            System.arraycopy(database, pos + 1, temp, pos, database.length - pos - 1);
            database = temp;
            return true;
        }
        return false;
    }
    /**
     * Calls add function to add someone to the array.
     */
    public void addPerson() {
        Person person = gui.readPerson();
        add(person);
    }
    /**
     * Calls functions to delete Person object from the array.
     */
    public void deletePerson() {
        String name = "";
        try {
            name = gui.readName();
        } catch (Exception e) {
        }
        if (!remove(name))
            gui.displayErrorMsg("Could not delete " + name);
        else
            gui.displayMsg(name + " was deleted successfully");
    }
    /**
     * Displays a person given their name to the GUI.
     */
    public void findPerson() {
        final String name;
        final Person person;

        name = gui.readName();
        person = searchPerson(name);

        if (person != null) {
            gui.display(person);
        } else {
            gui.displayErrorMsg("No such person");
        }
    }
    /**
     * Runs the GUI.
     */
    public void run() {
        PhoneBook book = new PhoneBook();
        gui.run(book);
    }
    /**
     * Runs the program
     * @param args unused
     */
    public static void main(String[] args) {
        new PhoneBook().run();
    }
}
