import java.text.DateFormat;
import java.util.Date;

/**
 * This class models a Task.  Each task has an id, a deadline and a 
 * description.  Tasks may be marked as completed (ie they have been 
 * finished).  Each task has an estimated number of hours to complete.  
 * A task will can keep track of the number of hours spent working on it.
 * 
 * @author Clare Buckley
 * @version 20/11/2015
 */
public class Task {  
    private int id;
    private String description;
    private Deadline deadline;
    private boolean done;
    private int estimatedLength;
    private int hoursWork;

    /**
     * * Constructor objects for class Task
     */
    public Task(int id, String description, int estimatedLength)
    {       
        this.id = id;
        this.description = description;
        this.estimatedLength = estimatedLength;

        deadline = new Deadline();
        done = false;
        hoursWork = 0;
    }

    /**
     * * Methods for class Task
     */
    //Returns the id of a task
    public int getId()
    {
        return id;
    }

    //Returns the deadline of the task 
    public Deadline getDeadline()
    {
        return deadline;
    }

    //Returns the description of a task
    public String getDescription()
    {
        return description;
    }

    //Returns the value of the class' done field
    public boolean isDone()
    {
        return done;
    }

    //Returns a double value representing the percentage of the task that is complete
    public double getPercentageComplete()
    {
        double hoursWorkDouble = (double) hoursWork;
        double estimatedLengthDouble = (double) estimatedLength;
        return ((hoursWorkDouble/estimatedLengthDouble)*100);
    }

    //Determines whether the task is late, 
    //will return true if the task is not done and the deadline has passed
    public boolean isLate()
    {

        if(deadline.hasPassed()){
            return true;
        }
        else {
            return false;
        }
    }

    //Sets the task to 'done'
    public void setDone()
    {
        done = true;
    }

    //Extends the estimated time required to finish the task by the number of hours set by the parameter
    public void extendEstimate(int estimate)
    {
        estimatedLength = estimatedLength + estimate;
    }

    //Records the hours worked on the task
    public void recordHoursWorked(int hoursWorked)
    {
        hoursWork = hoursWork + hoursWorked;
    }

    //Updates the deadline of the task
    public void extendDeadline(int deadlineExtension)
    {
        deadline.setNewDeadline(deadlineExtension);  
    }

    //Builds a String to create a summary of the task
    public String getSummary()
    {
        double percentComplete = getPercentageComplete();

        StringBuilder sb = new StringBuilder();
        sb.append(id + ": ");
        sb.append(description + ": ");
        sb.append(percentComplete);
        sb.append("\n");
        return sb.toString();
    }

    //Builds a String of the task's summary
    public String toString()
    {
        return id + ": " + 
        description + ", Due: " + deadline + ": " + 
        getPercentageComplete() + "% complete, done: " + 
        done + "\n";
    }
}

