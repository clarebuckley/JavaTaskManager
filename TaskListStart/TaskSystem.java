
/**
 * This class models a task system, which controls the application. It gets input from the
 * user through commands and uses the TaskManager class to generate responses specific to
 * each command.
 * 
 * @author Clare Buckley 
 * @version 16/12/2015
 */
public class TaskSystem
{
    // instance variables 
    private InputReader reader;
    private TaskManager taskManager;

    /**
     * Constructor for objects of class TaskSystem
     */
    public TaskSystem()
    {
        // initialise instance variables
        reader = new InputReader();
        taskManager = new TaskManager();
        start();
    }

    public TaskSystem(String filename)
    {
        //initialise instance variables
        reader = new InputReader(filename);
        taskManager = new TaskManager();
        start();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     */

    public void start()
    {
        boolean finished = false;
        printGreeting();

        while(!finished) 
        {
            String input = reader.getTextInput("Please enter a command: ");

            if (input.equals("add"))
            {
                add();
            }

            if(input.equals("all"))
            {
                all();
            }

            if(input.equals("late"))
            {
                late();
            }

            if (input.equals("todo"))
            {
                toDo();
            }

            if (input.equals("done"))
            {
                done();
            }

            if (input.equals("delete"))
            {
                delete();
            }

            if (input.equals("deadline"))
            {
                deadline();
            }

            if(input.equals("countall"))
            {
                countAll();
            }

            if(input.equals("count"))
            {
                count();
            }

            if(input.equals("time"))
            {
                time();
            }

            if(input.equals("bye"))
            {
                finished = true;

            }

        }
        printGoodbye();
    }

    //prints the welcome message that will be displayed when the program starts
    private void printGreeting()
    {
        System.out.println("Welcome to the Task Management System.\n");

        //list commands used in the program
        System.out.println("Commands are:");

        System.out.println("'add' to add a task.");
        System.out.println("'all' to print all tasks.");
        System.out.println("'late' to print all late tasks.");
        System.out.println("'todo' to print all incomplete tasks.");
        System.out.println("'done' to complete a task.");
        System.out.println("'delete' to delete a task.");
        System.out.println("'deadline' to extend the deadline for a task.");
        System.out.println("'countall' to print the number of tasks.");
        System.out.println("'count' to print the number of tasks to complete.");
        System.out.println("'time' to record a number of hours working on a task.\n");

        System.out.println("Please type 'bye' to exit the system.\n");

    }

    //prints the goodbye message once the program is finished
    private void printGoodbye()
    {
        System.out.println("Goodbye!");

    }

    //asks the user for a description and the estimated length of the task in hours
    //uses that information to add a task (using the TaskManager)
    private void add()
    {
        //ask user for description and estimated length of task in hours
        System.out.println("Add a task");
        String description = reader.getTextInput("Please enter a description of the task: ");
        int hoursEstimate = reader.getIntegerInput("Please enter the estimated number of hours to complete the task: ");

        //error message for if user enters string instead of int

        System.out.println(taskManager.addTask(description, hoursEstimate) + "\n");
    }

    //prints a detailed list of all tasks
    private void all()
    {
        System.out.println(taskManager.getAllTasks() + "\n");
    }

    //prints all tasks in the program that are late
    private void late()
    {
        System.out.println(taskManager.getLateTasks() + "\n");
    }

    //prints a detailed list of all tasks that are not-yet-completed
    private void toDo()
    {
        System.out.println(taskManager.getIncompleteTasks() + "\n");
    }

    //shows the user a summary of not-yet-completed tasks
    //asks user to enter a task ID from the list and sets that task as completed
    private void done()
    {
        System.out.println(taskManager.getSummaryIncomplete() + "\n");
        if(taskManager.getCount() > 0)
        {
            int idOfCompleted = reader.getIntegerInput("Please enter the ID of the task to be set as done: ");

            //ensures that only valid ids can be entered
            if ((taskManager.findById(idOfCompleted) == null) || (taskManager.findById(idOfCompleted).isDone() == true))
            {
                System.out.println("Illegal action for task with the id " + idOfCompleted);
            }
            else
            {
                System.out.println(taskManager.setCompleted(idOfCompleted));
            }
        }
        else
        {
            System.out.println("No tasks to be set as done");
        }

    }

    //shows the user a summary list of completed tasks and asks them to enter a task ID. 
    //passes the ID to the TaskManager method that will delete the task with that ID.
    private void delete()
    {
        System.out.println(taskManager.getSummaryComplete() + "\n");
        if(taskManager.getCount() > 0)
        {
            int idTaskToDelete = reader.getIntegerInput("Please enter the ID of the task to be deleted: ");

            //ensures only valid ids can be entered
            if((taskManager.findById(idTaskToDelete) != null) && (taskManager.findById(idTaskToDelete).isDone() == true))
            {
                System.out.println("Task deleted");
                taskManager.deleteTask(idTaskToDelete);
            }           
            else
            {
                System.out.println("Illegal action for task with the id " + idTaskToDelete);
            }

        }
        else
        {
            System.out.println("No tasks to delete");
        }
    }

    //shows the user a summary list of not-yet-completed tasks and asks them to enter a task ID from that list. 
    //passes the ID to the TaskManager method that changes the deadline for the task with that ID.
    private void deadline()
    {
        System.out.println(taskManager.getSummaryIncomplete() + "\n");
        if(taskManager.getCount() > 0)
        {
            int idTaskToExtend = reader.getIntegerInput("Please enter the ID of the task's deadline you would like to extend: ");
            if (taskManager.checkCompleted(idTaskToExtend) == false)
            { 
                int daysToExtendBy = reader.getIntegerInput("Please enter the number of days to extend: ");

                //ensures that only valid ids can be entered
                if((taskManager.findById(idTaskToExtend).isDone() == true) && (taskManager.findById(idTaskToExtend) == null))
                {
                    System.out.println("Illegal action for task with the id " + idTaskToExtend);

                }
                else
                {                 
                    System.out.println("Deadline extended.");
                    System.out.println(taskManager.extendDeadline(idTaskToExtend, daysToExtendBy));

                }

            }
            else
            {
                System.out.println("Can't extend the deadline of a complete task");
            }

        }
    }

    //informs the user how many tasks are in the list
    private  void countAll()
    {
        System.out.println("Number of tasks: " + taskManager.getCount() + "\n");
    }

    //informs the user how many not-yet-completed tasks are in the list
    private void count()
    {
        System.out.println("Number of tasks to complete: " + taskManager.getCountTodo() + "\n");
    }

    //records time spent working on a task
    private void time()
    {
        System.out.println(taskManager.getSummaryIncomplete() + "\n");
        if(taskManager.getCount() > 0)
        {
            int idTime = reader.getIntegerInput("Please enter the ID of the task you wish to update: ");

            if (!taskManager.checkCompleted(idTime))
            {
                int hoursSpent = reader.getIntegerInput("Please enter the number of hours spent working on this task: ");

                //ensures that only valid ids can be entered
                if(taskManager.checkCompleted(idTime)) 
                {
                    System.out.println("Illegal action for the task with the id " + idTime);
                }
                else
                {      
                    taskManager.timeSpent(idTime, hoursSpent);
                    System.out.println("Time updated.");
                }

            }
            else
            {
                System.out.println("Task is complete therefore you can't update the time");
            }

        }
    }

}

/**
 * Bugs: 
 * Deadline extends deadline by 2x the amount the user inputs
 **/