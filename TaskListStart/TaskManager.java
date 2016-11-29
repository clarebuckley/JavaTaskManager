import java.util.ArrayList;
import java.lang.StringBuilder;

/**
 * This class models a task manager. This maintains a list of Task objects, held in an ArrayList.
 * The task manager also keeps track of the unique identifier for each task created, and holds a
 * variety of methods - this includes adding tasks to the list, updating and deleting tasks
 * and for showing the contents of the list.
 * 
 * @author Clare Buckley 
 * @version 28/11/2015
 */
public class TaskManager {
    private ArrayList<Task> tasks;
    private int nextTaskId;

    /**
     * * Constructor objects for class TaskManager
     */
    public TaskManager()
    {
        tasks = new ArrayList<Task>();
        nextTaskId = 1;
    }

    /**
     * * Methods for class Task
     */
    //Returns the total number of tasks in the list
    public int getCount()
    {
        return tasks.size();
    }

    //Constructs a new task, adds the task to the 'tasks' ArrayList
    //and returns a string to confirm that the task has been added.
    public String addTask(String description, int hoursEstimate)
    {
        Task taskToAdd = new Task(nextTaskId, description, hoursEstimate);
        tasks.add(taskToAdd);
        boolean successfullyAdded;

        if (successfullyAdded = true)
        {
            nextTaskId ++;
            return "Task added.";
        }
        else
        {
            return "Error: not added.";
        }

    }

    //Searches through the list and returns a matching task with the same id
    public Task findById(int id)
    {

        for (int i = 0; i < getCount(); i++)
        {
            Task taskToReturn = tasks.get(i);
            int toTest = taskToReturn.getId();
            if (toTest == id)
            {
                return taskToReturn;
            }
        }

        return null;

    }

    //Allows the task to be marked as completed
    public Task setCompleted(int idOfCompleted)
    {
        Task completeTask = findById(idOfCompleted);

        if(completeTask != null)
        {
            completeTask.setDone();
        }

        return completeTask;

    }

    //Deletes only completed tasks that match the parameter id
    public Task deleteTask(int idTaskToDelete)
    {
        Task taskToDelete = findById(idTaskToDelete);

        if(((taskToDelete != null)) && (taskToDelete.isDone() == true))
        {
            tasks.remove(taskToDelete);
            //-tasks.remove(findById(idTaskToDelete));

        }
        else{
            return null;
        }

        return taskToDelete;
    }

    //Returns an integer value being the total number of tasks that have not been marked as complete
    public int getCountTodo()
    {       
        int notDoneCount = 0;

        for (int i = 0; i < getCount(); i++)
        {
            Task taskToReturn = tasks.get(i);
            if(taskToReturn.isDone() == false){
                notDoneCount ++;
            }
        }

        return notDoneCount;
    }

    //Returns a string of all the completed tasks
    public String getSummaryComplete()
    {
        StringBuilder sb = new StringBuilder("Tasks IDs:\n");

        for (int i = 0; i < getCount(); i++)
        {
            Task taskToReturn = tasks.get(i);
            if(taskToReturn.isDone() == true)	
            {
                String summaryOfEachTask = tasks.get(i).getSummary();
                sb.append(summaryOfEachTask);
            }
        }

        return sb.toString();
    }

    //Returns a string of all the incomplete tasks
    public String getSummaryIncomplete()
    {
        StringBuilder sb = new StringBuilder("Tasks IDs:\n");

        for (int i = 0; i < getCount(); i++)
        {
            Task taskToReturn = tasks.get(i);
            if(taskToReturn.isDone() != true)	
            {
                String summaryOfEachTask = tasks.get(i).getSummary();
                sb.append(summaryOfEachTask);
            }
        }

        return sb.toString();
    }

    //Returns a string being the full description of each task
    public String getAllTasks()
    {
        StringBuilder sb = new StringBuilder("All Tasks:\n");

        for (int i = 0; i < getCount(); i++)
        {

            String summaryOfEachTask = tasks.get(i).toString();
            sb.append(summaryOfEachTask);

        }

        return sb.toString();
    }

    //Returns a string being the full description of each incomplete task
    public String getIncompleteTasks()
    {
        StringBuilder sb = new StringBuilder("Incomplete Tasks:\n");

        for (int i = 0; i < getCount(); i++)
        {
            Task taskToReturn = tasks.get(i);
            if (taskToReturn.isDone() != true)
            {
                String summaryOfEachTask = tasks.get(i).toString();
                sb.append(summaryOfEachTask);
            }
        }

        return sb.toString();
    }

    //Returns a string containing the full description of all late tasks
    public String getLateTasks()
    {
        StringBuilder sb = new StringBuilder("Late Tasks:\n");

        for (int i = 0; i < getCount(); i++)
        {
            Task taskToReturn = tasks.get(i);
            if ((taskToReturn.isDone() == false) && (taskToReturn.isLate() == true))
            {
                // String summaryOfEachTask = tasks.get(i).toString();
                sb.append(taskToReturn);
            }
        }

        return sb.toString();
    }

    //Extends the deadline of a task which is not-yet-complete
    public Task extendDeadline(int idTaskToExtend, int deadlineExtension)
    {
        Task taskToExtend = findById(idTaskToExtend);

        for (int i = 0; i < getCount(); i++)
        {
            if (taskToExtend.isDone() == false)
            {
                taskToExtend.extendDeadline(deadlineExtension);
            }
            else
            {
                return null;
            }
        }
        return taskToExtend;
    }

    //Checks if the task is marked as completed
    public boolean checkCompleted(int idOfCompleted)
    {
        Task completeTask = findById(idOfCompleted);
        if((completeTask != null) && (completeTask.isDone()))
        {            
            return true;
        }
        else
        {
            return false;
        }

    }    

    //Records time spent working on a task
    public Task timeSpent(int idTaskToUpdate, int hoursToUpdateBy)
    {
        Task taskToUpdate = findById(idTaskToUpdate);
            if(taskToUpdate.isDone() == false)
            {
                taskToUpdate.recordHoursWorked(hoursToUpdateBy);
            }
            else
            {
                return null;
        }
        return taskToUpdate;
    }
}
