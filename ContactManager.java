
    import java.util.ArrayList;
import java.util.Scanner;

    class Contact {
        private String name;
        private String phoneNumber;
        private String email;

        public Contact(String name, String phoneNumber, String email) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email: " + email;
        }
    }

    public class ContactManager {
        private ArrayList<Contact> contacts;
        private Scanner scanner;

        public ContactManager() {
            contacts = new ArrayList<>();
            scanner = new Scanner(System.in);
        }

        public void addContact() {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter phone number: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Enter email address: ");
            String email = scanner.nextLine();

            contacts.add(new Contact(name, phoneNumber, email));
            System.out.println("Contact added successfully.");
        }

        public void viewContacts() {
            if (contacts.isEmpty()) {
                System.out.println("No contacts available.");
            } else {
                for (int i = 0; i < contacts.size(); i++) {
                    System.out.println((i + 1) + ". " + contacts.get(i));
                }
            }
        }

        public void editContact() {
            System.out.print("Enter the contact number you want to edit: ");
            int index = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (index > 0 && index <= contacts.size()) {
                Contact contact = contacts.get(index - 1);

                System.out.print("Enter new phone number (leave blank to keep current): ");
                String newPhoneNumber = scanner.nextLine();
                if (!newPhoneNumber.isEmpty()) {
                    contact.setPhoneNumber(newPhoneNumber);
                }

                System.out.print("Enter new email address (leave blank to keep current): ");
                String newEmail = scanner.nextLine();
                if (!newEmail.isEmpty()) {
                    contact.setEmail(newEmail);
                }

                System.out.println("Contact updated successfully.");
            } else {
                System.out.println("Invalid contact number.");
            }
        }

        public void deleteContact() {
            System.out.print("Enter the contact number you want to delete: ");
            int index = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (index > 0 && index <= contacts.size()) {
                contacts.remove(index - 1);
                System.out.println("Contact deleted successfully.");
            } else {
                System.out.println("Invalid contact number.");
            }
        }

        public void start() {
            while (true) {
                System.out.println("\nContact Management System");
                System.out.println("1. Add Contact");
                System.out.println("2. View Contacts");
                System.out.println("3. Edit Contact");
                System.out.println("4. Delete Contact");
                System.out.println("5. Exit");

                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addContact();
                        break;
                    case 2:
                        viewContacts();
                        break;
                    case 3:
                        editContact();
                        break;
                    case 4:
                        deleteContact();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        public static void main(String[] args) {
            ContactManager manager = new ContactManager();
            manager.start();
        }
    }

