

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, AddressBook> addressBookMap = new HashMap<>();

        System.out.println("Welcome to Address Book Program");

        String addNewBookChoice;

        do {
            System.out.print("\nEnter Address Book Name: ");
            String bookName = scanner.nextLine();

            if (addressBookMap.containsKey(bookName)) {
                System.out.println("Address Book with this name already exists.");
            } else {
                AddressBook addressBook = new AddressBook();
                addressBookMap.put(bookName, addressBook);
                System.out.println("Address Book '" + bookName + "' created successfully.");

                String addContactChoice;
                do {
                    System.out.println("\nEnter contact details for Address Book: " + bookName);

                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();

                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();

                    System.out.print("Enter State: ");
                    String state = scanner.nextLine();

                    System.out.print("Enter Zip: ");
                    String zip = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    ContactPerson person = new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber, email);
                    addressBook.addContact(person);

                    System.out.print("Do you want to add another contact to this Address Book? (yes/no): ");
                    addContactChoice = scanner.nextLine();

                } while (addContactChoice.equalsIgnoreCase("yes"));
            }

            System.out.print("\nDo you want to add another Address Book? (yes/no): ");
            addNewBookChoice = scanner.nextLine();

        } while (addNewBookChoice.equalsIgnoreCase("yes"));

        System.out.println("\nDisplaying All Address Books:");

        for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
            System.out.println("\nAddress Book Name: " + entry.getKey());
            entry.getValue().displayAllContacts();
        }

        scanner.close();
    }
}