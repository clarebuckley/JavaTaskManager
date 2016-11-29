import java.util.ArrayList;

public class SchoolDirectory {

	private ArrayList<Student1> students;

	public SchoolDirectory() {
		students = new ArrayList<Student1>();
	}

	public void enrollStudent(Student1 student) {
		students.add(student);
	}

	/**public void removeStudent(Student1 student){
		Student1 studentToRemove = searchByID(studentHUN);
		if(studentToRemove !=null){
			students.remove(studentToRemove);
		}
		else {
			return null;
		}
		return studentToRemove;
	}**/

	public boolean removeStudent(Student1 student) {
		int sIndex = students.indexOf(student);
		if (sIndex == -1) {
			return false;
		}
		else {
			students.remove(sIndex);
			return true;
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("Hogwarts School Directory:\n");
		for (Student1 s : students){
			sb.append(s.toString());
			sb.append("\n");
		}
		return sb.toString();
	}

	public ArrayList<Student1> searchByKey(String key){
		//if HUN or name starts with string key --> match, corresponding student added to ArrayLIst, returned at end
		//need to turn HUN to string --> .toString()
		//.startsWith() 
		ArrayList<Student1> toReturn = new ArrayList<Student1>();
		for (Student1 s : students) {
			Integer i = new Integer(s.getHUN());
			if (s.getName().startsWith(key) || i.toString().startsWith(key)) {
				toReturn.add(s);
			}
		}
		return toReturn;
	}

	//directories are the same if the lists they contain are the same
	public boolean matchingDirectories(SchoolDirectory d) {
		if (this.students.equals(d.students)) {
		return true;	
		}
		else {
			return false;
		}
	}
}








