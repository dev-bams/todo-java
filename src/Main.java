import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static ArrayList<TodoItem> todoItems = new ArrayList<>();

    public static void main(String[] args) {
        displayWelcomeMessage();
        do {
            runMenu();
        } while (true);
    }

    public static void displayWelcomeMessage() {
        System.out.println("Welcome to Taskpulse");

    }

    public static void displayMenu() {
        System.out.println("1. Display tasks");
        System.out.println("2. Create a task");
        System.out.println("3. Delete a task");
        System.out.println("4. Exit");
        System.out.print("Selection: ");
    }

    public static int getUserSelection() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void displayTasks() {
        for (TodoItem todoItem : todoItems) {
            System.out.println(todoItem);
        }
    }

    public static void addTasks() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of tasks: ");
        int noOfTasks = getUserSelection();
        for (int i = 0; i < noOfTasks; i++) {
            System.out.printf("Task %s%n", i + 1);
            System.out.print("Enter task name: ");
            String name = scanner.nextLine();
            System.out.print("Enter task priority: ");
            TodoItem.Priority priority = TodoItem.Priority.valueOf(scanner.nextLine().toUpperCase());
            UUID id = UUID.randomUUID();
            TodoItem todoItem = new TodoItem(name, priority, id);
            todoItems.add(todoItem);
        }
        System.out.println("task(s) successfully added");
    }

    public static void deleteTasks() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter task id: ");
        UUID id = UUID.fromString(scanner.nextLine());
        ArrayList<TodoItem> filteredTodoItems = new ArrayList<>();
        for (TodoItem todoItem : todoItems) {
            if (todoItem.getId().equals(id)) {
                continue;
            }
            filteredTodoItems.add(todoItem);
        }
        todoItems = filteredTodoItems;
    }

    public static void exit() {
        System.exit(0);
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    public static void runMenu() {
        displayMenu();
        int userSelection = getUserSelection();
        clearConsole();
        if (userSelection == 1) {
            displayTasks();
        } else if (userSelection == 2) {
            addTasks();
        } else if (userSelection == 3) {
            deleteTasks();
        } else if (userSelection == 4) {
            exit();
        }
    }
}