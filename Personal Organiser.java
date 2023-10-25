import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

class Note {
    private String content;

    public Note(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

public class PersonalOrganizer {
    private List<Task> tasks;
    private List<Note> notes;

    public PersonalOrganizer() {
        tasks = new ArrayList<>();
        notes = new ArrayList<>();
    }

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("Task added: " + description);
    }

    public void listTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println(i + 1 + ". " + task.getDescription() + " - Completed: " + task.isCompleted());
        }
    }

    public void completeTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task task = tasks.get(taskIndex);
            task.setCompleted(true);
            System.out.println("Task completed: " + task.getDescription());
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void addNote(String content) {
        Note note = new Note(content);
        notes.add(note);
        System.out.println("Note added: " + content);
    }

    public void listNotes() {
        System.out.println("Notes:");
        for (int i = 0; i < notes.size(); i++) {
            Note note = notes.get(i);
            System.out.println(i + 1 + ". " + note.getContent());
        }
    }

    public static void main(String[] args) {
        PersonalOrganizer organizer = new PersonalOrganizer();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Personal Organizer Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Add Note");
            System.out.println("5. List Notes");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String taskDescription = scanner.nextLine();
                    organizer.addTask(taskDescription);
                    break;
                case 2:
                    organizer.listTasks();
                    break;
                case 3:
                    System.out.print("Enter the index of the task to complete: ");
                    int taskIndex = scanner.nextInt() - 1;
                    organizer.completeTask(taskIndex);
                    break;
                case 4:
                    System.out.print("Enter note content: ");
                    String noteContent = scanner.nextLine();
                    organizer.addNote(noteContent);
                    break;
                case 5:
                    organizer.listNotes();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
