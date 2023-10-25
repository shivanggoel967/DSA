import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PersonalOrganiser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();
        HashMap<String, String> contacts = new HashMap<>();

        while (true) {
            System.out.println("Personal Organizer Menu:");
            System.out.println("1. Add a Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Add a Contact");
            System.out.println("4. View Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter a new task: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    System.out.println("Task added.");
                    break;

                case 2:
                    System.out.println("Tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    break;

                case 3:
                    System.out.print("Enter a contact name: ");
                    String contactName = scanner.nextLine();
                    System.out.print("Enter a contact number: ");
                    String contactNumber = scanner.nextLine();
                    contacts.put(contactName, contactNumber);
                    System.out.println("Contact added.");
                    break;

                case 4:
                    System.out.println("Contacts:");
                    for (Map.Entry<String, String> entry : contacts.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;

                case 5:
                    System.out.println("Exiting Personal Organizer. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

