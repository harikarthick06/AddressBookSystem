

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        System.out.println("Welcome to Address Book Program");

        System.out.println("\nEnter details for new contact:");
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

        System.out.println("\nAll Contacts:");
        addressBook.displayAllContacts();

        System.out.print("\nEnter the first name of contact to edit: ");
        String nameToEdit = scanner.nextLine();

        ContactPerson existingContact = addressBook.findContactByFirstName(nameToEdit);

        if (existingContact != null) {
            System.out.println("Enter new details:");

            System.out.print("Enter New Last Name: ");
            String newLastName = scanner.nextLine();

            System.out.print("Enter New Address: ");
            String newAddress = scanner.nextLine();

            System.out.print("Enter New City: ");
            String newCity = scanner.nextLine();

            System.out.print("Enter New State: ");
            String newState = scanner.nextLine();

            System.out.print("Enter New Zip: ");
            String newZip = scanner.nextLine();

            System.out.print("Enter New Phone Number: ");
            String newPhoneNumber = scanner.nextLine();

            System.out.print("Enter New Email: ");
            String newEmail = scanner.nextLine();

            existingContact.editContact(newLastName, newAddress, newCity, newState, newZip, newPhoneNumber, newEmail);
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Contact not found.");
        }

        System.out.println("\nUpdated Contact List:");
        addressBook.displayAllContacts();

        scanner.close();
    }
}