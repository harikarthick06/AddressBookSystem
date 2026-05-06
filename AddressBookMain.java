import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookMain {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, AddressBook> addressBookMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        boolean running = true;

        while (running) {
            System.out.println("\nChoose Option:");
            System.out.println("1. Add Address Book");
            System.out.println("2. Add Contact");
            System.out.println("3. Display Contacts");
            System.out.println("4. Search Person by City");
            System.out.println("5. Search Person by State");
            System.out.println("6. View Persons by City");
            System.out.println("7. View Persons by State");
            System.out.println("8. Count Persons by City");
            System.out.println("9. Count Persons by State");
            System.out.println("10. Sort Contacts by Name");
            System.out.println("11. Sort Contacts by City");
            System.out.println("12. Sort Contacts by State");
            System.out.println("13. Sort Contacts by Zip");
            System.out.println("14. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addAddressBook();
                    break;

                case 2:
                    addContact();
                    break;

                case 3:
                    displayContacts();
                    break;

                case 4:
                    searchPersonByCity();
                    break;

                case 5:
                    searchPersonByState();
                    break;

                case 6:
                    viewPersonsByCity();
                    break;

                case 7:
                    viewPersonsByState();
                    break;

                case 8:
                    countPersonsByCity();
                    break;

                case 9:
                    countPersonsByState();
                    break;

                case 10:
                    sortContactsByName();
                    break;

                case 11:
                    sortContactsByCity();
                    break;

                case 12:
                    sortContactsByState();
                    break;

                case 13:
                    sortContactsByZip();
                    break;

                case 14:
                    running = false;
                    System.out.println("Exiting Address Book Program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addAddressBook() {
        System.out.print("Enter Address Book Name: ");
        String bookName = scanner.nextLine();

        if (addressBookMap.containsKey(bookName)) {
            System.out.println("Address Book already exists.");
        } else {
            addressBookMap.put(bookName, new AddressBook());
            System.out.println("Address Book added successfully.");
        }
    }

    private static AddressBook getAddressBookFromUser() {
        System.out.print("Enter Address Book Name: ");
        String bookName = scanner.nextLine();

        AddressBook addressBook = addressBookMap.get(bookName);

        if (addressBook == null) {
            System.out.println("Address Book not found.");
        }

        return addressBook;
    }

    private static void addContact() {
        AddressBook addressBook = getAddressBookFromUser();

        if (addressBook == null) {
            return;
        }

        ContactPerson contactPerson = getContactDetails();
        addressBook.addContact(contactPerson);
    }

    private static ContactPerson getContactDetails() {
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

        return new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber, email);
    }

    private static void displayContacts() {
        AddressBook addressBook = getAddressBookFromUser();

        if (addressBook == null) {
            return;
        }

        addressBook.displayContacts();
    }

    private static void searchPersonByCity() {
        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        List<ContactPerson> result = addressBookMap.values()
                .stream()
                .flatMap(addressBook -> addressBook.getContactList().stream())
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No contacts found in city: " + city);
        } else {
            result.forEach(System.out::println);
        }
    }

    private static void searchPersonByState() {
        System.out.print("Enter State: ");
        String state = scanner.nextLine();

        List<ContactPerson> result = addressBookMap.values()
                .stream()
                .flatMap(addressBook -> addressBook.getContactList().stream())
                .filter(contact -> contact.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No contacts found in state: " + state);
        } else {
            result.forEach(System.out::println);
        }
    }

    private static void viewPersonsByCity() {
        Map<String, List<ContactPerson>> cityPersonMap = addressBookMap.values()
                .stream()
                .flatMap(addressBook -> addressBook.getContactList().stream())
                .collect(Collectors.groupingBy(ContactPerson::getCity));

        if (cityPersonMap.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        cityPersonMap.forEach((city, contacts) -> {
            System.out.println("\nCity: " + city);
            contacts.forEach(System.out::println);
        });
    }

    private static void viewPersonsByState() {
        Map<String, List<ContactPerson>> statePersonMap = addressBookMap.values()
                .stream()
                .flatMap(addressBook -> addressBook.getContactList().stream())
                .collect(Collectors.groupingBy(ContactPerson::getState));

        if (statePersonMap.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        statePersonMap.forEach((state, contacts) -> {
            System.out.println("\nState: " + state);
            contacts.forEach(System.out::println);
        });
    }

    private static void countPersonsByCity() {
        Map<String, Long> cityCountMap = addressBookMap.values()
                .stream()
                .flatMap(addressBook -> addressBook.getContactList().stream())
                .collect(Collectors.groupingBy(ContactPerson::getCity, Collectors.counting()));

        if (cityCountMap.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        cityCountMap.forEach((city, count) ->
                System.out.println(city + " : " + count));
    }

    private static void countPersonsByState() {
        Map<String, Long> stateCountMap = addressBookMap.values()
                .stream()
                .flatMap(addressBook -> addressBook.getContactList().stream())
                .collect(Collectors.groupingBy(ContactPerson::getState, Collectors.counting()));

        if (stateCountMap.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        stateCountMap.forEach((state, count) ->
                System.out.println(state + " : " + count));
    }

    private static void sortContactsByName() {
        AddressBook addressBook = getAddressBookFromUser();

        if (addressBook == null) {
            return;
        }

        addressBook.sortContactsByName();
    }

    private static void sortContactsByCity() {
        AddressBook addressBook = getAddressBookFromUser();

        if (addressBook == null) {
            return;
        }

        addressBook.sortContactsByCity();
    }

    private static void sortContactsByState() {
        AddressBook addressBook = getAddressBookFromUser();

        if (addressBook == null) {
            return;
        }

        addressBook.sortContactsByState();
    }

    private static void sortContactsByZip() {
        AddressBook addressBook = getAddressBookFromUser();

        if (addressBook == null) {
            return;
        }

        addressBook.sortContactsByZip();
    }
}