
public class SchoolDirectoryDemo {

	private SchoolDirectory dir;
	private SchoolDirectoryGUI interact;
	
	/**
	 * Setup an AddressBook with sample data.
	 * The address book is passed to a GUI to provide
	 * a view of the data.
	 */
	public SchoolDirectoryDemo()
	{
		Student1[] sampleStudents = {
				new Student1("Harry Potter"),
				new Student1("Ron Weasley"),
				new Student1("Hermione Grainger"),
				new Student1("Cedric Diggory",   3),
				new Student1("Luna Lovegood"),
		};
		dir = new SchoolDirectory();
		for(int i = 0; i < sampleStudents.length; i++) {
			dir.enrollStudent(sampleStudents[i]);
		}
		
		// Provide a GUI view of the address book.
		interact = new SchoolDirectoryGUI(dir);
	}
	
	/**
	 * Main method
	 */
	public static void main(String[] args) {
		SchoolDirectoryDemo sdDemo = new SchoolDirectoryDemo();
		sdDemo.showInterface();
	}
	
	/**
	 * Allow the user to interact with the address book.
	 */
	public void showInterface()
	{
		interact.setVisible(true);
	}
	
	/**
	 * @return The sample address book.
	 */
/*	public AddressBook getBook()
	{
		return book;
	}*/

}
