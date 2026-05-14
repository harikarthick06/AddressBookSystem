import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// UC14 - Added CSV File Read/Write functionality
public class AddressBookMain {

    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();

        addressBook.addContact(new ContactPerson(
                "Hari", "Karthick", "Chennai", "Tamil Nadu",
                "600001", "9876543210", "hari@gmail.com"
        ));

        addressBook.addContact(new ContactPerson(
                "Arun", "Kumar", "Coimbatore", "Tamil Nadu",
                "641001", "9876543211", "arun@gmail.com"
        ));

        addressBook.addContact(new ContactPerson(
                "Rahul", "Sharma", "Bangalore", "Karnataka",
                "560001", "9876543212", "rahul@gmail.com"
        ));

        addressBook.addContact(new ContactPerson(
                "Divya", "Raj", "Chennai", "Tamil Nadu",
                "600040", "9876543213", "divya@gmail.com"
        ));

        // Duplicate contact
        addressBook.addContact(new ContactPerson(
                "Hari", "Karthick", "Madurai", "Tamil Nadu",
                "625001", "9999999999", "duplicate@gmail.com"
        ));

        System.out.println("\nSearch by City: Chennai");
        addressBook.display(addressBook.searchByCity("Chennai"));

        System.out.println("\nSearch by State: Tamil Nadu");
        addressBook.display(addressBook.searchByState("Tamil Nadu"));

        System.out.println("\nView Persons By City");
        addressBook.viewByCity().forEach((city, contacts) -> {
            System.out.println(city + " : " + contacts);
        });

        System.out.println("\nView Persons By State");
        addressBook.viewByState().forEach((state, contacts) -> {
            System.out.println(state + " : " + contacts);
        });

        System.out.println("\nCount By City");
        addressBook.countByCity().forEach((city, count) -> {
            System.out.println(city + " = " + count);
        });

        System.out.println("\nCount By State");
        addressBook.countByState().forEach((state, count) -> {
            System.out.println(state + " = " + count);
        });

        System.out.println("\nSort By Name");
        addressBook.display(addressBook.sortByName());

        System.out.println("\nSort By City");
        addressBook.display(addressBook.sortByCity());

        System.out.println("\nSort By State");
        addressBook.display(addressBook.sortByState());

        System.out.println("\nSort By Zip");
        addressBook.display(addressBook.sortByZip());

        System.out.println("\nWrite Data To File");
        addressBook.writeDataToFile("contacts.txt");

        System.out.println("\nRead Data From File");
        addressBook.readDataFromFile("contacts.txt");

        // UC14 - CSV Operations
        // Build a Contact list from existing ContactPerson list for CSV/JSON use
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("Hari", "Karthick", "12 Main Street", "Chennai", "Tamil Nadu", "600001", "9876543210", "hari@gmail.com"));
        contactList.add(new Contact("Arun", "Kumar", "45 Park Road", "Coimbatore", "Tamil Nadu", "641001", "9876543211", "arun@gmail.com"));
        contactList.add(new Contact("Rahul", "Sharma", "8 MG Road", "Bangalore", "Karnataka", "560001", "9876543212", "rahul@gmail.com"));
        contactList.add(new Contact("Divya", "Raj", "22 Anna Nagar", "Chennai", "Tamil Nadu", "600040", "9876543213", "divya@gmail.com"));

        CSVService csvService = new CSVService();

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- UC14: CSV File Operations ---");
        System.out.println("1. Write Contacts to CSV File");
        System.out.println("2. Read Contacts from CSV File");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                csvService.writeContactsToCSV(contactList);
                break;

            case 2:
                List<Contact> csvContacts = csvService.readContactsFromCSV();
                csvContacts.forEach(System.out::println);
                break;

            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}