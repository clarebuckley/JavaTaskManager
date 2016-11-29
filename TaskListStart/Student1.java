

/**
 * Student1 represents a student at Hogwart's school
 *
 * @author Ian T. Nabney
 * @version 0.1 (15 Dec 2004)
 */

public class Student1 {
	private static int lastHUN = 0;
	private int HUN;    // The Hogwart's Universal Number
	private int year;
	private String name;

	/**
	 * Creates a student starting at an arbitrary year
	 */
	public Student1(String name, int year) {
		this.HUN = nextHUN();   
		this.year = year;
		this.name = name;
	}

	/**
	 * Usual constructor, creating a student starting in year 1
	 */
	public Student1(String name) {
		this(name, 1);
	}

	/**
	 * Accesses name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Accesses HUN
	 */
	public int getHUN() {
		return HUN;
	}

	/**
	 * Tests for equality.  Two students are the same if they 
	 * have the same HUN.
	 */
	public boolean equals(Object o) {
		if (o instanceof Student1) {
			if (this.HUN == ((Student1)(o)).HUN)
				return true;
			else
				return false;
		}

		else {
			return false;
		}
	}

	/**
	 * Returns a <code>String</code> representation of the student
	 */
	public String toString() {
		return (name + ", year " + year + ", HUN " + HUN);
	}

	/**
	 * Helper method to generate next valid HUN by incrementing 
	 * {@link #lastHUN}
	 */
	private static int nextHUN() {
		return ++lastHUN;
	}

}
